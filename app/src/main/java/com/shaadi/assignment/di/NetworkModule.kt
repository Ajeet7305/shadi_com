package com.shaadi.assignment.di

import com.shaadi.assignment.model.UserStats
import com.shaadi.assignment.network.ShaadiClient
import com.shaadi.assignment.network.ShaadiService
import com.shaadi.assignment.network.RequestInterceptor
import com.skydoves.sandwich.ResponseDataSource
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

  single {
    OkHttpClient.Builder()
      .addInterceptor(RequestInterceptor())
      .build()
  }

  single {
    Retrofit.Builder()
      .client(get<OkHttpClient>())
      .baseUrl("https://randomuser.me/")
      .addConverterFactory(GsonConverterFactory.create())
      .build()
  }

  single { get<Retrofit>().create(ShaadiService::class.java) }

  single { ShaadiClient(get()) }

  single { ResponseDataSource<List<UserStats>>() }
}
