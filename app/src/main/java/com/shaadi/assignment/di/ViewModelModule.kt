package com.shaadi.assignment.di

import com.shaadi.assignment.view.ui.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

  viewModel { MainViewModel(get()) }

}
