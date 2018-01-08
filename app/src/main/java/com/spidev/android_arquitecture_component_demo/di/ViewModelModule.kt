package com.spidev.android_arquitecture_component_demo.di

import android.arch.lifecycle.ViewModel
import com.spidev.android_arquitecture_component_demo.viewmodel.UserProfileViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by carlos on 1/7/18.
 */

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(UserProfileViewModel::class)
    abstract fun bindUserViewModel(userProfileViewModel: UserProfileViewModel): ViewModel
}