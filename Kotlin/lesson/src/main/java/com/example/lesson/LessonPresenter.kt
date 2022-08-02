package com.example.lesson

import com.example.core.http.EntityCallback
import com.example.core.http.HttpClient.get
import com.example.core.utils.toast
import com.example.lesson.entity.Lesson
import com.google.gson.reflect.TypeToken

class LessonPresenter(private var activity: LessonActivity) {
    companion object {
        private const val LESSON_PATH = "lessons"
    }

    private var lessons: List<Lesson> = ArrayList()

    private val type = object : TypeToken<List<Lesson>>() {}.type

    fun fetchData() {
        get(LESSON_PATH, type, object : EntityCallback<List<Lesson>> {
            override fun onSuccess(lessons: List<Lesson>) {
                this@LessonPresenter.lessons = lessons
                activity.runOnUiThread { activity.showResult(lessons) }
            }

            override fun onFailure(message: String?) {
                activity.runOnUiThread { toast(message!!) }
            }
        })
    }

    fun showPlayback() = activity.showResult(lessons.filter { it.state === Lesson.State.PLAYBACK })
}