package com.spidev.android_arquitecture_component_demo.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.spidev.android_arquitecture_component_demo.model.UserData
import com.spidev.android_arquitecture_component_demo.repository.UserRepository

/**
 * Created by carlos on 1/2/18.
 */
class UserProfileViewModel : ViewModel() {

    var userId = 0
    private var userData: LiveData<UserData>
    private var userRepository: UserRepository = UserRepository()

    init {
        this.userData = userRepository.getUser(this.userId)
    }

    fun getUser(): LiveData<UserData> {
        return this.userData
    }

}