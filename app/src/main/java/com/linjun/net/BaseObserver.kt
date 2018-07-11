package com.linjun.net

import io.reactivex.Observer
import io.reactivex.annotations.NonNull
import io.reactivex.disposables.Disposable

abstract class BaseObserver<T> : Observer<T> {

    abstract fun onSuccess(t: T?)

    abstract fun onFail(e: Throwable)

    override fun onSubscribe(@NonNull d: Disposable) {}

    override fun onNext(@NonNull t: T) {
        onSuccess(t)
    }

    override fun onError(@NonNull e: Throwable) {
        onFail(e)
    }

    override fun onComplete() {}
}
