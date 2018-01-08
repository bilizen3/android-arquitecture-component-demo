package com.spidev.android_arquitecture_component_demo.di

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by carlos on 1/7/18.
 */

@Module(includes = arrayOf(ViewModelModule::class, NetModule::class, RoomModule::class))
class AppModule() {


}