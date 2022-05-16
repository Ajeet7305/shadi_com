package com.shaadi.assignment.network

import com.shaadi.assignment.model.ResponseListUserStats
import retrofit2.Call
import retrofit2.http.GET

interface ShaadiService {

  @GET(
    "api/?results=10"
  )
  fun fetchUserList(): Call<ResponseListUserStats>
}
