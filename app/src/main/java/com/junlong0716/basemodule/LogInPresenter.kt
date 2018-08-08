package com.junlong0716.basemodule

import com.junlong0716.base.module.base.BasePresenter
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity

/**
 *@author: EdsionLi
 *@description: 登录 P 层
 *@date: Created in 2018/8/8 下午4:18
 *@modified by:
 */
class LogInPresenter:BasePresenter<LogInContract.View>(),LogInContract.Presenter{
    override fun requestLoginByWechat(activity: RxAppCompatActivity, lgpin: String) {

    }

    override fun onDestroy() {

    }
}
