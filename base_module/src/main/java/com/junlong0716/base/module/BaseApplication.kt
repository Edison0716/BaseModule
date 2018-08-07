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
        //LoggerUtil.init()
    }
}