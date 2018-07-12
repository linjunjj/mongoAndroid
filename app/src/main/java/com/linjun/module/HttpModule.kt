package com.linjun.module

import com.linjun.MyApp
import com.linjun.net.ApiConstants
import com.linjun.net.FindApi
import com.linjun.net.FindApiService
import com.linjun.net.RetrofitConfig
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

@Module
class HttpModule {
    @Provides
    internal fun provideOkHttpClient(): OkHttpClient.Builder {
        // 指定缓存路径,缓存大小100Mb
        val cache = Cache(File(MyApp.instance.cacheDir, "HttpCache"),
                (1024 * 1024 * 100).toLong())
        return OkHttpClient().newBuilder().cache(cache)
                .retryOnConnectionFailure(true)
                .addInterceptor(RetrofitConfig.sLoggingInterceptor)
                .addInterceptor(RetrofitConfig.sRewriteCacheControlInterceptor)
                .addNetworkInterceptor(RetrofitConfig.sRewriteCacheControlInterceptor)
                .connectTimeout(10, TimeUnit.SECONDS)
    }
    @Provides
    internal fun provideFindApis(builder: OkHttpClient.Builder): FindApi {

        val retrofitBuilder = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())

        return FindApi.getInstance(retrofitBuilder
                .baseUrl(ApiConstants.sHapplyApi)
                .build().create(FindApiService::class.java))
    }

}