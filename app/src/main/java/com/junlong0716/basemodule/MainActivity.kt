package com.junlong0716.basemodule

import android.os.Bundle
import com.blankj.utilcode.util.ToastUtils
import com.junlong0716.base.module.base.BaseActivity
import com.junlong0716.base.module.http.RetrofitClient
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
        RetrofitClient.instance.getClient().create(Api::class.java).requestData("bannerCard")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    ToastUtils.showShort(it.string())
                }
    }
}
