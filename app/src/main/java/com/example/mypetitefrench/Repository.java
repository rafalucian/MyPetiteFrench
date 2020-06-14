package com.example.mypetitefrench;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mypetitefrench.api.Api;
import com.example.mypetitefrench.api.FrenchResponse;
import com.example.mypetitefrench.api.ServiceGenerator;
import com.example.mypetitefrench.local.Event;
import com.example.mypetitefrench.local.MyDao;
import com.example.mypetitefrench.local.MyDatabase;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    private MyDao myDao;
    private LiveData<List<Event>> events;
    private MutableLiveData<FrenchResponse> randomDog;
    private static Repository instance;

    public Repository(Application app) {
        MyDatabase myDatabase = MyDatabase.getInstance(app);
        myDao = myDatabase.myDao();
        events = myDao.getAllEvents();
        randomDog = new MutableLiveData<>();
    }

    public static synchronized Repository getInstance(Application app) {
        if (instance == null) {
            instance = new Repository(app);
        }
        return instance;
    }


    public LiveData<FrenchResponse> getRandomDog() {
        return randomDog;
    }

    public void getRandomDogo() {
        Api api = ServiceGenerator.getApi();
        Call<FrenchResponse> call = api.getFrenchRandom();

        call.enqueue(new Callback<FrenchResponse>() {
            @Override
            public void onResponse(Call<FrenchResponse> call, Response<FrenchResponse> response) {
                if (response.code() == 200) {
                    randomDog.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<FrenchResponse> call, Throwable t) {
                Log.i("API", "Something went wrong :(");
            }
        });

    }

    public LiveData<List<Event>> getEvents() {
        return events;
    }


    public void insert(Event event) {
        new InsertEventAsyncTask(myDao).execute(event);
    }

    public void delete(Event event) {
        new DeleteEventAsyncTask(myDao).execute(event);
    }

    public void deleteAllEvents() {
        new DeleteAllEventsAsync(myDao).execute();
    }


    private static class InsertEventAsyncTask extends AsyncTask<Event, Void, Void> {

        private MyDao myDao;

        private InsertEventAsyncTask(MyDao myDao) {
            this.myDao = myDao;
        }

        @Override
        protected Void doInBackground(Event... events) {
            myDao.insert(events[0]);
            return null;
        }
    }

    private static class DeleteEventAsyncTask extends AsyncTask<Event, Void, Void> {

        private MyDao myDao;

        private DeleteEventAsyncTask(MyDao myDao) {
            this.myDao = myDao;
        }

        @Override
        protected Void doInBackground(Event... events) {
            myDao.delete(events[0]);
            return null;
        }
    }

    private static class DeleteAllEventsAsync extends AsyncTask<Void, Void, Void> {

        private MyDao myDao;

        private DeleteAllEventsAsync(MyDao myDao) {
            this.myDao = myDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            myDao.deleteAllEvents();
            return null;
        }
    }


}
