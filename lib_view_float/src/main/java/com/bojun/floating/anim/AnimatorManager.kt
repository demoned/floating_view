package com.bojun.floating.anim

import android.animation.Animator
import android.view.View
import android.view.ViewGroup
import com.bojun.floating.enums.SidePattern
import com.bojun.floating.interfaces.OnFloatAnimator

/**
 * Activity浮窗的出入动画管理类，只需传入具体的动画实现类（策略模式）
 */
internal class AnimatorManager(
        private val onFloatAnimator: OnFloatAnimator?,
        private val view: View,
        private val parentView: ViewGroup,
        private val sidePattern: SidePattern
) {

    // 通过接口实现具体动画，所以只需要更改接口的具体实现
    fun enterAnim(): Animator? = onFloatAnimator?.enterAnim(view, parentView, sidePattern)

    fun exitAnim(): Animator? = onFloatAnimator?.exitAnim(view, parentView, sidePattern)
}