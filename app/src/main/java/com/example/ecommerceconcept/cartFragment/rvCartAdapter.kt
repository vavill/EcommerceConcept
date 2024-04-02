package com.example.ecommerceconcept.cartFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceconcept.databinding.ItemRvCartBinding

data class ProductCart(
    val title: String,
    val price: String,
    val image: Int,
)

class RvCartAdapter: RecyclerView.Adapter<RvCartAdapter.RvCartViewholder>() {

    private var listProductCart = listOf<ProductCart>()

    fun setData(list: List<ProductCart>) {
        listProductCart = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvCartViewholder {
        return RvCartViewholder(
            ItemRvCartBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return listProductCart.size
    }

    override fun onBindViewHolder(holder: RvCartViewholder, position: Int) {
        holder.bind(listProductCart[position])
    }

    inner class RvCartViewholder(private val binding: ItemRvCartBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(product: ProductCart) {
            binding.tvTitle.text = product.title
            binding.tvPrice.text = product.price
            binding.ivImage.setImageResource(product.image)
        }
    }
}