package com.shaadi.assignment.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.shaadi.assignment.model.UserStats

@Database(entities = [UserStats::class], version = 1, exportSchema = true)
@TypeConverters(value = [IntegerListConverter::class])
abstract class AppDatabase : RoomDatabase() {

  abstract fun userDao(): UserDao
}
