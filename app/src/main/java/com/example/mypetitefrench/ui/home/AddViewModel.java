package com.example.mypetitefrench.ui.home;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mypetitefrench.Repository;
import com.example.mypetitefrench.local.Event;

import java.util.List;

public class AddViewModel extends AndroidViewModel {


    private Repository repository;

    public AddViewModel(Application app) {
        super(app);
        repository = Repository.getInstance(app);
    }

    public void insert(Event e) {
        repository.insert(e);
    }

}
