package com.junlong0716.basemodule

import android.os.Bundle
import com.junlong0716.base.module.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun initView() {

    }
}
