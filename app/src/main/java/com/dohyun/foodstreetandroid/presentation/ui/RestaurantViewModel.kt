package com.dohyun.foodstreetandroid.presentation.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dohyun.foodstreetandroid.data.restaurant.model.RestaurantResult
import com.dohyun.foodstreetandroid.data.restaurant.model.RestaurantState
import com.dohyun.foodstreetandroid.domain.repository.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(private val restaurantRepository: RestaurantRepository) : ViewModel() {
    private val channel = Channel<RestaurantResult>()

    val restaurantState: StateFlow<RestaurantState> = channel
        .receiveAsFlow()
        .runningFold(RestaurantState(), ::convertToNewState)
        .stateIn(scope = viewModelScope, started = SharingStarted.Eagerly, initialValue = RestaurantState())

    private fun convertToNewState(state: RestaurantState, result: RestaurantResult): RestaurantState {
        return when (result) {
            is RestaurantResult.Loading -> {
                state.copy(
                    isLoading = true
                )
            }

            is RestaurantResult.Success -> {
                state.copy(
                    isInit = true,
                    restaurants = result.data
                )
            }

            is RestaurantResult.Fail -> {
                state.copy(
                    isInit = true,
                    isError = true
                )
            }
        }
    }

    fun getRestaurants() {
        viewModelScope.launch {
            channel.send(RestaurantResult.Loading)
            restaurantRepository.getRestaurant()
                .catch {
                    channel.send(RestaurantResult.Fail)
                }
                .collect {
                    Log.e("ssss", "$it")
                    channel.send(RestaurantResult.Success(it))
                }
        }
    }
}