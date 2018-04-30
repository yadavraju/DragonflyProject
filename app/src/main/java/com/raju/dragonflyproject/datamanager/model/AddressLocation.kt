package com.raju.dragonflyproject.datamanager.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AddressLocation(val name: String, val address: String,
                           val city: String, val state: String) : Parcelable