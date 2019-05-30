package com.android.navigationjetpack

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData



/**
 * Created by NguyenLinh on 30,May,2019
 */
class ShareViewModel : ViewModel(){
    val onValueReceive = MutableLiveData<String>()

    fun setUpdateValue(value :String){
        onValueReceive.value = value
    }

    fun getValueReceive(): LiveData<String> {
        return onValueReceive
    }
}