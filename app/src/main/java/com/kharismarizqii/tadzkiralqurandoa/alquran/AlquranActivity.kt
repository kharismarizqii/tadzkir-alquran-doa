package com.kharismarizqii.tadzkiralqurandoa.alquran

import android.graphics.Typeface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.kharismarizqii.tadzkiralqurandoa.core.ui.ViewModelFactory
import com.kharismarizqii.tadzkiralqurandoa.databinding.ActivityAlquranBinding
import com.kharismarizqii.tadzkiralqurandoa.domain.model.Alquran

class AlquranActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAlquranBinding
    private lateinit var viewModel: AlquranViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlquranBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[AlquranViewModel::class.java]

        viewModel.ayat.observe(this, {
            setData(it!!)
        })

    }

    private fun setData(data: Alquran) {
        binding.apply {
            val surat = "${data?.name} (${data?.asma}) - Ayat ${data?.ayat}"
            tvSuratAyat.text = surat
            tvArabic.text = data?.arabic
            tvTranslation.text = data?.translation
            val typeFace =
                Typeface.createFromAsset(this@AlquranActivity.assets, "fonts/me_quran.ttf")
            tvArabic.typeface = typeFace
        }
    }

}