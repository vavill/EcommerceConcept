package com.example.ecommerceconcept.homeStoreFragment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceconcept.databinding.ItemProductBinding

class ProductAdapter(val onClick: () -> Unit) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    private var listProduct = mutableListOf<Product>()
    private lateinit var context: Context

    fun setData(list: List<Product>) {
        listProduct = list.toMutableList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        context = parent.context
        return ProductViewHolder(
            ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return listProduct.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.click()
        return holder.bind(listProduct[position])
    }

    inner class ProductViewHolder(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.tvProductTitle.text = product.title
            binding.tvPrice.text = "$${product.price.toString()}"
            binding.tvPriceWithoutSale.text = "$${product.priceWithoutSale.toString()}"
            binding.ivImage.setImageResource(product.imageId)

            when (product.isFavourite) {
                true -> binding.ivFavourite.setImageResource(
                    context.resources.getIdentifier(
                        "ic_favourite_true",
                        "drawable",
                        context.packageName
                    )
                )

                false -> binding.ivFavourite.setImageResource(
                    context.resources.getIdentifier(
                        "ic_favourite_false",
                        "drawable",
                        context.packageName
                    )
                )
            }
        }

        fun click() {
            binding.cvCard.setOnClickListener {
                onClick.invoke()
            }
        }
    }
}

data class Product(
    val title: String,
    val price: Int,
    val priceWithoutSale: Int,
    val imageId: Int,
    var isFavourite: Boolean,
) {

}
