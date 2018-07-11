package com.linjun.net

import android.support.annotation.StringDef
import com.linjun.bean.HappyBean

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.util.*

class  FindApi (private  val mService :FindApiService ){
    companion object {
        const val TYPE_BORED = "jandan.get_pic_comments"
       private var sInstance:FindApi?=null
        fun getInstance(findApiService: FindApiService):FindApi{
            if (sInstance==null)
                sInstance= FindApi(findApiService)
            return sInstance as FindApi
        }
    }
    @StringDef(TYPE_BORED)
    @Retention(RetentionPolicy.SOURCE)
    annotation class Type

    fun getHapply(@Type type: String, page: Int): io.reactivex.Observable<HappyBean> {
        return mService.getDetailData(ApiConstants.sHapplyApi, type, page)
    }

}