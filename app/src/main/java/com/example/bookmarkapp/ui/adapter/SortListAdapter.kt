package com.example.bookmarkapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.bookmarkapp.databinding.ItemBookmarkSortBinding
import com.example.bookmarkapp.ui.model.Sort

class SortListAdapter(
    private var selectPosition: Int,
    private val sortItemClick: (Sort) -> Unit
) : ListAdapter<Sort, SortListAdapter.SortListViewHolder>(diffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SortListViewHolder
            = SortListViewHolder(ItemBookmarkSortBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun onBindViewHolder(holder: SortListViewHolder, position: Int) {
        holder.bind(currentList[position], position)
    }

    inner class SortListViewHolder(private val binding: ItemBookmarkSortBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(sort: Sort, position: Int) {
            binding.sort = sort

            sort.check = selectPosition == position

            itemView.setOnClickListener {
                sortItemClick(sort)
                selectPosition = position
            }
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Sort>() {
            override fun areContentsTheSame(oldItem: Sort, newItem: Sort) =
                oldItem == newItem

            override fun areItemsTheSame(oldItem: Sort, newItem: Sort) =
                oldItem.check == newItem.check
        }
    }
}