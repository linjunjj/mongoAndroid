package com.linjun.component

import android.content.Context
import com.linjun.MyApp
import com.linjun.module.ApplicationModule
import com.linjun.module.HttpModule
import dagger.Component

@Component(modules = [(ApplicationModule::class), (HttpModule::class)])
interface ApplicationComponent{
    val application: MyApp
    val context: Context

}