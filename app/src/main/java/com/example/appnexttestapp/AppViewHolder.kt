package com.example.appnexttestapp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_app.view.*


class AppViewHolder(view: View, onAppClickListener: OnAppClickListener) : RecyclerView.ViewHolder(view) {

    private val appIcon: ImageView = view.item_app_icon
    private val appTitle: TextView = view.item_app_title
    private val appSize: TextView = view.item_app_size

    init {
        view.setOnClickListener {
            onAppClickListener.onAppClicked(adapterPosition)
        }
    }

    fun bind(appModel: AppModel) {
        Picasso.get().load(appModel.icon).into(appIcon)
        appTitle.text = appModel.title
        val res:Float = (appModel.size/1000000).toFloat()
        appSize.text = String.format("%.2f MB",res)
    }
}