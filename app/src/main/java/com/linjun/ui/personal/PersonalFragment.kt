package com.linjun.ui.personal

import android.content.Intent
import android.graphics.Typeface
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.linjun.R
import com.linjun.component.ApplicationComponent
import com.linjun.ui.base.BaseContract
import com.linjun.ui.base.BaseFragment
import com.linjun.ui.base.BasePresenter
import com.linjun.utils.ImageLoaderUtil
import com.linjun.widget.SimpleMultiStateView
import kotlinx.android.synthetic.main.fragment_personal.*

class PersonalFragment : BaseFragment<BasePresenter<BaseContract.BaseView>>() {
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

        val mTypeFace = Typeface.createFromAsset(activity.assets, "font/consolab.ttf")

    }

    private fun setFont(vararg view: TextView) {
        val typeface = Typeface.createFromAsset(activity.assets, "font/consola.ttf")
        view.forEach {
            it.typeface = typeface
        }
    }

    private fun toWeb(url: String) {
        val webUrl = Uri.parse(url)
        val webIntent = Intent(Intent.ACTION_VIEW, webUrl)
        activity.startActivity(webIntent)
    }

}