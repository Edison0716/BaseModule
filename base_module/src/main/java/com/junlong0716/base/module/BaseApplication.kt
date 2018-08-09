package com.junlong0716.base.module

import android.app.Application
import com.blankj.utilcode.util.Utils
import com.junlong0716.base.module.entity.UserAccountEntity
import com.junlong0716.base.module.entity.UserInfoEntity
import com.junlong0716.base.module.manager.UserManager


/**
 *@author: EdsionLi
 *@description: 基类Application
 *@date: Created in 2018/8/2 下午5:02
 *@modified by:
 */
abstract class BaseApplication : Application() {
    //用户登录信息（token）
    var userAccount: UserAccountEntity? = null
        private set

    //用户个人信息
    var userInfo: UserInfoEntity? = null
        private set

    override fun onCreate() {
        super.onCreate()
        //初始化工具类
        Utils.init(this)
    }

    //获取账户信息
    private fun getUserAccount() {
        this.userAccount = UserManager.getUserAccount()
    }

    //存入账号信息
    fun putUserAccount(userAccount: UserAccountEntity) {
        this.userAccount = userAccount
        UserManager.putUserAccount(userAccount)
    }

    //获取个人信息
    private fun getUserInfo() {
        this.userInfo = UserManager.getUserInfo()
    }

    //存入个人信息
    fun putUserInfo(useInfo: UserInfoEntity) {
        this.userInfo = useInfo
        UserManager.putUserInfo(useInfo)
    }
}