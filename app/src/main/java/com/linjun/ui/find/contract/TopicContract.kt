package com.linjun.ui.find.contract

import com.linjun.bean.HomeBean
import com.linjun.ui.base.BaseContract

interface TopicContract {

    interface View: BaseContract.BaseView {
        /**
         * 设置排行榜的数据
         */
        fun setRankList(itemList: HomeBean.Issue?)

        fun showError(errorMsg:String,errorCode:Int)
    }


    interface Presenter:BaseContract.BasePresenter{
        /**
         * 获取 TabInfo
         */
        fun requestRankList()
    }
}