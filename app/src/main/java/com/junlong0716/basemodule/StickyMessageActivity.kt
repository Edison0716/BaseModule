package com.junlong0716.basemodule

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.blankj.utilcode.util.ToastUtils
import com.junlong0716.base.module.rx.bus.RxBus
import com.junlong0716.base.module.rx.bus.TagMessage
import com.junlong0716.base.module.util.CacheUtils

class StickyMessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sticky_message)
        RxBus.default.subscribeSticky(this, object : RxBus.Callback<String> {
            override fun onEvent(t: String) {
                ToastUtils.showShort(t)

                //消费事件
                val msgEvent = TagMessage(t, "")
                CacheUtils.getInstance().removeStickyEvent(msgEvent)
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        RxBus.default.unregister(this)
    }
}
