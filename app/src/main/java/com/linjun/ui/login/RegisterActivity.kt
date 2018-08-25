package com.linjun.ui.login

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
import kotlinx.android.synthetic.main.activity_register.*


class RegisterActivity: BaseActivity<BaseContract.BasePresenter>(), View.OnClickListener{

    companion object {
        fun launch(context: Activity, selectedIndex: Int){
            val intent = Intent(context, RegisterActivity::class.java)
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


    }

    override fun initData() {}

    override fun getContentLayout(): Int = R.layout.activity_register
    override fun onClick(v: View?) {
        when{
            v?.id== R.id.img_back ->{
                this.finish()
            }
        }
    }

}