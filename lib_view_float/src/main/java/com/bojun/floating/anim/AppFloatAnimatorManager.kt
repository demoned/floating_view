package com.bojun.floating.anim

import android.animation.Animator
import android.view.View
import android.view.WindowManager
import com.bojun.floating.data.FloatConfig

/**
 * App浮窗的出入动画管理类，只需传入具体的动画实现类（策略模式）
 */
internal class AppFloatAnimatorManager(
        private val view: View,
        private val params: WindowManager.LayoutParams,
        private val windowManager: WindowManager,
        private val config: FloatConfig
) {

    fun enterAnim(): Animator? =
            config.appFloatAnimator?.enterAnim(view, params, windowManager, config.sidePattern)

    fun exitAnim(): Animator? =
            config.appFloatAnimator?.exitAnim(view, params, windowManager, config.sidePattern)
}