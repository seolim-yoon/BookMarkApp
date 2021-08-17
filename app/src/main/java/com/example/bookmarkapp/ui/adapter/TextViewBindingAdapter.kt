package com.example.bookmarkapp.ui.adapter

import android.annotation.SuppressLint
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.bookmarkapp.util.FormatUtils

object TextViewBindingAdapter {
    @SuppressLint("SetTextI18n")
    @BindingAdapter("setPrice")
    @JvmStatic
    fun setPrice(tvPrice: TextView, price: Int) {
        tvPrice.text = "가격 : ${FormatUtils.priceFormat.format(price)}원"
    }
}