package com.junlong0716.basemodule

import com.junlong0716.base.module.base.IPresenter
import com.junlong0716.base.module.base.IView
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity

/**
 *@author: EdsionLi
 *@description:
 *@date: Created in 2018/3/15 上午10:25
 *@modified by:
 */
interface LogInContract {
    interface View : IView {
        fun requestLogInByWechatSuccess()
        fun requestLogInByWechatFailed(reason:String)
    }

    interface Presenter : IPresenter {
        fun requestLoginByWechat(activity: RxAppCompatActivity, lgpin: String)
    }
}