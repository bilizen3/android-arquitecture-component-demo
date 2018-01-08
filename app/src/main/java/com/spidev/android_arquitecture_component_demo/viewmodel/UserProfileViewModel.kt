package com.spidev.android_arquitecture_component_demo.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.spidev.android_arquitecture_component_demo.repository.UserRepository
import com.spidev.android_arquitecture_component_demo.repository.local.entity.User
import javax.inject.Inject

/**
 * Created by carlos on 1/2/18.
 */
class UserProfileViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    var userId = 0
    private var user: LiveData<User>

    init {
        this.user = userRepository.getUser(userId)
    }

    fun getUser(): LiveData<User> {
        return this.user
    }
}