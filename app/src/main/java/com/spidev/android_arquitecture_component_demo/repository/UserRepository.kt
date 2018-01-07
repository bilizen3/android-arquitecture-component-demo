package com.spidev.android_arquitecture_component_demo.repository

import android.annotation.SuppressLint
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.os.AsyncTask
import com.spidev.android_arquitecture_component_demo.model.UserData
import com.spidev.android_arquitecture_component_demo.repository.local.dao.UserDao
import com.spidev.android_arquitecture_component_demo.repository.local.entity.UserEntity
import com.spidev.android_arquitecture_component_demo.repository.remote.api.WebServiceApi
import com.spidev.android_arquitecture_component_demo.repository.remote.api.WebServiceApiManager
import com.spidev.android_arquitecture_component_demo.repository.remote.model.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Executor


/**
 * Created by carlos on 1/7/18.
 */
class UserRepository {

    private var webService: WebServiceApi = WebServiceApiManager.apiManager()
    private val userDao: UserDao

    init {
        this.userDao =
    }

    fun getUserFromDatabase(userId: Int): LiveData<UserEntity> {

        userDao.load(userId)
    }

    private fun refreshUser(userId: Int) {
        object : AsyncTask<Void, Void, Void>() {
            override fun doInBackground(vararg params: Void?): Void {
                val userExists = userDao.hasUser(FRESH_TIMEOUT)
                if(!userExists){
                    //refresh the data
                    val response = webService.getUser(userId).execute()
                    //TODO check for error etc.
                    // Update the database.The LiveData will automatically refresh so
                    // we don't need to do anything else here besides updating the database

                    val id = response.body()
                    val name = response.body()
                    val lastName = response.body()

                    val userEntity = UserEntity()
                    userDao.save(response.body())
                }
            }
        })
    }


    fun getUser(userId: Int): LiveData<UserData> {
        val data = MutableLiveData<UserData>()
        webService.getUser(userId).enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful) {
                    val name = response.body()!!.name
                    val user = UserData("Successful", name!!)
                    data.value = user
                } else {
                    data.value = UserData("Error!", "Empty Name")
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                data.value = UserData(t.message!!, "Empty Name")
            }
        })
        return data
    }
}

