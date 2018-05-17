package com.linjun.module

import com.linjun.MyApp
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.io.File

@Module
class HttpModule {
    @Provides
    internal fun provideOkHttpClient():OkHttpClient.Builder{
        val cache=Cache(File(MyApp.instance.cacheDir,"HttpCache"),(1024*1024*100).toLong())
        return OkHttpClient().newBuilder().cache(cache)
                .retryOnConnectionFailure(true)

    }

}