package com.example.learningrecyclerview.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.learningrecyclerview.R;

class FoodViewHolder extends RecyclerView.ViewHolder {
    private TextView tvName;
    private TextView tvFrom;
    private ImageView imgHero;
    private LinearLayout linearLayout;
    FoodViewHolder(@NonNull View itemView) {
        super(itemView);
        tvName = itemView.findViewById(R.id.tv_item_name);
        tvFrom = itemView.findViewById(R.id.tv_item_from);
        imgHero = itemView.findViewById(R.id.img_item_foto);
        linearLayout = itemView.findViewById(R.id.linear_row);
    }
    void fetchData(final Food food, final Context context){
        tvName.setText(food.getName());
        tvFrom.setText(food.getDesc());
        Glide.with(itemView.getContext()).load(food.getImg()).apply(new RequestOptions().override(55,55))
                .into(imgHero);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailActivity.class);
                intent.putExtra("name", food.getName());
                intent.putExtra("desc", food.getDesc());
                intent.putExtra("image", food.getImg());
                context.startActivity(intent);
            }
        });
    }
}
