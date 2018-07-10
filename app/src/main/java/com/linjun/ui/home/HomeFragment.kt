package com.linjun.ui.home

import android.support.v4.app.FragmentManager
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.PagerAdapter
import android.view.View
import com.linjun.R
import com.linjun.component.ApplicationComponent
import com.linjun.ui.base.BaseContract
import com.linjun.ui.base.BaseFragment
import com.linjun.ui.base.BasePresenter
import com.linjun.ui.home.fragment.HomeRecommendFragment
import com.linjun.widget.SimpleMultiStateView
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment<BasePresenter<BaseContract.BaseView>>(){
    private var mHomeFragmentAdapter :HomeFragmentAdapter?=null
       companion object {
           fun newInstance():HomeFragment{
               val  args =Bundle()
               val fragment=HomeFragment()
               fragment.arguments=args
               return fragment
           }
       }

    override fun getSimpleMultiStateView(): SimpleMultiStateView?=null

    override fun initInjector(appComponent: ApplicationComponent) {}

    override fun bindView(view: View, savedInstanceState: Bundle?) {}

    override fun initData() {
        val  strings =ArrayList<String>()
        strings.add("推荐")
        strings.add("任务")
        strings.add("兼职")
        strings.add("闲置")
        strings.add("租房")
        strings.add("活动")
        mHomeFragmentAdapter=HomeFragmentAdapter(childFragmentManager,strings)
        viewPager.adapter=mHomeFragmentAdapter
        viewPager.offscreenPageLimit=1
        viewPager.setCurrentItem(0,false)
        tabLayout.setupWithViewPager(viewPager,true)
    }

    override fun getContentLayout(): Int {
        return  R.layout.fragment_home
    }
    inner class  HomeFragmentAdapter(fm : FragmentManager ,private  val titles:List<String>): FragmentStatePagerAdapter(fm) {
        override fun getItem(position: Int): Fragment? {
        when(position){
            0->return HomeRecommendFragment.newInstance()
            1->return HomeRecommendFragment.newInstance()
            2->return HomeRecommendFragment.newInstance()
            3->return HomeRecommendFragment.newInstance()
            4->return HomeRecommendFragment.newInstance()
            5->return HomeRecommendFragment.newInstance()
        }
            return  null
        }

        override fun getCount(): Int {
            return titles.size
        }

        override fun getPageTitle(position: Int): CharSequence {
            return titles[position]
        }

        override fun getItemPosition(`object`: Any?): Int {
            return PagerAdapter.POSITION_NONE
        }

    }



}