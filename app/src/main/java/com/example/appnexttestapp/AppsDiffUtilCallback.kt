package com.example.appnexttestapp

import androidx.recyclerview.widget.DiffUtil

class AppsDiffUtilCallback : DiffUtil.ItemCallback<AppModel>() {

    override fun areItemsTheSame(oldItem: AppModel, newItem: AppModel): Boolean {
        return oldItem.package_name == newItem.package_name
    }

    override fun areContentsTheSame(oldItem: AppModel, newItem: AppModel): Boolean {
        return oldItem == newItem
    }
}