package com.junlong0716.basemodule

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.support.v4.content.ContextCompat
import com.blankj.utilcode.util.BarUtils
import com.blankj.utilcode.util.ToastUtils
import com.junlong0716.base.module.base.BaseActivity
import com.junlong0716.base.module.dialog.CommonLoadingDialog
import com.junlong0716.base.module.http.RetrofitClient
import com.junlong0716.base.module.http.download.DownloadSubscriber
import com.junlong0716.base.module.rx.RxSchedulers
import com.junlong0716.base.module.rx.bus.RxBus
import com.junlong0716.base.module.util.StatusBarUtil
import com.orhanobut.logger.Logger
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : BaseActivity<MainPresenter>(), MainView {
    override fun beforeSetLayout() {

    }

    override fun attachPresenter() {
        mPresenter = MainPresenter()
        mPresenter!!.attachView(this)
    }

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initView(savedInstanceState: Bundle?) {
        val rxPermissions = RxPermissions(this)

        RxBus.default.subscribe(this, object : RxBus.Callback<String> {
            override fun onEvent(t: String) {
                ToastUtils.showShort(t)
            }
        })

        rxPermissions
                .request(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE)
                .subscribe {

                }

        RetrofitClient.instance.getClient().create(Api::class.java).requestData("bannerCard")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    ToastUtils.showShort(it.string())
                }

        bt_download.setOnClickListener {
            RetrofitClient.instance.downloadFile("http://ws.yingyonghui.com/cd289bdaeecd4068f05ce094139088ac/5b6937ba/apk/5914137/131181323dba71fcf4786905afae740a", Environment.getExternalStorageDirectory().absolutePath + File.separator, "豌豆荚.apk")
                    .compose(RxSchedulers.io_main_flowable(this))
                    .safeSubscribe(object : DownloadSubscriber(this) {
                        override fun onNext(result: String) {
                            ToastUtils.showShort("正在下载！")
                        }

                        override fun onProgress(percent: Int?) {
                            Logger.d(percent!!.toString())
                        }

                        override fun onError(errorCode: Int, msg: String?) {
                            Logger.d(msg)
                        }
                    })
        }
        bt_send_message.setOnClickListener {
            RxBus.default.post("RxBus 发送了一条消息")
        }

        bt_send_sticky_message.setOnClickListener {
            // 发送 String 类型的粘性事件
            RxBus.default.postSticky("RxBus 发送了一条粘性消息");
            startActivity(Intent(this, StickyMessageActivity::class.java))
        }

        bt_go.setOnClickListener {
            startActivity(Intent(this, StickyMessageActivity::class.java))
        }

        bt_send_sticky_message_by_tag.setOnClickListener {
            //发送 带有 Tag 标签的消息
            RxBus.default.postSticky("RxBus 发送了一条带标签粘性消息", "SEND_MESSAGE_BY_TAG")
            startActivity(Intent(this, StickyMessageActivity::class.java))
        }

        bt_show_loading.setOnClickListener {
            CommonLoadingDialog(this).show()
        }
    }

    override fun registerRxBus() {

    }

    override fun onDestroy() {
        super.onDestroy()
        RxBus.default.unregister(this)
    }
}
