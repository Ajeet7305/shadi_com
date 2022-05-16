package com.shaadi.assignment.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class UserStats(
        val gender: String,
        val name: Name,
        val location: Location,
        val email: String,
        val login: Login,
        val dob: Dob,
        val registered: Registered,
        val phone: String,
        @PrimaryKey val cell: String,
        val id: Id,
        val picture: Picture,
        val nat: String
) : Parcelable