package com.example.learningrecyclerview.recyclerview;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.learningrecyclerview.R;

import java.util.ArrayList;

public class CardFoodAdapter extends RecyclerView.Adapter<CardFoodHolder> {
    private ArrayList<Food> foods;
    @NonNull
    @Override
    public CardFoodHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_food,viewGroup,false);
        return new CardFoodHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardFoodHolder cardFoodHolder, @SuppressLint("RecyclerView") final int i) {
        cardFoodHolder.textViewName.setText(foods.get(i).getName());
        cardFoodHolder.textViewDesc.setText(foods.get(i).getDesc());
        Glide.with(cardFoodHolder.itemView.getContext()).load(foods.get(i).getImg()).apply(new RequestOptions().override(350,550))
                .into(cardFoodHolder.imageView);

        cardFoodHolder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(cardFoodHolder.itemView.getContext(),"anda menklik share",Toast.LENGTH_SHORT).show();
            }
        });

        cardFoodHolder.btnFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(cardFoodHolder.itemView.getContext(),"anda menklik favorite",Toast.LENGTH_SHORT).show();
            }
        });

        cardFoodHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cardFoodHolder.itemView.getContext(),DetailActivity.class);
                intent.putExtra("name", foods.get(i).getName());
                intent.putExtra("desc", foods.get(i).getDesc());
                intent.putExtra("image", foods.get(i).getImg());
                cardFoodHolder.itemView.getContext().startActivity(intent);
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