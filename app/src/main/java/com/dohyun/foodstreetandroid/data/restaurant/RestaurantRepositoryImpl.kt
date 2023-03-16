package com.dohyun.foodstreetandroid.data.restaurant

import com.dohyun.foodstreetandroid.data.restaurant.datasource.RestaurantRemoteDataSource
import com.dohyun.foodstreetandroid.data.restaurant.model.RestaurantDto
import com.dohyun.foodstreetandroid.domain.repository.RestaurantRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RestaurantRepositoryImpl @Inject constructor(val remoteDataSource: RestaurantRemoteDataSource) : RestaurantRepository {

    override suspend fun getRestaurant(): Flow<List<RestaurantDto>> {
        return remoteDataSource.getRestaurant()
    }
}