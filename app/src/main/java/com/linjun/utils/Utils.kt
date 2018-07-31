package com.linjun.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.NumberFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.Duration
import java.util.*

fun  isMobileConnected(context: Context?):Boolean{
    if (context!=null){
        val mConnectivityManager=context
                .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val mMobileNetworkInfo = mConnectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
        if (mMobileNetworkInfo != null && mMobileNetworkInfo.isAvailable) {
            return mMobileNetworkInfo.isConnected
        }

    }
    return  false
}

fun  isConnected(context: Context):Boolean{
    var connectivityManager=context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val  net=connectivityManager.activeNetworkInfo
    return  net!=null&& net.isConnected
}

fun toast(context: Context, message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, message, length).show()
}

fun <T> Observable<T>.applySchedulers(): Observable<T> {
    return subscribeOn(Schedulers.io()).
            unsubscribeOn(Schedulers.io()).
            observeOn(AndroidSchedulers.mainThread())
}

fun  conversionTime(playtime: Int):String{
    return if (sizeOf(playtime) > 4) {
        accuracy(playtime.toDouble(), 10000.0, 1) + "万"
    } else {
        playtime.toString()
    }
}

fun accuracy(num:Double,total:Double,digint:Int):String{
    val  df=NumberFormat.getInstance() as DecimalFormat
    df.maximumFractionDigits=digint
    df.roundingMode=RoundingMode.HALF_UP
    val accuracy_num = num / total
    return df.format(accuracy_num)
}


/**
 * 获取目标时间和当前时间之间的差距
 *
 * @param  date
 * @ return
 */
fun getTimestampString(date: Date): String {
    val ONE_SECOND: Long = 1000
    val ONE_MINUTE = ONE_SECOND * 60
    val ONE_HOUR = ONE_MINUTE * 60
    val ONE_DAY = ONE_HOUR * 24
    val curDate = Date()
    val splitTime = curDate.time - date.time
    if (splitTime < 30 * ONE_DAY) {
        if (splitTime < ONE_MINUTE) {
            return "刚刚"
        }
        if (splitTime < ONE_HOUR) {
            return String.format("%d分钟前", splitTime / ONE_MINUTE)
        }

        return if (splitTime < ONE_DAY) {
            String.format("%d小时前", splitTime / ONE_HOUR)
        } else String.format("%d天前  %s", splitTime / ONE_DAY, date2HHmm(date))

    }
    val result: String = "M月d日 HH:mm"
    return SimpleDateFormat(result, Locale.CHINA).format(date)
}
fun  sizeOf(size:Int):Int{
    val sizeTable = intArrayOf(9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE)
    var i = 0
    while (true) {
        if (size <= sizeTable[i])
            return i + 1
        i++
    }
}
fun date2HHmm(date: Date): String {
    return SimpleDateFormat("HH:mm").format(date)
}


fun string2Date(str: String, format: String): Date {
    try {
        return SimpleDateFormat(format).parse(str)
    } catch (e: ParseException) {
        e.printStackTrace()
    }

    return Date()
}


