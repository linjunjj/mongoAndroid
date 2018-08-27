package com.linjun.net

import com.linjun.bean.HomeBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Url

interface TopicApiService{

    @GET("v4/rankList")
    fun getRankList(@Url url: String): Observable<HomeBean.Issue>
}