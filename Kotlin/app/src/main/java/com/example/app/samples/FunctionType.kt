package com.example.app.samples

class View {
    interface OnClickListener {
        fun onClick(view: View)
    }

    fun setOnClickListener(listener: OnClickListener) {
    }

    // 函数类型参数 inline可以避免函数类型参数生成对象
    inline fun setOnClickListener(listener: (View) -> Unit) {
    }
}

fun main() {
    val view = View()
    view.setOnClickListener(object : View.OnClickListener {
        override fun onClick(view: View) {
        }
    })
    view.setOnClickListener(::onClick)
    view.setOnClickListener(fun(v: View) {
        println("被点击了")
    })
    view.setOnClickListener {
        println("被点击了")
    }
}

fun onClick(view: View) {
    println("被点击了")
}