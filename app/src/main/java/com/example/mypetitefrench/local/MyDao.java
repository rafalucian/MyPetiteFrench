package com.example.mypetitefrench.local;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MyDao {

    @Insert
    void insert(Event event);

    @Delete
    void delete(Event event);

    @Query("Delete from event_table")
    void deleteAllEvents();

    @Query("Select * from event_table Order By id asc")
    LiveData<List<Event>> getAllEvents();

}
