package com.bojun.floating.widget.activityfloat

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.bojun.floating.data.FloatConfig

/**
 * 拖拽布局的实体类
 */
class FloatingView(context: Context, attrs: AttributeSet? = null) :
        AbstractDragFloatingView(context, attrs, 0) {

    fun setFloatConfig(config: FloatConfig) {
        this.config = config
        initView(context)
        requestLayout()
    }

    override fun getLayoutId(): Int? = config.layoutId

    override fun renderView(view: View) {}

}