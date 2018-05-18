package com.linjun

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.linjun.component.ApplicationComponent
import com.linjun.mongoandroid.R
import com.linjun.ui.base.BaseActivity
import com.linjun.ui.base.BaseContract
import com.linjun.widget.BottomBarTab
import com.linjun.widget.SimpleMultiStateView
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<BaseContract.BasePresenter>() {

    override fun getContentLayout(): Int {
        return R.layout.activity_main
    }

    override fun getSimpleMultiStateView(): SimpleMultiStateView? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initInjector(appComponent: ApplicationComponent) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun bindView(view: View, savedInstanceState: Bundle?) {
        mBootomBar.addItem(BottomBarTab(this, R.drawable.home, "首页"))
        mBootomBar.addItem(BottomBarTab(this, R.drawable.message, "首页"))

        mBootomBar.addItem(BottomBarTab(this, R.drawable.message, "首页"))
        mBootomBar.addItem(BottomBarTab(this, R.drawable.message, "我的"))
    }

    override fun initData() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressedSupport() {
        if (JCVideoPlayer.backPress()){
            return
        }
        super.onBackPressedSupport()
    }

    override fun onPause() {
        super.onPause()
        JCVideoPlayer.releaseAllVideos()
    }
}
