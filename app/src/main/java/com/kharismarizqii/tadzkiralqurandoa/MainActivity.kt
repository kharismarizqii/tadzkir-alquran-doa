package com.kharismarizqii.tadzkiralqurandoa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kharismarizqii.tadzkiralqurandoa.asmaulhusna.AsmaulActivity
import com.kharismarizqii.tadzkiralqurandoa.bacaanshalat.BacaanShalatActivity
import com.kharismarizqii.tadzkiralqurandoa.databinding.ActivityMainBinding
import com.kharismarizqii.tadzkiralqurandoa.doaharian.DoaHarianActivity
import com.kharismarizqii.tadzkiralqurandoa.tahlil.TahlilActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setButtonMenu()
    }

    private fun setButtonMenu() {
        binding.apply {
            btnAsmaul.setOnClickListener {
                Intent(this@MainActivity, AsmaulActivity::class.java).also {
                    startActivity(it)
                }
            }
            btnBacaanShalat.setOnClickListener {
                Intent(this@MainActivity, BacaanShalatActivity::class.java).also {
                    startActivity(it)
                }
            }
            btnDoaHarian.setOnClickListener {
                Intent(this@MainActivity, DoaHarianActivity::class.java).also {
                    startActivity(it)
                }
            }
            btnDoaTahlil.setOnClickListener {
                Intent(this@MainActivity, TahlilActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
}