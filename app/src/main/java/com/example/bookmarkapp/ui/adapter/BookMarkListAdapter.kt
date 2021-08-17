package com.example.bookmarkapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.bookmarkapp.data.database.entity.BookMark
import com.example.bookmarkapp.databinding.ItemBookmarkListBinding
import com.example.bookmarkapp.util.FormatUtils
import java.util.*

class BookMarkListAdapter(
    private val bookMarkItemClick: (BookMark) -> Unit,
    private val bookMarkClick: (BookMark) -> Unit
) : ListAdapter<BookMark, BookMarkListAdapter.BookMarkListViewHolder>(diffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookMarkListViewHolder
            = BookMarkListViewHolder(ItemBookmarkListBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: BookMarkListViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class BookMarkListViewHolder(private val binding: ItemBookmarkListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(bookMark: BookMark) {
            binding.bookmark = bookMark
            binding.tvItemTime.visibility = View.VISIBLE

            itemView.setOnClickListener {
                bookMarkItemClick(bookMark)
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