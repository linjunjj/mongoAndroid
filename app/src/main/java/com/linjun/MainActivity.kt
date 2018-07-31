package com.linjun

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.linjun.component.ApplicationComponent
import com.linjun.model.PopMenuItem
import com.linjun.ui.base.BaseActivity
import com.linjun.ui.base.BaseContract
import com.linjun.ui.base.SupportFragment
import com.linjun.ui.find.FindFragment
import com.linjun.ui.home.HomeFragment
import com.linjun.ui.home.fragment.HomeRecommendFragment
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
           mFragments[0]=HomeFragment.newInstance()
            mFragments[1]=FindFragment.newInstance()
            mFragments[3]=PersonalFragment.newInstance()
            mFragments[4]=PersonalFragment.newInstance()

            supportDelegate.loadMultipleRootFragment(R.id.contentContainer, 0,
                    mFragments[0],
                    mFragments[1],
                    mFragments[3],
                    mFragments[4])
        }else{
            mFragments[0] = findFragment(HomeRecommendFragment::class.java)
            mFragments[1] = findFragment(FindFragment::class.java)
            mFragments[3] = findFragment(PersonalFragment::class.java)
            mFragments[4] = findFragment(PersonalFragment::class.java)
        }
        mBootomBar.addItem(BottomBarTab(this, R.drawable.home,R.drawable.press_home ,"首页"),0)
        mBootomBar.addItem(BottomBarTab(this, R.drawable.find,R.drawable.press_find, "发现"),1)
        mBootomBar.addCenterItem(BottomBarCenterTab(this,0,null))
        mBootomBar.addItem(BottomBarTab(this, R.drawable.message,R.drawable.press_message, "消息"),3)
        mBootomBar.addItem(BottomBarTab(this, R.drawable.me,R.drawable.press_me, "我的"),4)
        mPopMenu = PopMenu.Builder().attachToActivity(this@MainActivity)
                .addMenuItem(PopMenuItem("发布跑腿", resources.getDrawable(R.drawable.tabbar_release_task)))
                .addMenuItem(PopMenuItem("发布动态",resources.getDrawable(R.drawable.tabbar_release_dynamic)))
                .addMenuItem(PopMenuItem("发布闲置", resources.getDrawable(R.drawable.tabbar_release_idle)))
                .addMenuItem(PopMenuItem("发布需求", resources.getDrawable(R.drawable.tabbar_release_need)))
                .addMenuItem(PopMenuItem("发布活动", resources.getDrawable(R.drawable.tabbar_release_activity)))
                .addMenuItem(PopMenuItem("发布技能", resources.getDrawable(R.drawable.tabbar_release_skill)))
                .setOnItemClickListener(object : PopMenuItemListener {
                    override fun onItemClick(popMenu: PopMenu, position: Int) {
                        Toast.makeText(this@MainActivity, "你点击了第" + position + "个位置", Toast.LENGTH_SHORT).show()
                    }
                })
                .build()


        mBootomBar.setOnTabSelectedListener(object : BottomBar.OnTabSelectedListener  {
            override fun onTabSelected(position: Int, prePosition: Int) {
               if(position==2){

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


    fun onClickPublish(v: View) {
        if (!mPopMenu?.isShowing()!!) {
                       mPopMenu?.show()
                   }
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
