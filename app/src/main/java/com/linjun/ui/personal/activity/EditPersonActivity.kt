package com.linjun.ui.personal.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import com.linjun.R
import com.linjun.component.ApplicationComponent
import com.linjun.ui.base.BaseActivity
import com.linjun.ui.base.BaseContract
import com.linjun.utils.StatusBarUtil
import com.linjun.widget.SimpleMultiStateView

class EditPersonActivity: BaseActivity<BaseContract.BasePresenter>(){

    companion object {
        fun launch(context: Activity, selectedIndex: Int){
            val intent = Intent(context, EditPersonActivity::class.java)
            intent.putExtra("selectedIndex", selectedIndex)
            context.startActivity(intent)
            context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }
    }

    override fun getSimpleMultiStateView(): SimpleMultiStateView? =null

    override fun initInjector(appComponent: ApplicationComponent) {
    }

    override fun bindView(view: View, savedInstanceState: Bundle?) {
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, android.R.color.white))
    }

    override fun initData() {}

    override fun getContentLayout(): Int = R.layout.activity_login


}