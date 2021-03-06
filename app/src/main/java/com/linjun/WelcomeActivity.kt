package com.linjun

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.linjun.component.ApplicationComponent
import com.linjun.ui.base.BaseActivity
import com.linjun.ui.base.BaseContract
import com.linjun.utils.ImageLoaderUtil
import com.linjun.widget.SimpleMultiStateView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import kotlinx.android.synthetic.main.activity_welcome.*
import pl.droidsonroids.gif.GifDrawable
import java.util.concurrent.TimeUnit
import com.linjun.widget.shimmer.Shimmer
import com.linjun.widget.shimmer.ShimmerTextView
import android.view.WindowManager


class WelcomeActivity : BaseActivity<BaseContract.BasePresenter>() {
    var shimmer: Shimmer? = null
    private val picUrl = "http://api.dujin.org/bing/1920.php"

    private var mCompositeDisposable: CompositeDisposable? = CompositeDisposable()

    override fun getContentLayout(): Int = R.layout.activity_welcome

    override fun getSimpleMultiStateView(): SimpleMultiStateView? = null

    override fun initInjector(appComponent: ApplicationComponent) {
    }

    override fun bindView(view: View, savedInstanceState: Bundle?) {

        ImageLoaderUtil.LoadImage(this, picUrl, iv_ad)
        mCompositeDisposable?.add(countDown(3)
                .doOnSubscribe({ tv_skip.text = "跳过 4" })
                .subscribeWith(object : DisposableObserver<Int>() {
                    override fun onNext(t: Int) {
                        tv_skip.text = "跳过${t + 1} "
                    }

                    override fun onError(e: Throwable) {

                    }

                    override fun onComplete() {
                        toMain()
                    }
                }))
        shimmer = Shimmer()
        shimmer!!.start(tv_logo)
        fl_ad.setOnClickListener { toMain() }
        setFullScreen()
    }

    private fun setFullScreen() {
        val flag = WindowManager.LayoutParams.FLAG_FULLSCREEN
        val window = this@WelcomeActivity.getWindow()
        window.setFlags(flag, flag)
    }

    /**
     * 倒计时
     * @param time 秒
     */
    private fun countDown(time: Int): Observable<Int> {
        return Observable.interval(0, 1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .map { t -> time - t.toInt() }
                .take((time + 1).toLong())
    }

    /**
     * 跳转到 MainActivity 并取消订阅
     */
    private fun toMain() {
        mCompositeDisposable?.dispose()
        val intent = Intent()
        intent.setClass(this@WelcomeActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onDestroy() {
        mCompositeDisposable?.dispose()
        super.onDestroy()
    }

    override fun initData() {
    }

}