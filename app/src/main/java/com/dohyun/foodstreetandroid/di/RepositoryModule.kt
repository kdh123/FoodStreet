package com.dohyun.foodstreetandroid.di

import com.dohyun.foodstreetandroid.data.restaurant.RestaurantRepositoryImpl
import com.dohyun.foodstreetandroid.data.restaurant.datasource.RestaurantRemoteDataSource
import com.dohyun.foodstreetandroid.domain.repository.RestaurantRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun bindRestaurantRepository(remoteDataSource: RestaurantRemoteDataSource): RestaurantRepository = RestaurantRepositoryImpl(remoteDataSource = remoteDataSource)
}