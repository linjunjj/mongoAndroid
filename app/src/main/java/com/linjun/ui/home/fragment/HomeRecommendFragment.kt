package com.linjun.ui.home.fragment

import `in`.srain.cube.views.ptr.PtrDefaultHandler
import `in`.srain.cube.views.ptr.PtrFrameLayout
import `in`.srain.cube.views.ptr.PtrHandler
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bigkoo.convenientbanner.ConvenientBanner
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator
import com.bigkoo.convenientbanner.holder.Holder
import com.bigkoo.convenientbanner.listener.OnItemClickListener
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.linjun.R
import com.linjun.R.id.convenientBanner
import com.linjun.bean.RecommendBean
import com.linjun.component.ApplicationComponent
import com.linjun.ui.base.BaseContract
import com.linjun.ui.base.BaseFragment
import com.linjun.ui.home.HomeFragment
import com.linjun.widget.SimpleMultiStateView
import kotlinx.android.synthetic.main.banner.*
import kotlinx.android.synthetic.main.fragment_recommend.*

@SuppressLint("ValidFragment")
class HomeRecommendFragment :BaseFragment<BaseContract.BasePresenter>(),BaseContract.BaseView{


    companion object {
        fun newInstance(): HomeRecommendFragment {
            val  args =Bundle()
            val fragment= HomeRecommendFragment()
            fragment.arguments=args
            return fragment
        }
    }

    override fun getContentLayout(): Int {
        return R.layout.fragment_recommend
    }

    override fun getSimpleMultiStateView(): SimpleMultiStateView? {
        return null
    }

    override fun initInjector(appComponent: ApplicationComponent) {
//         DaggerHttpComponent.builder()
//                 .applicationComponent(appComponent)
//                 .build()
//                 .inject(this)
    }

    override fun bindView(view: View, savedInstanceState: Bundle?) {


    }




    override fun initData() {}


}
