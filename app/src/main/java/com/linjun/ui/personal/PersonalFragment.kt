package com.linjun.ui.personal

import android.content.Intent
import android.graphics.Typeface
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.linjun.R
import com.linjun.R.id.toolbar
//import com.linjun.StatusBarUtil
import com.linjun.component.ApplicationComponent
import com.linjun.showToast
import com.linjun.ui.base.BaseContract
import com.linjun.ui.base.BaseFragment
import com.linjun.ui.base.BasePresenter
import com.linjun.ui.login.LoginActivity
import com.linjun.widget.SimpleMultiStateView
import kotlinx.android.synthetic.main.fragment_personal.*

class PersonalFragment : BaseFragment<BasePresenter<BaseContract.BaseView>>(),View.OnClickListener {


    companion object {
        fun newInstance(): PersonalFragment {
            val args = Bundle()
            val fragment = PersonalFragment()
            fragment.arguments = args
            return fragment
        }
    }
    override fun getSimpleMultiStateView(): SimpleMultiStateView? = null

    override fun initInjector(appComponent: ApplicationComponent) {}

    override fun getContentLayout(): Int = R.layout.fragment_personal

    override fun initData() {}

    override fun bindView(view: View, savedInstanceState: Bundle?) {

//                StatusBarUtil.darkMode(activity)
//        StatusBarUtil.setPaddingSmart(activity, toolbar)
//        my_collect.setOnClickListener{
//         LoginActivity.launch(this.activity,0)
        my_collect.setOnClickListener(this)
        edit_pelpeo.setOnClickListener(this)

        }

//    实现点击逻辑功能
override fun onClick(v: View?) {
    when{
        v?.id==R.id.edit_pelpeo ->{
            showToast("收藏")
        }
        v?.id==R.id.my_collect ->{
          LoginActivity.launch(this.activity,0)}



    }
}

}