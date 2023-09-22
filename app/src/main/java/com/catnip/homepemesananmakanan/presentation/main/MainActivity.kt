package com.catnip.homepemesananmakanan.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.catnip.homepemesananmakanan.databinding.ActivityMainBinding
import com.catnip.homepemesananmakanan.presentation.presentation.fragmenthome.FragmentHome

class MainActivity : AppCompatActivity() {
    private val binding : ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

}