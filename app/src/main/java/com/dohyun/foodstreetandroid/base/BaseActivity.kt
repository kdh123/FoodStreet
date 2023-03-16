package com.dohyun.foodstreetandroid.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.hilt.android.AndroidEntryPoint

abstract class BaseActivity<VB : ViewDataBinding> : AppCompatActivity() {
    abstract val layoutId: Int

    private var _binding: VB? = null
    val binding: VB
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = DataBindingUtil.setContentView(this, layoutId)

        initView()
        initData()
    }

    abstract fun initData()
    abstract fun initView()
}