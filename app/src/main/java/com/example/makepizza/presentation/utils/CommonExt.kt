package com.example.makepizza.presentation.utils

import android.widget.ImageView
import com.squareup.picasso.Picasso

//Load image
fun ImageView.load(url: String, error: Int? = null) {
    if (error == null)
        Picasso.get().load(url).into(this)
    else Picasso.get().load(url).error(error).into(this)
}