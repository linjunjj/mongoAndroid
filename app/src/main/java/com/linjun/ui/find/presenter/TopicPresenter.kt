package com.linjun.ui.find.presenter

import com.linjun.bean.FreshNewsBean
import com.linjun.bean.HomeBean
import com.linjun.net.BaseObserver
import com.linjun.net.TopicApi
import com.linjun.ui.base.BasePresenter
import com.linjun.ui.find.contract.TopicContract
import com.linjun.utils.applySchedulers
import javax.inject.Inject

class TopicPresenter @Inject
constructor(private var mTopicApi:TopicApi):BasePresenter<TopicContract.View>(),TopicContract.Presenter{
    override fun requestRankList() {
         mTopicApi.requestRankList()
                 .applySchedulers()
                 .compose(mView?.bindToLife<HomeBean.Issue>())
                 .subscribe(object : BaseObserver<HomeBean.Issue>() {
                     override fun onSuccess(t: HomeBean.Issue?) {
                        mView?.setRankList(t)
                     }
                     override fun onFail(e: Throwable) {

                     }
                 })
    }


}