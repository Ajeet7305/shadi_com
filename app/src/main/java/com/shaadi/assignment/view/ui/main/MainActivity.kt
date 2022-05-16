package com.shaadi.assignment.view.ui.main

import android.os.Bundle
import com.shaadi.assignment.R
import com.shaadi.assignment.base.DatabindingActivity
import com.shaadi.assignment.databinding.ActivityMainBinding
import com.shaadi.assignment.view.adapter.UserAdapter
import com.skydoves.transformationlayout.onTransformationStartContainer
import org.koin.android.viewmodel.ext.android.getViewModel

class MainActivity : DatabindingActivity() {

    private val binding: ActivityMainBinding by binding(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        onTransformationStartContainer()
        super.onCreate(savedInstanceState)
        binding.apply {
            lifecycleOwner = this@MainActivity
            adapter = UserAdapter()
            vm = getViewModel()
        }
    }
}
