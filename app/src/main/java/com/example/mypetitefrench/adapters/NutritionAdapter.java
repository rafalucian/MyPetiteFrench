package com.example.mypetitefrench.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypetitefrench.R;
import com.example.mypetitefrench.ui.nutrition.Nutrition;

import java.util.List;

public class NutritionAdapter extends RecyclerView.Adapter<NutritionAdapter.ViewHolder> {
    final private OnListItemClickListener mOnListItemClickListener;
    List<Nutrition> nutritionItemsList;

    public NutritionAdapter(List<Nutrition> nutritionItemsList, OnListItemClickListener listener) {
        this.nutritionItemsList = nutritionItemsList;
        mOnListItemClickListener = listener;
    }

    @NonNull
    @Override
    public NutritionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.foodtype, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NutritionAdapter.ViewHolder holder, int position) {
        holder.foodtypedescription.setText(nutritionItemsList.get(position).getDescription());
        holder.foodtypeimage.setImageResource(nutritionItemsList.get(position).getmIconId());
    }

    @Override
    public int getItemCount() {
        return nutritionItemsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView foodtypeimage;
        TextView foodtypedescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            foodtypedescription = itemView.findViewById(R.id.foodtypedescription);
            foodtypeimage = itemView.findViewById(R.id.foodtypeimage);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mOnListItemClickListener.onListItemClick(getAdapterPosition());
        }
    }

    public interface OnListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

}


