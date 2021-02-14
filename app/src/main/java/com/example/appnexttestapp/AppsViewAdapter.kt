package com.example.appnexttestapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView


class AppsViewAdapter(
    private val onAppClickListener: OnAppClickListener,
    context: Context
) : RecyclerView.Adapter<AppViewHolder>() {

    private val layoutInflater: LayoutInflater = context
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    private val asyncListDiffer = AsyncListDiffer<AppModel>(this, AppsDiffUtilCallback())

    override fun getItemCount() = asyncListDiffer.currentList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        val view = layoutInflater.inflate(R.layout.item_app, parent, false)
        return AppViewHolder(view, onAppClickListener)
    }

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        val movieModel = asyncListDiffer.currentList[position]
        holder.bind(movieModel)
    }

    fun setData(newItems: List<AppModel>) {
        asyncListDiffer.submitList(newItems)
    }

}