package com.linjun.module

import android.content.Context
import com.linjun.MyApp
import dagger.Module
import dagger.Provides
@Module
class  ApplicationModule(private  val  mContext:Context){
    @Provides
  internal fun  provideApplication():MyApp{
        return  mContext.applicationContext as MyApp
    }
    @Provides
   internal  fun  provideContext():Context {
        return  mContext
    }
}