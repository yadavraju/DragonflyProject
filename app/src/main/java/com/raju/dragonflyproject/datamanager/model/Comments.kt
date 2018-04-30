package com.raju.dragonflyproject.datamanager.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Comments(val from: String, @SerializedName("text") val commentText: String) : Parcelable
