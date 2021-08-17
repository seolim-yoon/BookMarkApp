package com.example.bookmarkapp.ui.adapter

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.bookmarkapp.R

object ImageViewBindingAdapter {
    @BindingAdapter("imageUrl")
    @JvmStatic
    fun loadImage(ivThumbnail: ImageView, url: String) {
        val circularProgressDrawable = CircularProgressDrawable(ivThumbnail.context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

        Glide.with(ivThumbnail.context)
            .load(url)
            .placeholder(circularProgressDrawable)
            .error(R.drawable.baseline_warning_24)
            .transition(DrawableTransitionOptions().crossFade())
            .centerCrop()
            .timeout(2000)
            .into(ivThumbnail)
    }

    @BindingAdapter("iconImageUrl")
    @JvmStatic
    fun loadIconImage(ivIcon: ImageView, drawable: Drawable) {
        Glide.with(ivIcon.context)
            .load(drawable)
            .centerInside()
            .into(ivIcon)
    }
}