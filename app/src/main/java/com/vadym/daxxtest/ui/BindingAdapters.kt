package com.vadym.daxxtest.ui

import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

@BindingAdapter("ratingOrInvisible")
fun RatingBar.setRatingOrInvisible(value: Float?) {
    when (value){
        0.0f -> visibility = View.INVISIBLE
        else -> {
            visibility = View.VISIBLE
            this.rating = value!!
        }
    }
}


@BindingAdapter("imageFromUrl")
fun bindImageFromUrl(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        Glide.with(view.context)
            .load(imageUrl)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(view)
    }
}