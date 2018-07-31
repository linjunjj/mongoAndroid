package com.linjun.ui.find

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.PagerAdapter
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.linjun.R
import com.linjun.bean.JdBaseBean
import com.linjun.component.ApplicationComponent
import com.linjun.net.FindApi
import com.linjun.ui.apdater.BoredPicAdapter
import com.linjun.ui.base.BaseContract
import com.linjun.ui.base.BaseFragment
import com.linjun.ui.base.BasePresenter
import com.linjun.ui.find.fragment.JdDetailFragment
import com.linjun.ui.home.fragment.HomeRecommendFragment
import com.linjun.widget.SimpleMultiStateView
import kotlinx.android.synthetic.main.fragment_find.*

class FindFragment  : BaseFragment<BasePresenter<BaseContract.BaseView>>() {
    private var mFindFragmentAdapter : FindFragmentAdapter?=null

    companion object {
        fun newInstance(): FindFragment {
            val args = Bundle()
            val fragment = FindFragment()
            fragment.arguments = args
            return fragment
        }
    }
    override fun getSimpleMultiStateView(): SimpleMultiStateView? = null

    override fun initInjector(appComponent: ApplicationComponent) {}

    override fun getContentLayout(): Int = R.layout.fragment_find

    override fun initData() {
        val  strings =ArrayList<String>()
        strings.add("动态")
        strings.add("关注")
        strings.add("达人")
        strings.add("轻松时刻")
        mFindFragmentAdapter=FindFragmentAdapter(childFragmentManager,strings)
        viewPager.adapter=mFindFragmentAdapter
        viewPager.offscreenPageLimit=1
        viewPager.setCurrentItem(0,false)
        tabLayout.setupWithViewPager(viewPager,true)
    }

    override fun bindView(view: View, savedInstanceState: Bundle?) {

    }


    inner class  FindFragmentAdapter(fm : FragmentManager, private  val titles:List<String>): FragmentStatePagerAdapter(fm) {
        override fun getItem(position: Int): Fragment? {
            when(position){
                0->return HomeRecommendFragment.newInstance()
                1->return HomeRecommendFragment.newInstance()
                2->return HomeRecommendFragment.newInstance()
                3 ->return JdDetailFragment.newInstance(FindApi.TYPE_BORED, BoredPicAdapter(activity, null) as BaseQuickAdapter<in JdBaseBean
                        , BaseViewHolder>)


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