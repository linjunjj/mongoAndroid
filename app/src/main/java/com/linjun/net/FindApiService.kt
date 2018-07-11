package com.linjun.net

import com.linjun.bean.HappyBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface FindApiService {

    @GET
    fun getDetailData(@Url url: String, @Query("oxwlxojflwblxbsapi") oxwlxojflwblxbsapi: String,
                      @Query("page") page: Int
    ): Observable<HappyBean>


}