package com.spidev.android_arquitecture_component_demo.di

import com.spidev.android_arquitecture_component_demo.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by carlos on 1/7/18.
 */

@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}