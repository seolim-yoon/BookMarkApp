package com.example.bookmarkapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.bookmarkapp.data.remote.response.Product
import com.example.bookmarkapp.databinding.ItemProductListBinding

class ProductPagingAdapter(
    private val productItemClick: (Product) -> Unit
) : PagingDataAdapter<Product, ProductPagingAdapter.ProductListViewHolder>(diffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder
            = ProductListViewHolder(ItemProductListBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
        getItem(position)?.let { product ->
            holder.bind(product)
        }
    }

    inner class ProductListViewHolder(private val binding: ItemProductListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.product = product

            itemView.setOnClickListener {
                productItemClick(product)
            }
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Product>() {
            override fun areContentsTheSame(oldItem: Product, newItem: Product) =
                oldItem == newItem

            override fun areItemsTheSame(oldItem: Product, newItem: Product) =
                oldItem.id == newItem.id
        }
    }
}