package com.example.learningrecyclerview.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.learningrecyclerview.R;

import java.util.ArrayList;

public class AdapterFood extends RecyclerView.Adapter<FoodViewHolder> {
    private ArrayList<Food> foods;
    void setListHero(ArrayList<Food> listFoods) {
        this.foods = listFoods;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_food,viewGroup,false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder foodViewHolder, int i) {
        foodViewHolder.fetchData(foods.get(i), foodViewHolder.itemView.getContext());
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }
}
