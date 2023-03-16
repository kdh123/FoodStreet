package com.dohyun.foodstreetandroid.data.restaurant.datasource

import com.dohyun.foodstreetandroid.data.restaurant.model.RestaurantDto
import com.dohyun.foodstreetandroid.data.retrofit.RestaurantAPI
import com.dohyun.foodstreetandroid.data.retrofit.toDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import javax.inject.Inject

class RestaurantRemoteDataSource @Inject constructor(private val service: Retrofit) {

    suspend fun getRestaurant(): Flow<List<RestaurantDto>> {
        return flow {
            service.create(RestaurantAPI::class.java).getRestaurant().run {
                if (isSuccessful) {
                    emit(body()?.result?.map {
                        it.toDto()
                    } ?: emptyList())
                }
            }
        }
    }
}