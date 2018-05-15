package com.linjun

import org.litepal.LitePalApplication
import kotlin.properties.Delegates

class  MyApp : LitePalApplication(){
    companion object {
        var instance: MyApp by Delegates.notNull()
        var mApplicationComponent: ApplicationComponent by Delegates.notNull()
    }
}