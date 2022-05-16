package com.shaadi.assignment.di

import com.shaadi.assignment.repository.MainRepository
import org.koin.dsl.module

val repositoryModule = module {

  single { MainRepository(get(), get(), get()) }

}
