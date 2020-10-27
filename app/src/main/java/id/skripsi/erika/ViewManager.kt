package id.skripsi.erika

import android.content.Context
import android.view.KeyCharacterMap.load
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso


fun View.visible() {
    visibility = View.VISIBLE
}


fun View.gone() {
    visibility = View.GONE
}

fun ImageView.imageViewGlide(context: Context, url: String?) {
    val _url = "http://45.80.181.198:5003/${url?.toLowerCase()?.trim()}.jpg"
    Picasso.get().load(_url).into(this)
}



