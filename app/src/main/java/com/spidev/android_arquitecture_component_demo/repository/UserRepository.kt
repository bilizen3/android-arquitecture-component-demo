package com.spidev.android_arquitecture_component_demo.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.spidev.android_arquitecture_component_demo.repository.local.entity.User
import com.spidev.android_arquitecture_component_demo.repository.local.dao.UserDao
import com.spidev.android_arquitecture_component_demo.repository.remote.api.ApiResponse
import com.spidev.android_arquitecture_component_demo.repository.remote.api.WebServiceApi
import com.spidev.android_arquitecture_component_demo.repository.remote.model.UserResponse
import com.spidev.android_arquitecture_component_demo.vo.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by carlos on 1/7/18.
 */
@Singleton
class UserRepository @Inject constructor(val userDao: UserDao, val webServiceApi: WebServiceApi) {


    fun getUserFromDatabase(userId: Int): LiveData<User> {
        //refreshUser(userId)
        return userDao.load(userId)
    }

    /*@SuppressLint("StaticFieldLeak")
    private fun refreshUser(userId: Int) {
        object : AsyncTask<Void, Void, Void>() {
            override fun doInBackground(vararg params: Void?): Void {
                val userExists = userDao.hasUser(FRESH_TIMEOUT)
                if (!userExists) {
                    //refresh the data
                    val response = webService.getUser(userId).execute()
                    //TODO check for error etc.
                    // Update the database.The LiveData will automatically refresh so
                    // we don't need to do anything else here besides updating the database

                    val id = response.body()!!.id
                    val name = response.body()!!.name

                    val userEntity = User(id, name!!)
                    userDao.save(userEntity)
                }
            }
        })
    }*/


    fun getUser(userId: Int): LiveData<User> {
        val data = MutableLiveData<User>()
        webServiceApi.getUser(userId).enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful) {
                    val name = response.body()!!.name
                    val user = User(1, name!!)
                    data.value = user
                } else {
                    data.value = User(-1, "error")
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                data.value = User(-1, "failure")
            }
        })
        return data
    }

    fun loadUser(userId: Int): LiveData<Resource<User>> {
        return object : NetworkBoundResource<User, User>() {
            override fun saveCallResult(item: User) {
                //userDao.insert(item)
            }

            override fun shouldFetch(data: User?): Boolean {
                return false
            }

            override fun loadFromDb(): LiveData<User> {
                return userDao.load(userId)
            }

            override fun createCall(): LiveData<ApiResponse<User>> {
                return webServiceApi.getUser2(userId)
            }

        }.asLiveData
    }
}

