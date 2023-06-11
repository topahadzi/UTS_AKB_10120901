package com.example.uts_akb_10120901.ui.daily_activity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.uts_akb_10120901.databinding.ItemDailyBinding
import com.example.uts_akb_10120901.databinding.ItemFriendBinding


class DailyAdapter() : RecyclerView.Adapter<DailyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDailyBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(item = differ.currentList[position])
    }

    override fun getItemCount(): Int = differ.currentList.size

    inner class ViewHolder(private val binding: ItemDailyBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DailyModel) {
            binding.run {
                dailyImg.setImageResource(item.image)
                dailyTitle.text = item.name
                dailyDesc.text = item.desc
            }
        }
    }

    private val differCallBack = object : DiffUtil.ItemCallback<DailyModel>() {
        override fun areItemsTheSame(
            oldExampleModel: DailyModel, newExampleModel: DailyModel
        ): Boolean {
            return oldExampleModel.image == newExampleModel.image
        }

        override fun areContentsTheSame(
            oldExampleModel: DailyModel, newExampleModel: DailyModel
        ): Boolean {
            return oldExampleModel == newExampleModel
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)

}