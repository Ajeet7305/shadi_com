package com.shaadi.assignment.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResponseListUserStats(
        val results : List<UserStats>,
        val info : Info
):Parcelable

