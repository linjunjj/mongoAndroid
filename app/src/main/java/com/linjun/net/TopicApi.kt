package com.linjun.net

import com.linjun.bean.FreshNewsBean
import com.linjun.bean.HomeBean
import io.reactivex.Observable
import java.util.*

class TopicApi(private val mService:TopicApiService){
    companion object {
        private var sInstance:TopicApi?=null
        fun getInstance(topicApiService: TopicApiService): JanDanApi {
            if (sInstance == null)
                sInstance = TopicApi(topicApiService)
            return sInstance as JanDanApi
        }
    }
    fun  requestRankList(): Observable<HomeBean.Issue> {
      return mService.getRankList(ApiConstants.sTopicUrl)
    }

}