package com.shaadi.assignment.view.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.shaadi.assignment.base.LiveCoroutinesViewModel
import com.shaadi.assignment.model.UserStats
import com.shaadi.assignment.repository.MainRepository
import timber.log.Timber

class MainViewModel constructor(
  private val mainRepository: MainRepository
) : LiveCoroutinesViewModel() {

  private var userFetchingLiveData: MutableLiveData<Boolean> = MutableLiveData(true)
  val userListLiveData: LiveData<List<UserStats>>

  private val _toastLiveData: MutableLiveData<String> = MutableLiveData()
  val toastLiveData: LiveData<String> get() = _toastLiveData

  init {
    Timber.d("injection MainViewModel")

    userListLiveData = userFetchingLiveData.switchMap {
      launchOnViewModelScope {
        mainRepository.loadUserStats(disposables) { _toastLiveData.postValue(it) }
      }
    }
  }
}
