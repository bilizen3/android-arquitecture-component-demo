package com.spidev.android_arquitecture_component_demo.repository.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.spidev.android_arquitecture_component_demo.repository.local.entity.Person;

import java.util.List;

/**
 * Created by Bill on 27/12/2017.
 */
@Dao
public interface PersonDao {

    @Query("SELECT * FROM Person")
    List<Person> getAll();

    @Query("SELECT * FROM Person WHERE idPerson IN (:idPerson)")
    List<Person> loadAllByIds(int idPerson);

    @Insert
    void insertAll(Person... person);

    @Delete
    void delete(Person person);
}
