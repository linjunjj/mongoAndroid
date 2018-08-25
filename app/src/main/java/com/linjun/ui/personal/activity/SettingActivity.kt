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
import com.linjun.ui.personal.activity.setting.AboutActivity
import com.linjun.ui.personal.activity.setting.ChangePasswordActivity
import com.linjun.ui.personal.activity.setting.IdentityActivity
import com.linjun.ui.personal.activity.setting.SuggestActivity
import com.linjun.utils.StatusBarUtil
import com.linjun.widget.SimpleMultiStateView
import kotlinx.android.synthetic.main.activity_setting.*


class SettingActivity: BaseActivity<BaseContract.BasePresenter>(),View.OnClickListener{

    companion object {
        fun launch(context: Activity, selectedIndex: Int){
            val intent = Intent(context, SettingActivity::class.java)
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
        img_back.setOnClickListener(this)
        txt_ident.setOnClickListener(this)
        txt_changePassword.setOnClickListener(this)
        txt_feedback.setOnClickListener(this)
        txt_about.setOnClickListener(this)
    }

    override fun initData() {}

    override fun getContentLayout(): Int = R.layout.activity_setting

    override fun onClick(v: View?) {
        when{
            v?.id==R.id.img_back ->{this.finish()}
            v?.id==R.id.txt_ident ->{
                IdentityActivity.launch(this,0) }
            v?.id==R.id.txt_changePassword ->{
                ChangePasswordActivity.launch(this,0)
            }
            v?.id==R.id.txt_feedback ->{
                SuggestActivity.launch(this,0)
            }
            v?.id==R.id.txt_about ->{
                AboutActivity.launch(this,0)
            }

            }

        }

}