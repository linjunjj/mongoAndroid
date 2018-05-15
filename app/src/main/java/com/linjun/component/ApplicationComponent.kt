package com.linjun.component

import android.content.Context
import com.linjun.MyApp
import dagger.Component

@Component(modules = [])
interface ApplicationComponent{
    val application: MyApp
    val context: Context

}