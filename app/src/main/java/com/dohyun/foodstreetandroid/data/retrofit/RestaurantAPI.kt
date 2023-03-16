package com.dohyun.foodstreetandroid.data.retrofit

import com.dohyun.foodstreetandroid.data.restaurant.model.RestaurantDto
import retrofit2.Response
import retrofit2.http.GET

interface RestaurantAPI {
    @GET("/v3/fd2b6932-c5f6-44ba-9e6c-bf0e867c9219")
    suspend fun getRestaurant(): Response<RestaurantResponse>
}

data class RestaurantResponse(
    val result: List<RestaurantData>
)

data class RestaurantData(
    val id: String,
    val name: String
)

fun RestaurantData.toDto() = RestaurantDto(
    id = id,
    name = name
)