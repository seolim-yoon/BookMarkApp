package com.example.bookmarkapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.bookmarkapp.R
import com.example.bookmarkapp.data.database.entity.BookMark
import com.example.bookmarkapp.databinding.ItemBookmarkListBinding
import com.example.bookmarkapp.util.TimeFormatUtils
import java.util.*

class BookMarkListAdapter(
    private val bookMarkItemClick: (BookMark) -> Unit,
    private val bookMarkClick: (BookMark) -> Unit
) : ListAdapter<BookMark, BookMarkListAdapter.ProductListViewHolder>(diffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder
            = ProductListViewHolder(ItemBookmarkListBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class ProductListViewHolder(private val binding: ItemBookmarkListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(bookMark: BookMark) {
            binding.bookmark = bookMark

            itemView.setOnClickListener {
                bookMarkItemClick(bookMark)
            }

            binding.ivItemBookmark.setOnClickListener { view ->
                bookMark.isBookMark = !bookMark.isBookMark
                when(bookMark.isBookMark) {
                    true -> {
                        bookMark.time = TimeFormatUtils.dateFormat.format(Date(System.currentTimeMillis()))
                    }
                }
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