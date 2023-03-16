package com.dohyun.foodstreetandroid.presentation

import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.dohyun.foodstreetandroid.R
import com.dohyun.foodstreetandroid.base.BaseActivity
import com.dohyun.foodstreetandroid.databinding.ActivityMainBinding
import com.dohyun.foodstreetandroid.presentation.ui.RestaurantViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity(override val layoutId: Int = R.layout.activity_main) : BaseActivity<ActivityMainBinding>() {

    private val viewModel: RestaurantViewModel by viewModels()

    override fun initData() {
        observeData()
        viewModel.getRestaurants()
    }

    override fun initView() {

    }

    private fun observeData() {
        lifecycleScope.launch {
            viewModel.restaurantState.collect { state ->
                if(state.isInit && !state.isError) {
                    Log.e("sfsf", "${state.restaurants}")
                }
            }
        }
    }
}