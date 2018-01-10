package com.spidev.android_arquitecture_component_demo.repository.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Bill on 26/12/2017.
 */
@Entity(tableName = "Person")
public class Person {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "IdPerson")
    public int idPerson;

    @ColumnInfo(name = "FullName")
    public String fullName;


    @ColumnInfo(name = "Dni")
    public int dni;

    @ColumnInfo(name = "Address")
    public String address;


    public Person(String fullName, int dni, String address) {
        this.fullName = fullName;
        this.dni = dni;
        this.address = address;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
