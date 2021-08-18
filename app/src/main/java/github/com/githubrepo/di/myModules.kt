package github.com.githubrepo.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import github.com.githubrepo.viewModel.MainViewModel

//koin module
val myModule = module {

    viewModel { MainViewModel() }
}