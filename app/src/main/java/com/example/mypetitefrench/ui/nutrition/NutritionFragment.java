package com.example.mypetitefrench.ui.nutrition;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mypetitefrench.R;
import com.example.mypetitefrench.adapters.NutritionAdapter;
import com.example.mypetitefrench.ui.healthandcare.HealthCareViewModel;

import java.util.ArrayList;

public class NutritionFragment extends Fragment implements NutritionAdapter.OnListItemClickListener {
    RecyclerView recyclerView;

    private HealthCareViewModel mViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                         @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    View root=inflater.inflate(R.layout.nutrition_fragment, container, false);

        recyclerView=root.findViewById(R.id.nutrition_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.hasFixedSize();

        ArrayList<Nutrition> nutrition = new ArrayList<>();
        nutrition.add(new Nutrition("Acana Senior - Senior dogs are best fed a diet rich in meat proteins to support lean muscle mass, yet limited in carbohydrates which can lead to obesity and diabetes. \n" +
                "ACANA Senior features higher protein levels from richly nourishing free-run chicken, nest-laid eggs and whole wild-caught flounder that are delivered to our kitchens fresh from our region so they’re loaded with goodness and taste.\n" +
                "To help support healthy blood sugar levels, ACANA Senior replaces fast carbohydrates like tapioca or potato with low-glycemic fruits and vegetables such as pumpkin and squash.\n",R.drawable.p1));
        nutrition.add(new Nutrition("Acana Puppy Small Breed - To support their rapid physical development, small breed puppies benefit from a diet rich in proteins and fats from a diversity of fresh whole meats.\n" +
                "That’s why ACANA Puppy Small Breed is loaded with free-run chicken, wild-caught flounder and whole nest-laid eggs, delivered FRESH in WholePrey™ ratios, so they’re brimming with goodness and taste.\n" +
                "Free of grains and fast carbohydrates such as rice, tapioca or potato, ACANA is rich in meat proteins to promote your puppy’s peak development and conditioning.\n", R.drawable.p2));
        nutrition.add(new Nutrition("Acana adult small breed -  Mother Nature evolved dogs as carnivores, biologically adapted for a diet rich and varied in meats with smaller amounts of fruits and vegetables.\n" +
                "That’s why ACANA Adult Small Breed is loaded with free-run chicken, wild-caught flounder and whole nest-laid eggs, delivered FRESH in WholePrey™ ratios, so they’re brimming with goodness and taste.\n" +
                "Free of grains and fast carbohydrates such as rice, tapioca or potato, ACANA is rich in meat proteins to promote your dog’s peak health and conditioning.\n", R.drawable.p3));
        nutrition.add(new Nutrition("Acana Light & Fit -Overweight dogs benefit from a diet rich in protein to promote lean muscle mass, yet limited in carbohydrates that can contribute to excess body fat.\n" +
                "That’s why ACANA Light & Fit is brimming with meat, including free-run chicken, nest-laid eggs and wild-caught flounder delivered fresh from our region for unequaled goodness and taste.\n" +
                "To promote healthy blood sugar levels, ACANA is free of high glycemic ingredients like rice, corn or potato, and instead features fresh low-glycemic fruits and vegetables including whole pumpkin and squash.\n",R.drawable.p4));
        nutrition.add(new Nutrition("Acana Puppy Junior Heritage -By nature, all puppies are carnivores which means they’re biologically adapted for a diet rich and varied in fresh whole meats with smaller amounts of fruits and vegetables.\n" +
                "That’s why ACANA Puppy & Junior is brimming with free-run chicken and nest-laid eggs from local prairie farms, and wild-caught flounder from North Vancouver Island, delivered fresh to nourish peak health.\n" +
                "Free of grains and fast carbohydrates such as rice, tapioca or potato, ACANA is rich in meat proteins to promote your puppy’s peak development and conditioning.\n", R.drawable.p5));
        nutrition.add(new Nutrition("Acana Grass feed lamb- Inspired by our vast grasslands and northern lakes, ACANA Grasslands features fresh lamb, free-run duck, whole nest-laid eggs, wild-caught northern pike, and free-run turkey from western Canada.\n" +
                "Brimming with fresh regional ingredients that are delivered FRESH or RAW daily in WholePrey™ ratios that mirror your dog’s evolutionary diet, ACANA Grasslands nourishes your dog naturally and completely.\n" +
                "Trusted everywhere, carbohydrate-limited and protein-rich ACANA promotes peak physical conditioning in dogs of all breeds and life stages.\n", R.drawable.p6));
        nutrition.add(new Nutrition("Classic Red - Modern dogs are not only capable of eating the foods of their ancestors, they actually require it for peak health.\n" +
                "Brimming with richly nourishing meats, ACANA Classic Red features local ranch-raised Angus beef, Yorkshire pork and grass-fed lamb that are delivered FRESH or RAW daily in WholePrey™ ratios to nourish your dog completely.\n" +
                "Free of high-glycaemic carbohydrates, ACANA Classics feature low-glycaemic and locally grown steel-cut oats that helps to support stable blood sugar and peak physical conditioning.\n", R.drawable.p7));
        nutrition.add(new Nutrition("Acana Wild Coast - Loaded with nourishing protein and omega-3 fatty acids ACANA Wild Coast features sustainable fish, wild-caught off North Vancouver Island’s cold Pacific waters and whisked to our kitchen FRESH and WHOLE, so they’re bursting with goodness and taste.\n" +
                "Free of high-glycaemic carbohydrates, ACANA Classics feature low-glycaemic and locally grown steel-cut oats that helps to support stable blood sugar and peak physical conditioning.\n", R.drawable.p8));

        NutritionAdapter adapter = new NutritionAdapter(nutrition,this);
        recyclerView.setAdapter(adapter);



        return root;
    }

    private void setContentView(int nutrition_fragment) {
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {

    }
}

