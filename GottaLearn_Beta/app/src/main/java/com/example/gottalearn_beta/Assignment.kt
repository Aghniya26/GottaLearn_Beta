package com.example.gottalearn_beta

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Assignment(var title: String, var description: String, var subject: String, var date: String, var priority: String):Parcelable