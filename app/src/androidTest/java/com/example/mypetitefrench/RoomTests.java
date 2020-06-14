package com.example.mypetitefrench;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.mypetitefrench.local.Event;
import com.example.mypetitefrench.local.MyDao;
import com.example.mypetitefrench.local.MyDatabase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class RoomTests {
    private MyDao dao;
    private MyDatabase db;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, MyDatabase.class).build();
        dao = db.myDao();
    }

    @Test
    public void insert() throws Exception{
        Event event= new Event("Today","Vaccine","Some problem with the stomach");
        db.myDao().insert(event);
        LiveData<List<Event>> byName = dao.getAllEvents();
        assertEquals(byName.getValue().get(0).getEvent(), event.getEvent());
    }

    @Test
    public void insert2() throws Exception{
        Event event= new Event("Today","Vaccine","Some problem with the stomach");
        Event event1= new Event("Today","Vaccine","Some problem with the stomach");
        List<Event> events=new ArrayList<>();
        events.add(event);
        events.add(event1);
        db.myDao().insert(event);
        db.myDao().insert(event1);
        LiveData<List<Event>> byName = dao.getAllEvents();
        assertThat(byName.getValue(), equalTo(events));
    }

    @Test
    public void delete() throws Exception{
        Event event= new Event("Today","Vaccine","Some problem with the stomach");
        Event event1= new Event("Today","Vaccine","Some problem with the stomach");
        List<Event> favs=new ArrayList<>();
        List<Event> events=new ArrayList<>();
        events.add(event);
        events.add(event1);
        db.myDao().insert(event);
        db.myDao().insert(event1);
        dao.deleteAllEvents();
        LiveData<List<Event>> byName = dao.getAllEvents();
        assertNull(byName.getValue().get(0));
    }


    @After
    void close(){
        db.close();
    }


}