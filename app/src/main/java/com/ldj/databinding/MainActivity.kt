package com.ldj.databinding

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.ldj.databinding.databinding.ActivityMainBinding
import com.ldj.databinding.frag.MyFragmentActivity
import com.ldj.databinding.list.MyListFragmentActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val model: MainViewModel by viewModels()
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.model = model
        binding.lifecycleOwner = this

        model.navigation.observe(this, Observer { nav ->
            when (nav) {
                is MainViewModel.Navigation.LaunchActivityFragment ->
                    startActivity(Intent(this, MyFragmentActivity::class.java))
                is MainViewModel.Navigation.LaunchActivityFragmentList ->
                    startActivity(Intent(this, MyListFragmentActivity::class.java))
            }
        })
    }
}