package com.devkick.data.repository

import com.devkick.data.api.RestaurantService
import com.devkick.data.mapper.toData
import com.devkick.data_api.RestaurantRepository
import com.devkick.datastore.room.AppDatabase
import com.devkick.model.Restaurant
import com.devkick.model.RestaurantList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

class RestaurantRepositoryImpl @Inject constructor(
    private val service: RestaurantService,
    private val appDatabase: AppDatabase,
) : RestaurantRepository {

    override suspend fun getRestaurantListApi(): Flow<RestaurantList> = flow {
        runCatching {
            service.getRestaurantList()
        }.onSuccess { response ->
            val restaurants = appDatabase.restaurantDao().getRestaurants()
            if (restaurants.isEmpty()) {
                appDatabase.restaurantDao().insertAll(response.list.map { it.toData() })
            }
            emit(RestaurantList(response.title, appDatabase.restaurantDao().getRestaurants()))
        }.onFailure {
            throw it
        }
    }

    override suspend fun getRestaurant(): List<Restaurant> {
        return appDatabase.restaurantDao().getRestaurants()
    }

    override suspend fun getLikedRestaurant(): List<Restaurant> {
        return appDatabase.restaurantDao().likedRestaurants()
    }

    override suspend fun updateRestaurant(
        restaurantCode: String,
        like: Boolean
    ): Flow<Unit> = flow {
        appDatabase.restaurantDao().getRestaurant(restaurantCode)?.let { restaurant ->
            appDatabase.restaurantDao().updateRestaurant(restaurant.copy(isLiked = like))
            emit(Unit)
        }
    }
}