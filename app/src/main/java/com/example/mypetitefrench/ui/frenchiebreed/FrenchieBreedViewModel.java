package com.example.mypetitefrench.ui.frenchiebreed;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mypetitefrench.Repository;
import com.example.mypetitefrench.api.FrenchResponse;


public class FrenchieBreedViewModel extends AndroidViewModel {

    private LiveData<FrenchResponse> randomDog;
    private Repository repository;

    public FrenchieBreedViewModel(Application application) {
        super(application);
        randomDog = new MutableLiveData<>();
        repository=repository.getInstance(application);
    }

    public LiveData<FrenchResponse> getRandomDog() {
        return randomDog;
    }

    public void updateDog() {
        repository.getRandomDogo();
    }

    public void init() {
        repository.getRandomDog();
        randomDog=repository.getRandomDog();
    }

}
