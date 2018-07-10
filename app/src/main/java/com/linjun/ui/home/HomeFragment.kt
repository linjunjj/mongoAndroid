package com.linjun.ui.home

import android.app.FragmentManager
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentStatePagerAdapter
import android.view.View
import com.linjun.R
import com.linjun.component.ApplicationComponent
import com.linjun.ui.base.BaseContract
import com.linjun.ui.base.BaseFragment
import com.linjun.ui.base.BasePresenter
import com.linjun.widget.SimpleMultiStateView

class HomeFragment : BaseFragment<BasePresenter<BaseContract.BaseView>>(){
       companion object {
           fun newInstance():HomeFragment{
               val  args =Bundle()
               val fragment=HomeFragment()
               fragment.arguments=args
               return fragment
           }
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
        val  strings =ArrayList<String>()
        strings.add("推荐")
        strings.add("任务")
        strings.add("兼职")
        strings.add("闲置")
        strings.add("租房")
        strings.add("活动")


    }

    override fun getContentLayout(): Int {
        return  R.layout.fragment_home
    }
    inner class  HomeFragmentAdapter(fm : FragmentManager ,private  val titles:List<String>): FragmentStatePagerAdapter(fm){
        override fun getItem(position: Int): Fragment {


        }

        override fun getCount(): Int {
            return titles.size
        }

    }



}