package com.example.app.entity

/**
 * 主构造器声明在类名后面；可以添加构造属性作为私有成员
 */
class User(var username: String?, var password: String?, var code: String?) {
    constructor() : this(null, null, null)
}