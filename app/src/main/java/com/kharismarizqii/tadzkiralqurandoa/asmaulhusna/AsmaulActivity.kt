package com.kharismarizqii.tadzkiralqurandoa.asmaulhusna

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.Resource
import com.kharismarizqii.tadzkiralqurandoa.core.ui.AsmaulAdapter
import com.kharismarizqii.tadzkiralqurandoa.core.ui.ViewModelFactory
import com.kharismarizqii.tadzkiralqurandoa.databinding.ActivityAsmaulBinding

class AsmaulActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAsmaulBinding
    private lateinit var viewModel: AsmaulViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAsmaulBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = AsmaulAdapter(this)
        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[AsmaulViewModel::class.java]

        viewModel.asmaul.observe(this, {asmaul->
            if (asmaul!=null){
                when(asmaul){
                    is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is Resource.Success ->{
                        binding.progressBar.visibility = View.GONE
                        adapter.setData(asmaul.data)
                    }
                    is Resource.Error -> {
                        binding.progressBar.visibility = View.GONE
                        binding.viewError.root.visibility = View.VISIBLE
                        binding.viewError.tvError.text = asmaul.message ?: "Oops.. Something Went Wrong"
                    }
                }
            }
        })

        with(binding.rvAsmaul){
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@AsmaulActivity)
            this.adapter = adapter

        }
    }
}