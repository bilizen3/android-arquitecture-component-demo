package com.spidev.android_arquitecture_component_demo.repository.local.entity

import android.arch.persistence.room.PrimaryKey

/**
 * Created by carlos on 1/7/18.
 */
data class UserEntity(@PrimaryKey val id: Int, val name: String, val lastName: String)