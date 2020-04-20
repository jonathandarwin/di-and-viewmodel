package com.jonathandarwin.dagger2kotlin.app.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.jonathandarwin.dagger2kotlin.App
import com.jonathandarwin.dagger2kotlin.R
import com.jonathandarwin.dagger2kotlin.app.home.HomeActivity
import com.jonathandarwin.dagger2kotlin.databinding.ActivityLoginBinding
import com.jonathandarwin.dagger2kotlin.factory.ViewModelFactory
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding

    @Inject
    lateinit var factory : ViewModelFactory

    private lateinit var viewModel : LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = ViewModelProvider(this, factory)[LoginViewModel::class.java]
        binding.model = viewModel.user

        binding.btnLogin.setOnClickListener{
            when(viewModel.doLogin()) {
                true -> {
                    val intent = Intent(this, HomeActivity::class.java)
                    intent.putExtra("username", viewModel.user.username)
                    startActivity(intent)
                }
                else -> Toast.makeText(this, "Invalid username/password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun inject(){
        (application as App).getAppComponent().inject(this)
    }
}
