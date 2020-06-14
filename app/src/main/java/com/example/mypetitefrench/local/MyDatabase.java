package com.example.mypetitefrench.local;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Event.class, version = 2, exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {

    private static MyDatabase instance;

    public abstract MyDao myDao();

    public static synchronized MyDatabase getInstance(Context context) {
        if (instance == null) instance = Room.databaseBuilder(context.getApplicationContext(),
                MyDatabase.class, "event_database")
                .fallbackToDestructiveMigration().build();
        return instance;
    }

}
