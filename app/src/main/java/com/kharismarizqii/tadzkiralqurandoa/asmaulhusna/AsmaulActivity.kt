package com.kharismarizqii.tadzkiralqurandoa.asmaulhusna

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kharismarizqii.tadzkiralqurandoa.databinding.ActivityAsmaulBinding

class AsmaulActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAsmaulBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAsmaulBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}