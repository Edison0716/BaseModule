package com.junlong0716.basemodule

import android.Manifest
import android.os.Bundle
import com.blankj.utilcode.util.ToastUtils
import com.junlong0716.base.module.base.BaseActivity
import com.junlong0716.base.module.http.DefaultObserver
import com.junlong0716.base.module.http.RetrofitClient
import com.junlong0716.base.module.http.download.DownloadSubscriber
import com.orhanobut.logger.Logger
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

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
        rxPermissions
                .request(Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE)
                .subscribe {

                }

        RetrofitClient.instance.getClient().create(Api::class.java).requestData("bannerCard")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    ToastUtils.showShort(it.string())
                }


        RetrofitClient.instance.downloadFile("http://ucan.25pp.com/Wandoujia_web_seo_baidu_homepage.apk")
                .safeSubscribe(object :DownloadSubscriber(this){
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
}
