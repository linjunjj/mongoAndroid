package com.linjun

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.linjun.component.ApplicationComponent
import com.linjun.mongoandroid.R
import com.linjun.ui.base.BaseActivity
import com.linjun.ui.base.BaseContract
import com.linjun.widget.SimpleMultiStateView

class MainActivity : BaseActivity<BaseContract.BasePresenter>() {

    override fun getContentLayout(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSimpleMultiStateView(): SimpleMultiStateView? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initInjector(appComponent: ApplicationComponent) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun bindView(view: View, savedInstanceState: Bundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initData() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
