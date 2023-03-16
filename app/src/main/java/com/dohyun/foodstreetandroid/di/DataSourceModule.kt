package com.dohyun.foodstreetandroid.di

import com.dohyun.foodstreetandroid.data.restaurant.datasource.RestaurantRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Singleton
    @Provides
    fun provideRemoteRestaurantDataSource(service: Retrofit): RestaurantRemoteDataSource = RestaurantRemoteDataSource(service = service)
}