package com.kharismarizqii.tadzkiralqurandoa.core.ui

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kharismarizqii.tadzkiralqurandoa.R
import com.kharismarizqii.tadzkiralqurandoa.databinding.ItemAsmaulBinding
import com.kharismarizqii.tadzkiralqurandoa.domain.model.Asmaul

class AsmaulAdapter(private val context: Context): RecyclerView.Adapter<AsmaulAdapter.AsmaulViewHolder>() {
    private var listData = ArrayList<Asmaul>()

    fun setData(newListData: List<Asmaul>?){
        if (newListData==null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    inner class AsmaulViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val binding = ItemAsmaulBinding.bind(itemView)
        fun bind(data: Asmaul){
            binding.apply {
                tvLatin.text = data.latin
                tvArabic.text = data.arabic
                tvTranslationId.text = data.translationId
                tvTranslationEn.text = data.translationEn
                val typeFace = Typeface.createFromAsset(context.assets, "fonts/me_quran.ttf")
                tvArabic.typeface = typeFace
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AsmaulViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_asmaul, parent, false)
        return AsmaulViewHolder(view)
    }

    override fun onBindViewHolder(holder: AsmaulViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = listData.size
}