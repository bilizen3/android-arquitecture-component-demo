package com.spidev.android_arquitecture_component_demo.repository.local;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;

import com.spidev.android_arquitecture_component_demo.repository.local.dao.PersonDao;
import com.spidev.android_arquitecture_component_demo.repository.local.dao.UserDao;
import com.spidev.android_arquitecture_component_demo.repository.local.entity.Person;
import com.spidev.android_arquitecture_component_demo.repository.local.entity.User;

/**
 * Created by Bill on 26/12/2017.
 */

@Database(entities = {Person.class, User.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract PersonDao PersonDao();
    public abstract UserDao userDao();

    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }
}
