package com.example.mypetitefrench.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypetitefrench.R;
import com.example.mypetitefrench.local.Event;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddEvent extends Fragment {


    private EditText editTextTitle;
    private EditText editTextDescription;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.addevent_fragment, container, false);
        editTextTitle = root.findViewById(R.id.edit_text_event);
        editTextDescription = root.findViewById(R.id.edit_text_eventdescription);
        final AddViewModel addViewModel= new ViewModelProvider(this).get(AddViewModel.class);


        root.findViewById(R.id.button_save_event).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date current = Calendar.getInstance().getTime();
                String formated = DateFormat.getDateInstance(DateFormat.FULL).format(current);
                Event event=new Event(formated,editTextTitle.getText().toString(),editTextDescription.getText().toString());
                addViewModel.insert(event);
                NavHostFragment.findNavController(AddEvent.this)
                        .navigate(R.id.action_navigation_addevent_to_navigation_home);
            }
        });

        return root;
    }

}
