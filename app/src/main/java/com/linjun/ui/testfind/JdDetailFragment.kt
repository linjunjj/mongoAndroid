package com.linjun.ui.testfind
import `in`.srain.cube.views.ptr.PtrDefaultHandler
import `in`.srain.cube.views.ptr.PtrFrameLayout
import `in`.srain.cube.views.ptr.PtrHandler
import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.linjun.R
import com.linjun.bean.FreshNewsBean
import com.linjun.bean.JdBaseBean
import com.linjun.bean.JdDetailBean
import com.linjun.component.ApplicationComponent
import com.linjun.component.DaggerHttpComponent
import com.linjun.net.JanDanApi
import com.linjun.ui.base.BaseFragment
import com.linjun.ui.find.contract.JanDanContract
import com.linjun.ui.find.presenter.JanDanPresenter
import com.linjun.widget.CustomLoadMoreView
import com.linjun.widget.SimpleMultiStateView
import kotlinx.android.synthetic.main.fragment_jd_detail.*


/**
 * desc: 煎蛋 .
 * author: Will .
 * date: 2017/12/9 .
 */

@SuppressLint("ValidFragment")
class JdDetailFragment constructor
(private val mAdapter: BaseQuickAdapter<in JdBaseBean, BaseViewHolder>) : BaseFragment<JanDanPresenter>(), JanDanContract.View {
    private var pageNum = 1

    /**
     * 类型
     * @see com.will.weiyuekotlin.net.JanDanApi.Type
     */
    private lateinit var type: String

    companion object {
        fun newInstance(type: String, baseQuickAdapter: BaseQuickAdapter<in JdBaseBean, BaseViewHolder>): JdDetailFragment {
            val args = Bundle()
            args.putCharSequence("type", type)
            val fragment = JdDetailFragment(baseQuickAdapter)
            fragment.arguments = args
            return fragment
        }
    }

    override fun getContentLayout(): Int = R.layout.fragment_jd_detail

    override fun getSimpleMultiStateView(): SimpleMultiStateView? = simpleMultiStateViews

    override fun initInjector(appComponent: ApplicationComponent) {
        DaggerHttpComponent.builder()
                .applicationComponent(appComponent)
                .build()
                .inject(this)
    }

    override fun bindView(view: View, savedInstanceState: Bundle?) {
        ptrFrameLayout.disableWhenHorizontalMove(true)
        ptrFrameLayout.setPtrHandler(object : PtrHandler {
            override fun checkCanDoRefresh(frame: PtrFrameLayout, content: View, header: View): Boolean {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, recyclerView, header)
            }

            override fun onRefreshBegin(frame: PtrFrameLayout) {
                pageNum = 1
                mPresenter?.getData(type, pageNum)

            }
        })

        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = mAdapter
        mAdapter.setEnableLoadMore(true)
        mAdapter.setPreLoadNumber(1)
        mAdapter.setLoadMoreView(CustomLoadMoreView())
        mAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN)
        mAdapter.setOnLoadMoreListener({ mPresenter?.getData(type, pageNum) }, recyclerView)
        mAdapter.setOnItemClickListener { adapter, view, position ->
            if (type == JanDanApi.TYPE_FRESH) {
                ReadActivity.launch(activity, adapter.getItem(position) as FreshNewsBean.PostsBean)
            }
        }
    }

    override fun initData() {
        if (arguments == null) return
        type = arguments.getString("type")
        mPresenter?.getData(type, pageNum)
    }

    /**
     * 加载新鲜事列表
     *
     * @param freshNewsBean 新鲜事列表
     */
    override fun loadFreshNews(freshNewsBean: FreshNewsBean?) {
        when (freshNewsBean) {
            null -> {
                ptrFrameLayout.refreshComplete()
                showError()
            }
            else -> {
                pageNum++
                mAdapter.setNewData(freshNewsBean.posts)
                ptrFrameLayout.refreshComplete()
                showSuccess()
            }
        }
    }

    /**
     * 加载更多新鲜事列表
     *
     * @param freshNewsBean 新鲜事列表
     */
    override fun loadMoreFreshNews(freshNewsBean: FreshNewsBean?) {
        when (freshNewsBean) {
            null -> mAdapter.loadMoreFail()
            else -> {
                pageNum++
                mAdapter.addData(freshNewsBean.posts!!)
                mAdapter.loadMoreComplete()
            }
        }
    }

    /**
     * 加载 无聊图、妹子图、段子列表
     *
     * @param type  [com.will.weiyuekotlin.net.JanDanApi.Type]
     * @param jdDetailBean 数据列表
     */
    override fun loadDetailData(type: String, jdDetailBean: JdDetailBean?) {
        when (jdDetailBean) {
            null -> {
                ptrFrameLayout.refreshComplete()
                showError()
            }
            else -> {
                pageNum++
                mAdapter.setNewData(jdDetailBean.comments)
                ptrFrameLayout.refreshComplete()
                showSuccess()
            }
        }
    }

    /**
     * 加载更多 无聊图、妹子图、段子列表
     *
     * @param type  [com.will.weiyuekotlin.net.JanDanApi.Type]
     * @param jdDetailBean 数据列表
     */
    override fun loadMoreDetailData(type: String, jdDetailBean: JdDetailBean?) {
        when (jdDetailBean) {
            null -> mAdapter.loadMoreFail()
            else -> {
                pageNum++
                mAdapter.addData(jdDetailBean.comments!!)
                mAdapter.loadMoreComplete()
            }
        }
    }

}