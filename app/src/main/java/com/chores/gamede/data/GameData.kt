package com.chores.gamede.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameData(
    var name: String = "",
    var producer: String = "",
    var rating: String = "",
    var details: String = "",
    var photo: Int = 0,
    var logo: Int = 0
) : Parcelable
