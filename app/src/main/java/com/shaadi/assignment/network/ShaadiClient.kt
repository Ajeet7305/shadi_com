package com.shaadi.assignment.network

import com.shaadi.assignment.model.ResponseListUserStats
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.DataRetainPolicy
import com.skydoves.sandwich.ResponseDataSource
import com.skydoves.sandwich.disposables.CompositeDisposable

class ShaadiClient(private val shaadiService: ShaadiService) {

  fun fetchUserStatsList(
          dataSource: ResponseDataSource<ResponseListUserStats>,
          disposable: CompositeDisposable,
          onResult: (response: ApiResponse<ResponseListUserStats>) -> Unit
  ) {
    dataSource
            // Retain fetched data on the memory storage temporarily.
            // If request again, returns the retained data instead of re-fetching from the network.
            .dataRetainPolicy(DataRetainPolicy.RETAIN)
            // retry fetching data 3 times with 5000 milli-seconds time interval when the request gets failure.
            .retry(3, 5000L)
            // joins onto CompositeDisposable as a disposable and dispose onCleared().
            .joinDisposable(disposable)
            // combine network service to the data source.
            .combine(shaadiService.fetchUserList(), onResult)
            // request API network call asynchronously.
            // if the request is successful, the data source will hold the success data.
            // in the next request after success, returns the cached API response with data.
            .request()
  }
}
