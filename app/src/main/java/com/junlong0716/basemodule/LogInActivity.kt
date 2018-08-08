package com.junlong0716.basemodule

import android.os.Bundle
import com.junlong0716.base.module.base.BaseActivity

/**
 *@author: EdsionLi
 *@description: 登录 P 层
 *@date: Created in 2018/8/8 下午4:18
 *@modified by:
 */

class LogInActivity : BaseActivity<LogInPresenter>(), LogInContract.View {

    override fun beforeSetLayout() {}

    override fun attachPresenter() {
        mPresenter = LogInPresenter()
        mPresenter!!.attachView(this)
    }

    override fun getLayoutId(): Int = R.layout.host_activity_log_in

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun requestLogInByWechatSuccess() {
    }

    override fun requestLogInByWechatFailed(reason: String) {
    }
}
