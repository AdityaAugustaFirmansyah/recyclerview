package com.example.learningrecyclerview.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.learningrecyclerview.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.img_detail);
        TextView textViewNameDetail = findViewById(R.id.txt_name_detail);
        TextView textViewDescDetail = findViewById(R.id.txt_detail_desc);

        Glide.with(this).load(getIntent().getStringExtra("image")).into(imageView);
        textViewNameDetail.setText(getIntent().getStringExtra("name"));
        textViewDescDetail.setText(getIntent().getStringExtra("desc"));
    }
}
