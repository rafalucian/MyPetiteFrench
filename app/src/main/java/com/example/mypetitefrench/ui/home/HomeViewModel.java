package com.example.mypetitefrench.ui.home;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mypetitefrench.Repository;
import com.example.mypetitefrench.local.Event;

import java.util.List;

public class HomeViewModel extends AndroidViewModel {


    private LiveData<List<Event>> mEvents;
    private Repository repository;

    public HomeViewModel(Application app) {
        super(app);
        repository = Repository.getInstance(app);
    }

    public void init(){
        mEvents=repository.getEvents();
    }

    public LiveData<List<Event>> getmEvents() {
        return mEvents;
    }

    public void insert(Event e) {
        repository.insert(e);
    }

    public void delete(Event e){
        repository.delete(e);
    }

    public void deleteAll(){
        repository.deleteAllEvents();
    }
}
