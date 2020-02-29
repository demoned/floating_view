package com.bojun.floating.interfaces

import android.animation.Animator
import android.view.View
import android.view.WindowManager
import com.bojun.floating.enums.SidePattern

/**
 * 系统浮窗的出入动画
 */
interface OnAppFloatAnimator {

    fun enterAnim(
            view: View,
            params: WindowManager.LayoutParams,
            windowManager: WindowManager,
            sidePattern: SidePattern
    ): Animator? = null

    fun exitAnim(
            view: View,
            params: WindowManager.LayoutParams,
            windowManager: WindowManager,
            sidePattern: SidePattern
    ): Animator? = null

}