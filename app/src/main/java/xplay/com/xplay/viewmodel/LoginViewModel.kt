package xplay.com.xplay.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import xplay.com.xplay.model.User

class LoginViewModel : ViewModel(){

    private var user : MutableLiveData<User>

    init {
        user = MutableLiveData()
        user.value = User()
    }

    fun getUser() : MutableLiveData<User> = user

    override fun onCleared() {
        super.onCleared()
    }
}