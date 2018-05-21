package com.linjun

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.linjun.component.ApplicationComponent
import com.linjun.model.PopMenuItem
import com.linjun.ui.base.BaseActivity
import com.linjun.ui.base.BaseContract
import com.linjun.ui.base.SupportFragment
import com.linjun.ui.personal.PersonalFragment
import com.linjun.utils.StatusBarUtil
import com.linjun.widget.BottomBar
import com.linjun.widget.BottomBarCenterTab
import com.linjun.widget.BottomBarTab
import com.linjun.widget.SimpleMultiStateView
import com.linjun.widget.popmenu.PopMenu
import com.linjun.widget.popmenu.PopMenuItemListener
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<BaseContract.BasePresenter>() {
    private val mFragments = arrayOfNulls<SupportFragment>(5)
    override fun getContentLayout(): Int = R.layout.activity_main
    private var mPopMenu: PopMenu? = null
    override fun getSimpleMultiStateView(): SimpleMultiStateView? = null

    override fun initInjector(appComponent: ApplicationComponent) {}

    override fun bindView(view: View, savedInstanceState: Bundle?) {
        StatusBarUtil.setTranslucentForImageViewInFragment(this@MainActivity, 0, null)
        if (savedInstanceState==null){
           mFragments[0]=PersonalFragment.newInstance()
            mFragments[1]=PersonalFragment.newInstance()
            mFragments[3]=PersonalFragment.newInstance()
            mFragments[4]=PersonalFragment.newInstance()

            supportDelegate.loadMultipleRootFragment(R.id.contentContainer, 0,
                    mFragments[0],
                    mFragments[1],
                    mFragments[3],
                    mFragments[4])
        }else{
            mFragments[0] = findFragment(PersonalFragment::class.java)
            mFragments[1] = findFragment(PersonalFragment::class.java)
            mFragments[3] = findFragment(PersonalFragment::class.java)
            mFragments[4] = findFragment(PersonalFragment::class.java)
        }
        mBootomBar.addItem(BottomBarTab(this, R.drawable.home, "首页"),0)
        mBootomBar.addItem(BottomBarTab(this, R.drawable.message, "消息"),1)
        mBootomBar.addCenterItem(BottomBarCenterTab(this,R.drawable.tabbar_compose_icon_add))
        mBootomBar.addItem(BottomBarTab(this, R.drawable.find, "发现"),3)
        mBootomBar.addItem(BottomBarTab(this, R.drawable.me, "我的"),4)
        mPopMenu = PopMenu.Builder().attachToActivity(this@MainActivity)
                .addMenuItem(PopMenuItem("文字", resources.getDrawable(R.drawable.tabbar_compose_idea)))
                .addMenuItem(PopMenuItem("照片/视频",resources.getDrawable(R.drawable.tabbar_compose_idea)))
                .addMenuItem(PopMenuItem("头条文章", resources.getDrawable(R.drawable.tabbar_compose_idea)))
                .addMenuItem(PopMenuItem("签到", resources.getDrawable(R.drawable.tabbar_compose_idea)))
                .addMenuItem(PopMenuItem("点评", resources.getDrawable(R.drawable.tabbar_compose_idea)))
                .addMenuItem(PopMenuItem("更多", resources.getDrawable(R.drawable.tabbar_compose_idea)))
                .setOnItemClickListener(object : PopMenuItemListener {
                    override fun onItemClick(popMenu: PopMenu, position: Int) {
                        Toast.makeText(this@MainActivity, "你点击了第" + position + "个位置", Toast.LENGTH_SHORT).show()
                    }
                })
                .build()

        mBootomBar.setOnTabSelectedListener(object : BottomBar.OnTabSelectedListener  {
            override fun onTabSelected(position: Int, prePosition: Int) {
               if(position==2){
                   mPopMenu?.show()
                   System.out.println(position)
               }else{
                   supportDelegate.showHideFragment(mFragments[position], mFragments[prePosition])
               }
            }
            override fun onTabUnselected(position: Int) {

            }
            override fun onTabReselected(position: Int) {

            }

        })





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
