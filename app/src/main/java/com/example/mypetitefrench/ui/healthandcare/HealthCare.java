package com.example.mypetitefrench.ui.healthandcare;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mypetitefrench.R;
import com.example.mypetitefrench.adapters.HealthAdapter;
import com.example.mypetitefrench.ui.frenchiebreed.FrenchieBreedViewModel;


public class HealthCare extends Fragment implements HealthAdapter.OnListItemClickListener {
    private GridView gridView;
    private HealthCareViewModel mViewModel;
    public static int INDEX;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.health_care_fragment, container, false);
        mViewModel = new ViewModelProvider(this).get(HealthCareViewModel.class);
        gridView=root.findViewById(R.id.gridview);

        HealthAdapter customAdapter = new HealthAdapter(this);
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {

                INDEX=i;

                NavHostFragment.findNavController(HealthCare.this)
                        .navigate(R.id.action_navigation_healthcare_to_navigation_disease);

            }
        });


        return root;
    }


    @Override
    public void onListItemClick(int id) {

    }
}
