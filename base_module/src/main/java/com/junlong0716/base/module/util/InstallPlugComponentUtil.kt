package com.junlong0716.base.module.util

import android.content.Context
import com.didi.virtualapk.PluginManager
import com.orhanobut.logger.Logger
import java.io.File

/**
 *@author: EdsionLi
 *@description: 安装插件工具类
 *@date: Created in 2018/8/10 上午10:13
 *@modified by:
 */
object InstallPlugComponentUtil {
    fun installPlugComponent(context: Context, componentSaveDirName: String, componentName: String, componentPackageName: String, installPlugInComponentCallback: InstallPlugInComponentCallback) {
        val componentPath = context.getExternalFilesDir(componentSaveDirName).absolutePath + File.separator + componentName
        val componentFile = File(componentPath)
        //插件不存在
        if (!componentFile.exists()) {
            Logger.e(componentFile.path)
            installPlugInComponentCallback.onComponentNonExist()
            return
        }
        //判断插件是否存在
        if (PluginManager.getInstance(context).getLoadedPlugin(componentPackageName) == null){
            //加载插件包
            PluginManager.getInstance(context).loadPlugin(componentFile)
            installPlugInComponentCallback.onComponentHasLoaded()
        }else{
            installPlugInComponentCallback.onComponentHasAlreadyLoad()
        }
    }

    interface InstallPlugInComponentCallback {
        //插件包不存在
        fun onComponentNonExist()
        //插件包已经加载过
        fun onComponentHasAlreadyLoad()
        //插件加载完成
        fun onComponentHasLoaded()
    }
}