package com.wts.mvvm.utils

import android.content.Context
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Create by wangtingshun 2020/3/4
 * describe Perference封装类
 */
class Preference<T> (val context: Context,val name:String,val default:T,val preName:String ="default" ):ReadWriteProperty<Any?,T> {


    private val pref by lazy {
          context.getSharedPreferences(preName,Context.MODE_PRIVATE)
    }


    private fun findPreference(key:String):T{
        return when(default){
              is Long-> pref.getLong(key,default)
              is String ->pref.getString(key,default)
              is Int-> pref.getInt(key,default)
              is Boolean->pref.getBoolean(key,default)
            else-> throw IllegalArgumentException("Unsupported type")
        } as T
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return findPreference(name)
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        putPrefence(preName,value)
    }

    private fun putPrefence(key: String, value: T) {
        with(pref.edit()) {
            when (value) {
                is Long -> putLong(key, value)
                is String -> putString(key, value)
                is Int -> putInt(key, value)
                is Boolean -> putBoolean(key, value)
                else -> throw IllegalArgumentException("Unsupported type")
            }
        }.apply()
    }

}