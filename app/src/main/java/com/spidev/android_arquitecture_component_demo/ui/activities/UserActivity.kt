package com.spidev.android_arquitecture_component_demo.ui.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.spidev.android_arquitecture_component_demo.R
import com.spidev.android_arquitecture_component_demo.model.User
import com.spidev.android_arquitecture_component_demo.viewmodel.UserViewModel

import kotlinx.android.synthetic.main.activity_user.*
import kotlinx.android.synthetic.main.content_user.*

class UserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val viewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)

        viewModel.getUsers().observe(this, Observer<List<User>> { userList ->
            Toast.makeText(this, "tamaño " + userList!!.size, Toast.LENGTH_SHORT).show()
        })

        btnAddUser.setOnClickListener { _ ->
            viewModel.addUser()
        }

        btnDeleteUser.setOnClickListener { _ ->
            viewModel.updateUser()
           // viewModel.deleteUser()
        }
    }
}
