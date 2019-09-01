package com.wts.mvvm.bean

/**
 * Create by wangtingshun 2019/8/28
 * describe 公共的外嵌套实体类
 */

class ResponseBean<T>(var data: T? = null){

    companion object {
        const val STATE_SUCCESS: Int = 0
        const val STATE_FAILED: Int = 1
        const val STATE_ERROR: Int = 2
    }

    var state: Int? = STATE_FAILED
    var msg: String? = ""
    var status: String? = null

    fun setState(state: Int) {
        this.state = state
    }

    fun isSuccess(): Boolean {
        return state == STATE_SUCCESS
    }
}