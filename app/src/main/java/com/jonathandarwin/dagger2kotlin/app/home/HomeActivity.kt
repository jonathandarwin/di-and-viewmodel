package com.jonathandarwin.dagger2kotlin.app.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.jonathandarwin.dagger2kotlin.App
import com.jonathandarwin.dagger2kotlin.R
import com.jonathandarwin.dagger2kotlin.databinding.ActivityHomeBinding
import com.jonathandarwin.dagger2kotlin.factory.ViewModelFactory
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var factory : ViewModelFactory

    private lateinit var binding : ActivityHomeBinding

    private lateinit var viewModel : HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        viewModel = ViewModelProvider(this, factory)[HomeViewModel::class.java]

        val username = intent.getStringExtra("username")
        binding.greeting = "Hello, $username"
        binding.time = "Login at ${viewModel.getLoginTime()}"
    }

    private fun inject() {
        (application as App).getAppComponent().inject(this)
    }
}
