package com.junlong0716.basemodule

import android.os.Bundle
import com.junlong0716.base.module.base.BaseActivity

class MainActivity : BaseActivity<MainPresenter>(), MainView {
    override fun beforeSetLayout() {

    }

    override fun attachPresenter() {

    }

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initView(savedInstanceState: Bundle?) {

    }

}
