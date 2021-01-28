package com.kharismarizqii.tadzkiralqurandoa.core.ui

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kharismarizqii.tadzkiralqurandoa.R
import com.kharismarizqii.tadzkiralqurandoa.databinding.ItemBacaanShalatBinding
import com.kharismarizqii.tadzkiralqurandoa.domain.model.BacaanShalat

class BacaanShalatAdapter(private val context: Context): RecyclerView.Adapter<BacaanShalatAdapter.BacaanShalatViewHolder>() {
    private var listData = ArrayList<BacaanShalat>()

    fun setData(newListData: List<BacaanShalat>?){
        if (newListData==null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    inner class BacaanShalatViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val binding = ItemBacaanShalatBinding.bind(itemView)
        fun bind(data: BacaanShalat){
            binding.apply {
                tvTitle.text = data.name
                tvLatin.text = data.latin
                tvArabic.text = data.arabic
                tvTranslation.text = data.terjemahan
                val typeFace = Typeface.createFromAsset(context.assets, "fonts/me_quran.ttf")
                tvArabic.typeface = typeFace
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BacaanShalatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_bacaan_shalat, parent, false)
        return BacaanShalatViewHolder(view)
    }

    override fun onBindViewHolder(holder: BacaanShalatViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = listData.size
}