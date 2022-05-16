package com.shaadi.assignment.repository

import androidx.lifecycle.MutableLiveData
import com.shaadi.assignment.mapper.ErrorResponseMapper
import com.shaadi.assignment.model.UserErrorResponse
import com.shaadi.assignment.model.ResponseListUserStats
import com.shaadi.assignment.model.UserStats
import com.shaadi.assignment.network.ShaadiClient
import com.shaadi.assignment.persistence.UserDao
import com.skydoves.sandwich.*
import com.skydoves.sandwich.disposables.CompositeDisposable
import com.skydoves.whatif.whatIfNotNull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

class MainRepository constructor(
        private val shaadiClient: ShaadiClient,
        private val marvelDataSource: ResponseDataSource<ResponseListUserStats>,
        private val userDao: UserDao
) : Repository {

  init {
    Timber.d("Injection MainRepository")
  }

  suspend fun loadUserStats(
    disposable: CompositeDisposable,
    error: (String?) -> Unit
  ) = withContext(Dispatchers.IO) {
    val liveData = MutableLiveData<List<UserStats>>()
    val users = userDao.getUserStats()
    if (users.isEmpty()) {
      /**
       * fetch [Users] from the network and getting [ApiResponse] asynchronously.
       * @see [onSuccess](https://github.com/skydoves/sandwich#onsuccess-onerror-onexception)
       * */
      shaadiClient.fetchUserStatsList(marvelDataSource, disposable) { apiResponse ->
        apiResponse
          // handle the case when the API request gets a success response.
          .onSuccess {
            data.whatIfNotNull {
              liveData.postValue(it.component1())
              userDao.insertUserStats(it.results)
            }
          }
          // handle the case when the API request gets an error response.
          // e.g. internal server error.
          .onError {
            /** maps the [ApiResponse.Failure.Error] to the [UserErrorResponse] using the mapper. */
            map(ErrorResponseMapper) { error("[Code: $code]: $message") }
          }
          // handle the case when the API request gets an exception response.
          // e.g., network connection error.
          .onException { error(message()) }
      }
    }
    liveData.apply { postValue(users) }
  }
}
