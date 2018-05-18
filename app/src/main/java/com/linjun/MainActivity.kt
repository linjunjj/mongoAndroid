package com.linjun

import android.os.Bundle
import android.view.View
import com.linjun.component.ApplicationComponent
import com.linjun.ui.base.BaseActivity
import com.linjun.ui.base.BaseContract
import com.linjun.utils.StatusBarUtil
import com.linjun.widget.BottomBarTab
import com.linjun.widget.SimpleMultiStateView
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<BaseContract.BasePresenter>() {

    override fun getContentLayout(): Int = R.layout.activity_main

    override fun getSimpleMultiStateView(): SimpleMultiStateView? = null

    override fun initInjector(appComponent: ApplicationComponent) {}

    override fun bindView(view: View, savedInstanceState: Bundle?) {
        StatusBarUtil.setTranslucentForImageViewInFragment(this@MainActivity, 0, null)

        mBootomBar.addItem(BottomBarTab(this, R.drawable.ic_news, "首页"))
        mBootomBar.addItem(BottomBarTab(this, R.drawable.ic_news, "消息"))
        mBootomBar.addItem(BottomBarTab(this, R.drawable.ic_news, "发现"))
        mBootomBar.addItem(BottomBarTab(this, R.drawable.ic_news, "我的"))
        mBootomBar.addItem(BottomBarTab(this, R.drawable.ic_news, "我的"))

    }

    override fun initData() {

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
