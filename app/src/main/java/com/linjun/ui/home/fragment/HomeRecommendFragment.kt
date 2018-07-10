package com.linjun.ui.home.fragment

import `in`.srain.cube.views.ptr.PtrDefaultHandler
import `in`.srain.cube.views.ptr.PtrFrameLayout
import `in`.srain.cube.views.ptr.PtrHandler
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bigkoo.convenientbanner.ConvenientBanner
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator
import com.bigkoo.convenientbanner.holder.Holder
import com.bigkoo.convenientbanner.listener.OnItemClickListener
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.linjun.R
import com.linjun.R.id.convenientBanner
import com.linjun.bean.RecommendBean
import com.linjun.component.ApplicationComponent
import com.linjun.component.DaggerHttpComponent
import com.linjun.ui.base.BaseContract
import com.linjun.ui.base.BaseFragment
import com.linjun.widget.SimpleMultiStateView
import kotlinx.android.synthetic.main.banner.*
import kotlinx.android.synthetic.main.fragment_recommend.*

@SuppressLint("ValidFragment")
class HomeRecommendFragment constructor
(private  val mAdapter: BaseQuickAdapter<in RecommendBean,BaseViewHolder>):BaseFragment<BaseContract.BasePresenter>(),BaseContract.BaseView{
    private var pageNum =1
    private  lateinit var type : String

    private val listBanner ={"f"}

    companion object {
        fun newInstance(type:String,baseQuickAdapter: BaseQuickAdapter<in RecommendBean,BaseViewHolder>):HomeRecommendFragment{
            val args=Bundle()
            args.putCharSequence("type",type)
            val fragment =HomeRecommendFragment(baseQuickAdapter)
            fragment.arguments=args
            return fragment
        }
    }

    override fun getContentLayout(): Int {
        return R.layout.fragment_recommend
    }

    override fun getSimpleMultiStateView(): SimpleMultiStateView? {
        return simpleMultiStateView
    }

    override fun initInjector(appComponent: ApplicationComponent) {
         DaggerHttpComponent.builder()
                 .applicationComponent(appComponent)
                 .build()
                 .inject(this)
    }

    override fun bindView(view: View, savedInstanceState: Bundle?) {



        convenientBanner.setPages(object : CBViewHolderCreator {
            override fun createHolder(): Holder<String> {
                return ImageHolder()
            }
        }, listBanner)
                .setPageIndicator(intArrayOf(R.drawable.ic_dot_normal, R.drawable.ic_dot_pressed))
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)

        if (!convenientBanner.isTurning) {
            convenientBanner.startTurning(4000)
        }

        layout_refresh.disableWhenHorizontalMove(true)
        layout_refresh.setPtrHandler(object : PtrHandler {
            override fun checkCanDoRefresh(frame: PtrFrameLayout, content: View, header: View): Boolean {
                return false
            }

            override fun onRefreshBegin(frame: PtrFrameLayout) {
                pageNum = 1


            }
        })
    }






    override fun initData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



}
