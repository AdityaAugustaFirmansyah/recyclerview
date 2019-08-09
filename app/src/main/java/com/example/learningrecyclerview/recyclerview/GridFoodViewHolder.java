package com.example.learningrecyclerview.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.learningrecyclerview.R;

class GridFoodViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    GridFoodViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView= itemView.findViewById(R.id.img_item_foto);
    }
}
