package com.spidev.android_arquitecture_component_demo.repository.local.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Bill on 26/12/2017.
 */
@Entity
public class Person {
    @PrimaryKey
    public int idPerson;

    @ColumnInfo(name = "full_name")
    public String fullName;

    @ColumnInfo(name = "dni")
    public int dni;

    @ColumnInfo(name = "address")
    public String address;

}
