package com.syntax.hemmerich.batch008_api_calls

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.syntax.hemmerich.batch008_api_calls.data.api.Repository
import com.syntax.hemmerich.batch008_api_calls.data.api.UserApi
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val repository = Repository(UserApi)

    val users = repository.users

    init{
        loadData()
    }

    fun loadData(){
        viewModelScope.launch {
            repository.getUsers()
        }
    }

}