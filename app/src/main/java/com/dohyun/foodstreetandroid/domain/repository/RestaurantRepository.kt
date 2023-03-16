package com.dohyun.foodstreetandroid.domain.repository

import com.dohyun.foodstreetandroid.data.restaurant.model.RestaurantDto
import kotlinx.coroutines.flow.Flow

interface RestaurantRepository {
    suspend fun getRestaurant() : Flow<List<RestaurantDto>>
}