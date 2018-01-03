package com.spidev.android_arquitecture_component_demo.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.spidev.android_arquitecture_component_demo.model.User

/**
 * Created by carlos on 1/2/18.
 */
class UserViewModel : ViewModel() {

    private var liveData: MutableLiveData<List<User>> = MutableLiveData()
    private var usersList: MutableList<User> = mutableListOf()

    fun getUsers(): LiveData<List<User>> {
        usersList.add(User("Bill", "Flores"))
        liveData.value = usersList
        return liveData
    }

    fun addUser() {
        usersList.add(User("Carlonchito", "Vargas"))
        liveData.value = usersList
    }

    fun deleteUser() {
        usersList.removeAt(0)
        liveData.value = usersList
    }
}