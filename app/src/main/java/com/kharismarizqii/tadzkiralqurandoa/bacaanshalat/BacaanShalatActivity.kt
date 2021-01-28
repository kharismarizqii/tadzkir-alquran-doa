package com.kharismarizqii.tadzkiralqurandoa.bacaanshalat

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kharismarizqii.tadzkiralqurandoa.core.data.source.Resource
import com.kharismarizqii.tadzkiralqurandoa.core.ui.BacaanShalatAdapter
import com.kharismarizqii.tadzkiralqurandoa.core.ui.ViewModelFactory
import com.kharismarizqii.tadzkiralqurandoa.databinding.ActivityBacaanShalatBinding

class BacaanShalatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBacaanShalatBinding
    private lateinit var viewModel: BacaanShalatViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBacaanShalatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = BacaanShalatAdapter(this)
        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[BacaanShalatViewModel::class.java]

        viewModel.bacaanShalat.observe(this, { bacaanShalat ->
            if (bacaanShalat != null) {
                when (bacaanShalat) {
                    is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        adapter.setData(bacaanShalat.data)
                    }
                    is Resource.Error -> {
                        binding.progressBar.visibility = View.GONE
                        binding.viewError.root.visibility = View.VISIBLE
                        binding.viewError.tvError.text =
                            bacaanShalat.message ?: "Oops.. Something Went Wrong"
                    }
                }
            }
        })

        with(binding.rvBacaanShalat) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@BacaanShalatActivity)
            this.adapter = adapter

        }
    }
}