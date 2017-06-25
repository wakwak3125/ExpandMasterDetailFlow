package com.wakwak.expandmasterdetailflow

import android.databinding.BindingAdapter
import android.support.v4.content.ContextCompat
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

/**
 * Created by Ryo on 2017/06/25.
 */
object DataBindingFunctions {

    private inline fun String.isNotEmpty(block: (String) -> Unit) {
        if (this.isNotEmpty()) block.invoke(this)
    }

    @BindingAdapter("foregroundImage")
    @JvmStatic fun loadForegroundImage(v: ImageView, url: String) {
        if (url.isNotEmpty()) Picasso.with(v.context).load(url).into(v)
    }

    @BindingAdapter("backgroundImage", "radius", "margin", requireAll = false)
    @JvmStatic fun loadBackgroundImage(v: ImageView, url: String, radius: Int = 10, margin: Int = 0) {
        if (url.isNotEmpty()) Picasso.with(v.context).load(url).transform(RoundedCornersTransformer(radius, margin)).into(v)
    }

    @BindingAdapter("profileImage")
    @JvmStatic fun loadProfileImage(v: ImageView, url: String) {
        if (url.isNotEmpty()) Picasso.with(v.context).load(url).into(v)
    }

    @BindingAdapter("postTheme")
    @JvmStatic fun applyPostTheme(v: TextView, theme: String) {
        when (theme) {
            "light" -> {

            }
            "dark" -> {
                v.setTextColor(ContextCompat.getColor(v.context, android.R.color.white))
            }
        }
    }
}
