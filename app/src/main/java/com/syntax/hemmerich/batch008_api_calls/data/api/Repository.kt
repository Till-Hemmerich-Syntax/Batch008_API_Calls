package com.syntax.hemmerich.batch008_api_calls.data.api

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.syntax.hemmerich.batch008_api_calls.data.model.User
import java.lang.Exception

class Repository(private val api : UserApi) {

    private val _user = MutableLiveData<List<User>>()
    val users : LiveData<List<User>>
        get() = _user


    suspend fun getUsers(){
        try {
            _user.value = api.retrofitService.getUsers()
        }catch (e : Exception){
            Log.d("Repo:","API Call failed $e")
        }
    }

}