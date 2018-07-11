package com.linjun.ui.find.presenter

import com.linjun.bean.HappyBean
import com.linjun.net.BaseObserver
import com.linjun.net.FindApi
import com.linjun.ui.base.BasePresenter
import com.linjun.ui.find.contract.HapplyContract
import com.linjun.utils.applySchedulers
import javax.inject.Inject

class HapplyPresenter @Inject
constructor(private var mJanDanApi: FindApi) : BasePresenter<HapplyContract.View>(), HapplyContract.Presenter {

    /**
     * 获取新鲜事,无聊图、妹子图、段子列表
     *
     * @param type  [com.will.weiyuekotlin.net.JanDanApi.Type]
     * @param page 获取数据数量
     */
    override fun getData(type: String, page: Int) {

            getDetailData(type, page)

    }



    /**
     * 获取无聊图、妹子图、段子列表
     *
     * @param type  [com.will.weiyuekotlin.net.JanDanApi.Type]
     * @param page 获取数据数量
     */
    override fun getDetailData(type: String, page: Int) {
        mJanDanApi.getHapply(type, page)
                .applySchedulers()
                .compose(mView?.bindToLife<HappyBean>())
                .map({ happlyBean ->
                    happlyBean.comments!!
                            .asSequence()
                            .filter { it.pics != null }
                            .forEach {
                                when {
                                    it.pics!!.size > 1 -> it.viewType = HappyBean.CommentsBean.TYPE_MULTIPLE
                                    else -> it.viewType = HappyBean.CommentsBean.TYPE_SINGLE
                                }
                            }
                    happlyBean
                })
                .subscribe(object : BaseObserver<HappyBean>() {
                    override fun onSuccess(t: HappyBean?) {
                        when {
                            page > 1 -> mView?.loadMoreDetailData(type, t)
                            else -> mView?.loadDetailData(type, t)
                        }
                    }

                    override fun onFail(e: Throwable) {
                        when {
                            page > 1 -> mView?.loadMoreDetailData(type, null)
                            else -> mView?.loadDetailData(type, null)
                        }
                    }
                })
    }
}
