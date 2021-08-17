package com.example.bookmarkapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.bookmarkapp.data.database.entity.BookMark
import com.example.bookmarkapp.databinding.ItemBookmarkListBinding
import com.example.bookmarkapp.util.FormatUtils
import java.util.*

class ProductPagingAdapter(
    private val productItemClick: (BookMark) -> Unit,
    private val bookMarkClick: (BookMark) -> Unit
) : PagingDataAdapter<BookMark, ProductPagingAdapter.ProductListViewHolder>(diffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder
            = ProductListViewHolder(ItemBookmarkListBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
        getItem(position)?.let { bookmark ->
            holder.bind(bookmark)
        }
    }

    inner class ProductListViewHolder(private val binding: ItemBookmarkListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(bookMark: BookMark) {
            binding.bookmark = bookMark
            binding.tvItemTime.visibility = View.GONE

            itemView.setOnClickListener {
                productItemClick(bookMark)
            }

            binding.ivItemBookmark.setOnClickListener { view ->
                bookMark.isBookMark = !bookMark.isBookMark

                if(bookMark.isBookMark)
                    bookMark.time = FormatUtils.dateFormat.format(Date(System.currentTimeMillis()))

                bookMarkClick(bookMark)
                binding.invalidateAll()
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