package com.shaadi.assignment.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.shaadi.assignment.model.UserStats

@Dao
interface UserDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertUserStats(userStats: List<UserStats>)

  @Query("SELECT * FROM UserStats")
  fun getUserStats(): List<UserStats>


}
