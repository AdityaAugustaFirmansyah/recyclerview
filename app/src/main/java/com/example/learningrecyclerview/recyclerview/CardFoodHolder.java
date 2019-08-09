package com.example.learningrecyclerview.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.learningrecyclerview.R;

class CardFoodHolder extends RecyclerView.ViewHolder {
    TextView textViewName;
    TextView textViewDesc;
    ImageView imageView;
    Button btnShare;
    Button btnFav;
    CardView linearLayout;
    CardFoodHolder(@NonNull View itemView) {
        super(itemView);
        textViewDesc = itemView.findViewById(R.id.tv_item_desc);
        textViewName = itemView.findViewById(R.id.txt_item_name);
        imageView = itemView.findViewById(R.id.img_item_foto);
        btnFav = itemView.findViewById(R.id.set_favorite);
        btnShare = itemView.findViewById(R.id.set_share);
        linearLayout = itemView.findViewById(R.id.linear_card);
    }
}
