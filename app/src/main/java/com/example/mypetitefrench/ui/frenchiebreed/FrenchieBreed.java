package com.example.mypetitefrench.ui.frenchiebreed;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mypetitefrench.R;
import com.example.mypetitefrench.api.FrenchResponse;
import com.squareup.picasso.Picasso;

public class FrenchieBreed extends Fragment {

    private FrenchieBreedViewModel mViewModel;

    private ImageView img;

    public static FrenchieBreed newInstance() {
        return new FrenchieBreed();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root =inflater.inflate(R.layout.frenchie_breed_fragment, container, false);
        img=root.findViewById(R.id.image_random);

        mViewModel = new ViewModelProvider(this).get(FrenchieBreedViewModel.class);

        mViewModel.init();

        mViewModel.getRandomDog().observe(getViewLifecycleOwner(), new Observer<FrenchResponse>() {
            @Override
            public void onChanged(FrenchResponse frenchResponse) {
                Picasso.get().load(frenchResponse.getMessage()).into(img);
            }
        });
        mViewModel.updateDog();
        return root;
    }



}
