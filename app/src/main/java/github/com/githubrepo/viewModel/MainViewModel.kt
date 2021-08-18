package github.com.githubrepo.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import github.com.githubrepo.model.UserProfile
import github.com.githubrepo.repository.Repository

class MainViewModel : ViewModel() {

    private val _username: MutableLiveData<String> = MutableLiveData()

    val user: LiveData<UserProfile> = Transformations.switchMap(_username) { count ->
        Repository.getUserProfile(count)
    }

    fun setCount(count: String) {
        if (_username.value == count) {
            return
        }
        _username.value = count
    }

    fun cancelJob() {
        Repository.cancelJob()
    }
}