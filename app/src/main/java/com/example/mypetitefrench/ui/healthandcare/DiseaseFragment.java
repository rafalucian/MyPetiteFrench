package com.example.mypetitefrench.ui.healthandcare;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.mypetitefrench.MainActivity;
import com.example.mypetitefrench.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.sql.Struct;

public class DiseaseFragment extends Fragment {

    private TextView diseaseText;
    private TextView diseaseName;
    private ImageView diseaseImage;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.disease_item, container, false);
        FloatingActionButton button = root.findViewById(R.id.button_backtolist);
        //mViewModel = new ViewModelProvider(this).get(HealthCareViewModel.class);
        diseaseImage=root.findViewById(R.id.imageView_grid_disease);
        diseaseText=root.findViewById(R.id.disease_text);
        diseaseName=root.findViewById(R.id.text_grid_disease);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(DiseaseFragment.this)
                        .navigate(R.id.action_navigation_disease_to_navigation_healthcare);
            }
        });

        String name= MainActivity.diseases[HealthCare.INDEX];
        int img= MainActivity.diseasesIMG[HealthCare.INDEX];
        String text=MainActivity.diseasesTxt[HealthCare.INDEX];

        diseaseName.setText(name);
        diseaseText.setText(text);
        diseaseImage.setImageResource(img);

        return root;
    }
}
