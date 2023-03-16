package com.dohyun.foodstreetandroid.data.restaurant.model

data class RestaurantState(
    val isInit: Boolean = false,
    val isLoading: Boolean = false,
    val restaurants: List<RestaurantDto>? = null,
    val isError: Boolean = false
)
