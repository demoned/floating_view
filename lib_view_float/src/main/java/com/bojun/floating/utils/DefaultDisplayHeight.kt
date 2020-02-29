package com.bojun.floating.utils

import android.content.Context
import com.bojun.floating.interfaces.OnDisplayHeight

/**
 * 获取屏幕有效高度的实现类
 */
internal class DefaultDisplayHeight : OnDisplayHeight {

    override fun getDisplayRealHeight(context: Context) = DisplayUtils.rejectedNavHeight(context)

}