package com.example.app.samples

import com.example.core.utils.CacheUtils
import com.example.lesson.LessonActivity
import kotlin.reflect.KProperty

// 委托处理
var token: String by Saver("token")
var token2: String by Saver("token2")

class Saver(var s: String) {
    operator fun getValue(lessonActivity: LessonActivity?, property: KProperty<*>): String {
        return CacheUtils.get(s)!!
    }

    operator fun setValue(lessonActivity: LessonActivity?, property: KProperty<*>, value: String) {
        CacheUtils.save(s, value)
    }
}
