package com.wts.mvvm.viewModel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.wts.mvvm.http.OkHttpUtils

open class BaseViewModel : ViewModel(){

    open var showLoadDialog = MutableLiveData<Boolean>()

    protected var apiService: OkHttpUtils? = null

    init {
         if ( null == apiService){
             apiService = OkHttpUtils.mInstance
         }
    }

}