package com.example.mypetitefrench.ui.home;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.speech.RecognizerIntent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mypetitefrench.R;
import com.example.mypetitefrench.adapters.JournalAdapter;
import com.example.mypetitefrench.local.Event;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel mViewModel;
    private FloatingActionButton button;
    private FloatingActionButton delete;
    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
       View root = inflater.inflate(R.layout.home_fragment, container, false);
        RecyclerView recyclerView=root.findViewById(R.id.recycle_events);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        button=root.findViewById(R.id.button_add_event);
        delete=root.findViewById(R.id.delete_all);
        final JournalAdapter adapter=new JournalAdapter();
        recyclerView.setAdapter(adapter);
        mViewModel=new ViewModelProvider(getActivity()).get(HomeViewModel.class);
        mViewModel.init();
        mViewModel.getmEvents().observe(getViewLifecycleOwner(), new Observer<List<Event>>()
        {
            @Override
                    public void onChanged(@Nullable List<Event> events)
            {
                adapter.setEvents(events);
                adapter.notifyDataSetChanged();
            }

        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.deleteAll();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(HomeFragment.this)
                        .navigate(R.id.action_navigation_home_to_navigation_addevent);
            }
        });

       return root;

    }



}
