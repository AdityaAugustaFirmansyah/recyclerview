package com.example.learningrecyclerview.recyclerview;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.learningrecyclerview.R;

import java.util.ArrayList;

public class GridFoodAdapter extends RecyclerView.Adapter<GridFoodViewHolder> {
    private ArrayList<Food> foods;

    @NonNull
    @Override
    public GridFoodViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid_food,viewGroup,false);
        return new GridFoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GridFoodViewHolder gridFoodViewHolder, @SuppressLint("RecyclerView") final int i) {
        Glide.with(gridFoodViewHolder.itemView.getContext()).load(foods.get(i).getImg()).apply(new RequestOptions().override(350,550))
                .into(gridFoodViewHolder.imageView);

        gridFoodViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(gridFoodViewHolder.itemView.getContext(),DetailActivity.class);
                intent.putExtra("name", foods.get(i).getName());
                intent.putExtra("desc", foods.get(i).getDesc());
                intent.putExtra("image", foods.get(i).getImg());
                gridFoodViewHolder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }
}
