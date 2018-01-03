package com.spidev.android_arquitecture_component_demo.repository.model;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;

import com.spidev.android_arquitecture_component_demo.repository.model.dao.PersonDao;
import com.spidev.android_arquitecture_component_demo.repository.model.entity.Person;

/**
 * Created by Bill on 26/12/2017.
 */

@Database(entities = {Person.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PersonDao PersonDao();
}
