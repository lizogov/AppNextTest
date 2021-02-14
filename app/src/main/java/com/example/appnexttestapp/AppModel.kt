package com.example.appnexttestapp

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class AppModel(
    @PrimaryKey
    val package_name: String,
    val title: String,
    val icon: String,
    val description: String,
    val screenshots: String,
    val rating: Double,
    val size: Int,
    val downloads_min: String,
    val developer: String

) : Parcelable