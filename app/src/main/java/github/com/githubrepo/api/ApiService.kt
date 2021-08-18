package github.com.githubrepo.api

import github.com.githubrepo.model.UserProfile
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api/")
    suspend fun getProfile(
        @Query("results") count: String
    ): UserProfile
}