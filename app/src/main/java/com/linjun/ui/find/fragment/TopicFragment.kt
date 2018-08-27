//package com.linjun.ui.find.fragment
//
//import android.annotation.SuppressLint
//import android.os.Bundle
//import android.view.View
//import com.chad.library.adapter.base.BaseQuickAdapter
//import com.chad.library.adapter.base.BaseViewHolder
//import com.linjun.R
//import com.linjun.bean.HomeBean
//import com.linjun.bean.JdBaseBean
//import com.linjun.component.ApplicationComponent
//import com.linjun.component.DaggerHttpComponent
//import com.linjun.showToast
//import com.linjun.ui.base.BaseFragment
//import com.linjun.ui.find.contract.TopicContract
//import com.linjun.ui.find.presenter.TopicPresenter
//import com.linjun.widget.SimpleMultiStateView
//import kotlinx.android.synthetic.main.fragment_topic.*
//
//@SuppressLint("ValidFragment")
//class TopicFragment constructor
//(private val mAdapter: BaseQuickAdapter<in JdBaseBean, BaseViewHolder>) : BaseFragment<TopicPresenter>(), TopicContract.View {
//      companion object {
//          fun newInstance(baseQuickAdapter:BaseQuickAdapter<in JdBaseBean,BaseViewHolder>):TopicFragment{
//              val fragment = TopicFragment(baseQuickAdapter)
//              return fragment
//          }
//      }
//
//
//
//    override fun setRankList(itemList: HomeBean.Issue?) {
//         when(itemList){
//            null->mAdapter.loadMoreFail()
//             else->{
//                 mAdapter.addData(itemList)
//                 mAdapter.loadMoreComplete()
//             }
//         }
//    }
//
//    override fun initData() {
//        mPresenter?.requestRankList()
//    }
//
//    override fun bindView(view: View, savedInstanceState: Bundle?) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun initInjector(appComponent: ApplicationComponent) {
//        DaggerHttpComponent.builder()
//                .applicationComponent(appComponent)
//                .build()
//                .inject(this)
//    }
//
//    override fun getSimpleMultiStateView(): SimpleMultiStateView?=simpleMultiStateViews
//
//    override fun getContentLayout(): Int = R.layout.fragment_topic
//
//    override fun showError(errorMsg: String, errorCode: Int) {
//        showToast(errorMsg)
//    }
//
//
//
//}