package com.kharismarizqii.tadzkiralqurandoa.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kharismarizqii.tadzkiralqurandoa.R
import com.kharismarizqii.tadzkiralqurandoa.databinding.ItemTahlilBinding
import com.kharismarizqii.tadzkiralqurandoa.domain.model.Tahlil
import java.util.ArrayList

class TahlilAdapter: RecyclerView.Adapter<TahlilAdapter.TahlilViewHolder>() {

    private var listData = ArrayList<Tahlil>()

    fun setData(newListData: List<Tahlil>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    inner class TahlilViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val binding = ItemTahlilBinding.bind(itemView)
        fun bind(data: Tahlil){
            binding.apply {
                tvTitle.text = data.title
                tvArabic.text = data.arabic
                tvTranslation.text = data.translation
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TahlilViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tahlil, parent, false)
        return TahlilViewHolder(view)
    }

    override fun onBindViewHolder(holder: TahlilViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listData.size
}