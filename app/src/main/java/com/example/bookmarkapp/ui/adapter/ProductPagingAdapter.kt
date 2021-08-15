package com.example.bookmarkapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.bookmarkapp.R
import com.example.bookmarkapp.data.database.entity.BookMark
import com.example.bookmarkapp.databinding.ItemProductListBinding
import com.example.bookmarkapp.util.TimeFormatUtils
import java.util.*

class ProductPagingAdapter(
    private val bookmarkItemClick: (BookMark) -> Unit,
    private val bookMarkClick: (BookMark) -> Unit
) : PagingDataAdapter<BookMark, ProductPagingAdapter.ProductListViewHolder>(diffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder
            = ProductListViewHolder(ItemProductListBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
        getItem(position)?.let { bookmark ->
            holder.bind(bookmark)
        }
    }

    inner class ProductListViewHolder(private val binding: ItemProductListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(bookMark: BookMark) {
            binding.bookmark = bookMark

            itemView.setOnClickListener {
                bookmarkItemClick(bookMark)
            }

            binding.ivItemBookmark.setOnClickListener { view ->
                bookMark.isBookMark = !bookMark.isBookMark
                bookMarkClick(bookMark)

                when(bookMark.isBookMark) {
                    true -> {
                        view.setBackgroundResource(R.drawable.baseline_favorite_24)
                        bookMark.time = TimeFormatUtils.dateFormat.format(Date(System.currentTimeMillis()))
                    }
                    false -> view.setBackgroundResource(R.drawable.baseline_favorite_border_24)
                }
            }
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<BookMark>() {
            override fun areContentsTheSame(oldItem: BookMark, newItem: BookMark) =
                oldItem == newItem

            override fun areItemsTheSame(oldItem: BookMark, newItem: BookMark) =
                oldItem.id == newItem.id
        }
    }
}