package com.syntax.hemmerich.batch008_api_calls

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.syntax.hemmerich.batch008_api_calls.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addObserver()

    }

    fun addObserver(){
        viewModel.users.observe(this){
            binding.rvUser.adapter = UserAdapter(it)

        }
    }
}