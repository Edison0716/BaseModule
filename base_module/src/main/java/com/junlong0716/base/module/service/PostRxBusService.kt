package com.junlong0716.base.module.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.junlong0716.base.module.constant.Constant
import com.junlong0716.base.module.rx.bus.RxBus

/**
 *@author: EdsionLi
 *@description:
 *@date: Created in 2018/8/16 下午5:15
 *@modified by:
 */
class PostRxBusService : Service() {
    override fun onBind(intent: Intent?): IBinder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate() {
        super.onCreate()
        RxBus.default.post("", Constant.ACCOUNT_LOG_OUT)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val mIntent = Intent(Constant.ACCOUNT_LOG_OUT)
        sendBroadcast(mIntent)
        return START_NOT_STICKY
    }
}