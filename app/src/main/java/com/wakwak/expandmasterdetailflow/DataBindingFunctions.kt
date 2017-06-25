package com.wakwak.expandmasterdetailflow

import android.databinding.BindingAdapter
import android.widget.ImageView
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
        url.isNotEmpty { Picasso.with(v.context).load(url).into(v) }
    }

    @BindingAdapter("backgroundImage")
    @JvmStatic fun loadBackgroundImage(v: ImageView, url: String) {
        url.isNotEmpty { Picasso.with(v.context).load(it).into(v) }
    }

    @BindingAdapter("profileImage")
    @JvmStatic fun loadProfileImage(v: ImageView, url: String) {
        url.isNotEmpty { Picasso.with(v.context).load(it).into(v) }
    }
}
