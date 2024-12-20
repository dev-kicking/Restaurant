package com.devkick.datastore.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.devkick.datastore.datasource.RestaurantDao
import com.devkick.model.Restaurant

@Database(entities = [Restaurant::class], version = 1,)
abstract class AppDatabase : RoomDatabase() {
    abstract fun restaurantDao(): RestaurantDao
}