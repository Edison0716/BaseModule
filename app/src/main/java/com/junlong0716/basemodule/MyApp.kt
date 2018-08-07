package com.junlong0716.basemodule

import com.junlong0716.base.module.BaseApplication
import com.junlong0716.base.module.http.RetrofitClient
import com.junlong0716.base.module.util.LoggerUtil

/**
 * @author: EdsionLi
 * @description:
 * @date: Created in 2018/8/2 下午5:12
 * @modified by:
 */
class MyApp : BaseApplication() {
    override fun onCreate() {
        super.onCreate()
        LoggerUtil.init()
        RetrofitClient.instance.setBaseUrl("http://dev.233player.com/").setLogOutCode(-4000).initClient(this)
    }
}
