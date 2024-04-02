package com.example.ecommerceconcept.homeStoreFragment

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.databinding.ItemCategoryBinding

data class Category(
    val title: String,
    var imageId: Int,
)

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    private var list = mutableListOf<Category>()
    private var selectedCategoryIndex = 0
    private lateinit var context: Context

    fun setData(list: MutableList<Category>) {
        this.list = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        context = parent.context
        return CategoryViewHolder(
            ItemCategoryBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(list[position])
        if (position == 0)
            holder.selectCategoryOnClick()
        holder.itemView.setOnClickListener {
            holder.selectCategoryOnClick()
            if (position != selectedCategoryIndex)
                holder.unselectCategory()
            selectedCategoryIndex = holder.adapterPosition
        }
    }

    inner class CategoryViewHolder(private val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category) {
            binding.ivIcon.setImageResource(category.imageId)
            binding.tvTitle.text = category.title
        }

        fun selectCategoryOnClick() {
            binding.cvCircle.setCardBackgroundColor(Color.parseColor("#FF6E4E"))
            binding.ivIcon.setColorFilter(Color.WHITE)
        }

        fun unselectCategory() {
            binding.cvCircle.setCardBackgroundColor(context.getColor(R.color.white))
            binding.ivIcon.setColorFilter(context.getColor(R.color.gray))
        }
    }
}