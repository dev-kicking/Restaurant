package com.devkick.datastore.datasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.devkick.model.Restaurant

@Dao
interface RestaurantDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(restaurantList: List<Restaurant>)

    @Query("SELECT * FROM restaurant")
    suspend fun getRestaurants(): List<Restaurant>

    @Query("SELECT * FROM restaurant WHERE code=:code")
    suspend fun getRestaurant(code: String): Restaurant?

    @Query("SELECT * FROM restaurant WHERE isLiked = 1 ORDER BY likeTime ASC")
    suspend fun bookmarkedRestaurants(): List<Restaurant>

    @Update
    suspend fun updateRestaurant(restaurant: Restaurant)
}