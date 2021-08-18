package github.com.githubrepo.repository

import androidx.lifecycle.LiveData
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import github.com.githubrepo.api.ApiService
import github.com.githubrepo.api.RetrofitClient
import github.com.githubrepo.model.UserProfile

object Repository {
    var job: CompletableJob? = null

    fun getUserProfile(count: String): LiveData<UserProfile> {
        job = Job()

        return object : LiveData<UserProfile>() {
            override fun onActive() {
                super.onActive()
                job?.let { theJob ->
                    CoroutineScope(IO + theJob).launch {

                        //fetch data from web service here
                        val userProfile = RetrofitClient.createWebAPI<ApiService>().getProfile(count)
                        withContext(Main) {
                            try {
                                value = userProfile
                                theJob.complete()
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                        }
                    }
                }
            }
        }
    }

    //cancel the job
    fun cancelJob() {
        job?.cancel()
    }
}