package com.bojun.floating.utils

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.bojun.floating.enums.ShowPattern
import com.bojun.floating.widget.appfloat.FloatManager

/**
 * 通过生命周期回调，判断系统浮窗的过滤信息，以及app是否位于前台，通过广播通知浮窗service
 */
internal object LifecycleUtils {

    private var activityCount = 0
    private lateinit var application: Application

    fun setLifecycleCallbacks(application: Application) {
        this.application = application
        application.registerActivityLifecycleCallbacks(object :
                Application.ActivityLifecycleCallbacks {

            override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {}

            override fun onActivityStarted(activity: Activity?) {
                // 计算启动的activity数目
                if (activity != null) activityCount++
            }

            // 每次都要判断当前页面是否需要显示
            override fun onActivityResumed(activity: Activity?) = checkShow(activity)

            override fun onActivityPaused(activity: Activity?) {}

            override fun onActivityStopped(activity: Activity?) {
                if (activity != null) {
                    // 计算关闭的activity数目，并判断当前App是否处于后台
                    activityCount--
                    checkHide()
                }
            }

            override fun onActivityDestroyed(activity: Activity?) {}

            override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {}

        })
    }

    /**
     * 判断浮窗是否需要显示
     */
    private fun checkShow(activity: Activity?) {
        if (activity == null) return
        FloatManager.floatMap.forEach { (tag, manager) ->
            when {
                // 仅后台显示模式下，隐藏浮窗
                manager.config.showPattern == ShowPattern.BACKGROUND -> setVisible(false, tag)
                // 如果没有手动隐藏浮窗，需要考虑过滤信息
                manager.config.needShow -> setVisible(
                        !manager.config.filterSet.contains(activity.componentName.className), tag
                )
            }
        }
    }

    /**
     * 判断浮窗是否需要隐藏
     */
    private fun checkHide() {
        if (isForeground()) return
        FloatManager.floatMap.forEach { (tag, manager) ->
            // 当app处于后台时，不是仅前台显示的浮窗，都需要显示
            setVisible(manager.config.showPattern != ShowPattern.FOREGROUND, tag)
        }
    }

    private fun isForeground() = activityCount > 0

    private fun setVisible(isShow: Boolean = isForeground(), tag: String?) =
            FloatManager.visible(isShow, tag)

}