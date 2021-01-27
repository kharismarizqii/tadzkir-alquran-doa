package com.kharismarizqii.tadzkiralqurandoa.tahlil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.Resource
import com.kharismarizqii.tadzkiralqurandoa.core.ui.TahlilAdapter
import com.kharismarizqii.tadzkiralqurandoa.core.ui.ViewModelFactory
import com.kharismarizqii.tadzkiralqurandoa.databinding.ActivityTahlilBinding

class TahlilActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTahlilBinding
    private lateinit var viewModel: TahlilViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTahlilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = TahlilAdapter(this)
        val factory = ViewModelFactory.getInstance(context = this)
        viewModel = ViewModelProvider(this,factory)[TahlilViewModel::class.java]

        viewModel.tahlil.observe(this, { tahlil ->
            if (tahlil!=null){
                when (tahlil){
                    is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        Log.e("observer", "tahlilList : ${tahlil.data}")
                        adapter.setData(tahlil.data)
                    }
                    is Resource.Error -> {
                        binding.progressBar.visibility = View.GONE
                        binding.viewError.root.visibility = View.VISIBLE
                        binding.viewError.tvError.text = tahlil.message ?: "Oops.. Something Went Wrong"
                    }
                }
            }
        })

        with(binding.rvTahlil){
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            this.adapter = adapter
        }
    }
}