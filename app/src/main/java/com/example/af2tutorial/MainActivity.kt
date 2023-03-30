package com.example.af2tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.af2tutorial.data.User
import com.example.af2tutorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, ViewModelFactory.getInstance(application))[MainViewModel::class.java]

        val user = createCustomUser()

        binding.btnFav.setOnClickListener {
            user.isFavorite = !user.isFavorite
            if (user.isFavorite) viewModel.insertUser(user) else viewModel.deleteUser(user)
        }
    }

    private fun createCustomUser(): User {
        return User(
            id = 0,
            firstName = "Richard",
            lastName = "Tanoto",
            avatar = "contoh url",
            email = "richard@bangkit.academy",
            isFavorite = false
        )
    }
}