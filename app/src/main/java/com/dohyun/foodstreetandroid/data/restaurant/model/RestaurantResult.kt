package com.dohyun.foodstreetandroid.data.restaurant.model

sealed class RestaurantResult {
    object Loading : RestaurantResult()
    data class Success (val data : List<RestaurantDto>) : RestaurantResult()
    object Fail : RestaurantResult()
}
