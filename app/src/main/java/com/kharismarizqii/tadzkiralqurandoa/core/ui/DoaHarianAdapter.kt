package com.kharismarizqii.tadzkiralqurandoa.core.ui

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kharismarizqii.tadzkiralqurandoa.R
import com.kharismarizqii.tadzkiralqurandoa.databinding.ItemDoaHarianBinding
import com.kharismarizqii.tadzkiralqurandoa.domain.model.DoaHarian

class DoaHarianAdapter(private val context: Context): RecyclerView.Adapter<DoaHarianAdapter.DoaHarianViewHolder>() {
    private var listData = ArrayList<DoaHarian>()

    fun setData(newListData: List<DoaHarian>?){
        if (newListData==null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    inner class DoaHarianViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val binding = ItemDoaHarianBinding.bind(itemView)
        fun bind(data: DoaHarian){
            binding.apply {
                tvTitle.text = data.title
                tvLatin.text = data.latin
                tvArabic.text = data.arabic
                tvTranslation.text = data.translation
                val typeFace = Typeface.createFromAsset(context.assets, "fonts/me_quran.ttf")
                tvArabic.typeface = typeFace
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoaHarianViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_doa_harian, parent, false)
        return DoaHarianViewHolder(view)
    }

    override fun onBindViewHolder(holder: DoaHarianViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = listData.size
}