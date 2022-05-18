package com.example.projetoestudo1.feature.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.projetoestudo1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}