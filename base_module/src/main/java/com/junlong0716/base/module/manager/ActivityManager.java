package com.junlong0716.base.module.manager;

import android.content.Context;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.util.Stack;

/**
 * @author: EdsionLi
 * @description: 应用程序Activity管理类：用于Activity管理和应用程序退出
 * @date: Created in 2018/3/14 下午4:47
 * @modified by:
 */

public class ActivityManager {
    private static Stack<RxAppCompatActivity> activityStack = new Stack<RxAppCompatActivity>();

    /**
     * 添加Activity到堆栈
     */
    public static void addActivity(RxAppCompatActivity activity) {
        activityStack.push(activity);
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public static RxAppCompatActivity currentActivity() {
        return activityStack.lastElement();
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    public static void finishCurrentActivity() {
        RxAppCompatActivity activity = activityStack.pop();
        activity.finish();
    }

    /**
     * 结束指定的Activity
     */
    public static void finishActivity(RxAppCompatActivity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }

    /**
     * 结束指定类名的Activity
     */
    public static void finishActivity(Class<?> cls) {
        for (RxAppCompatActivity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public static void finishAllActivity() {
        for (RxAppCompatActivity activity : activityStack) {
            if (activity != null) {
                activity.finish();
            }
        }
        activityStack.clear();
    }

    /**
     * 退出应用程序
     */
    public static void AppExit(Context context) {
        try {
            finishAllActivity();
            android.app.ActivityManager manager = (android.app.ActivityManager) context
                    .getSystemService(Context.ACTIVITY_SERVICE);
            manager.killBackgroundProcesses(context.getPackageName());
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}