package com.example.mypetitefrench.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mypetitefrench.R;

import java.util.ArrayList;

public class HealthAdapter extends BaseAdapter {

    private OnListItemClickListener listener;

    public HealthAdapter(OnListItemClickListener listener) {
        this.listener = listener;
    }

    String[] fruitNames = {"Hip Dysplasia", "Brachycephalic Syndrome", "Allergies", "Hemivertebrae", "Patellar Luxation", "Intervertebral Disc Disease",};
    int[] fruitImages = {R.drawable.b1, R.drawable.b2, R.drawable.b3, R.drawable.b4, R.drawable.b5, R.drawable.b6};


    @Override
    public int getCount() {
        return fruitImages.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_item, viewGroup, false);
        //getting view in row_data
        TextView name = view1.findViewById(R.id.grid_name);
        ImageView image = view1.findViewById(R.id.grid_image);

        name.setText(fruitNames[i]);
        image.setImageResource(fruitImages[i]);
        return view1;

    }


    public interface OnListItemClickListener {
        void onListItemClick(int id);
    }

}
