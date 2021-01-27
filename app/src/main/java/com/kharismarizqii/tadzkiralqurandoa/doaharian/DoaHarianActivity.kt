package com.kharismarizqii.tadzkiralqurandoa.doaharian

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.Resource
import com.kharismarizqii.tadzkiralqurandoa.core.ui.DoaHarianAdapter
import com.kharismarizqii.tadzkiralqurandoa.core.ui.ViewModelFactory
import com.kharismarizqii.tadzkiralqurandoa.databinding.ActivityDoaHarianBinding

class DoaHarianActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDoaHarianBinding
    private lateinit var viewModel: DoaHarianViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoaHarianBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = DoaHarianAdapter(this)
        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DoaHarianViewModel::class.java]

        viewModel.doaHarian.observe(this, {doaHarian->
            if (doaHarian!=null){
                when(doaHarian){
                    is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is Resource.Success ->{
                        binding.progressBar.visibility = View.GONE
                        adapter.setData(doaHarian.data)
                    }
                    is Resource.Error -> {
                        binding.progressBar.visibility = View.GONE
                        binding.viewError.root.visibility = View.VISIBLE
                        binding.viewError.tvError.text = doaHarian.message ?: "Oops.. Something Went Wrong"
                    }
                }
            }
        })

        with(binding.rvDoaHarian){
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@DoaHarianActivity)
            this.adapter = adapter

        }
    }
}