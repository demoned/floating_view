package com.bojun.floating.interfaces

import android.view.MotionEvent

/**
 * 系统浮窗的触摸事件
 */
internal interface OnFloatTouchListener {

    fun onTouch(event: MotionEvent)
}