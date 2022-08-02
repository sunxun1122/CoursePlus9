@file:JvmName("Utils")

package com.example.core.utils

import android.content.res.Resources
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.core.BaseApplication

private val displayMetrics: DisplayMetrics = Resources.getSystem().displayMetrics;

/**
 * 扩展函数
 */
fun Float.dp2px() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, displayMetrics)

/**
 * 扩展属性
 */
val ViewGroup.firstChild: View
    get() = getChildAt(0)

// 生成Java多个对应重载方法
@JvmOverloads
fun toast(string: String, duration: Int = Toast.LENGTH_SHORT) = Toast.makeText(BaseApplication.currentApplication, string, duration).show()
