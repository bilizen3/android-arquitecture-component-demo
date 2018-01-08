package com.spidev.android_arquitecture_component_demo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.spidev.android_arquitecture_component_demo.di.Injectable

class MainActivity : AppCompatActivity(), Injectable {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
