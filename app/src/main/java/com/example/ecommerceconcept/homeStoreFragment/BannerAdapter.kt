package com.example.ecommerceconcept.homeStoreFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceconcept.databinding.ItemBannerBinding

class BannerAdapter: RecyclerView.Adapter<BannerAdapter.BannerViewHolder>() {
    private var list = mutableListOf<Int>()

    fun setData(list: List<Int>) {
        this.list = list.toMutableList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        return BannerViewHolder(
            ItemBannerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class BannerViewHolder(private val binding: ItemBannerBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(imageId: Int) {
            binding.ivImage.setImageResource(imageId)
        }
    }
}