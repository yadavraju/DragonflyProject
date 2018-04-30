package com.raju.dragonflyproject.datamanager.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Images (val id : String, val caption : String) :Parcelable