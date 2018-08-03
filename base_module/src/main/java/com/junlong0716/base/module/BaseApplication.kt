package com.junlong0716.base.module

import android.app.Application
import android.support.annotation.NonNull
import android.support.annotation.Nullable
import android.util.Log
import com.blankj.utilcode.util.Utils
import com.junlong0716.base.module.util.LoggerUtil
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import com.orhanobut.logger.LogStrategy


/**
 *@author: EdsionLi
 *@description:
 *@date: Created in 2018/8/2 下午5:02
 *@modified by:
 */
abstract class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Utils.init(this)
        LoggerUtil.init(true)
    }

    //初始化Logger 防止混乱
    private fun initLogger() {
        val logStrategy = object : LogStrategy {
            private val prefix = arrayOf(". ", " .")
            private var index = 0

            override fun log(priority: Int, @Nullable tag: String?, @NonNull message: String) {
                index = index xor 1
                Log.println(priority, prefix[index] + tag!!, message)
            }
        }
        val formatStrategy = PrettyFormatStrategy.newBuilder()
                .logStrategy(logStrategy)
                .showThreadInfo(false)
                .methodCount(1)
                .methodOffset(7)
                .build()
        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))
    }
}