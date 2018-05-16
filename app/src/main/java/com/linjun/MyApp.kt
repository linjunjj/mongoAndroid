package com.linjun

import cn.bingoogolapple.swipebacklayout.BGASwipeBackManager
import com.linjun.component.ApplicationComponent
import com.linjun.component.DaggerApplicationComponent
import com.linjun.module.ApplicationModule
import com.linjun.module.HttpModule
import org.litepal.LitePal
import org.litepal.LitePalApplication
import kotlin.properties.Delegates

class  MyApp : LitePalApplication(){
    companion object {
        var instance: MyApp by Delegates.notNull()
        var mApplicationComponent: ApplicationComponent by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .httpModule(HttpModule())
                .build()
        //初始化数据库
        LitePal.initialize(this)
        //初始化侧滑返回组件
        BGASwipeBackManager.getInstance().init(this)
    }
}