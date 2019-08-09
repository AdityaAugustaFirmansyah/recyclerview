package com.example.learningrecyclerview.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.learningrecyclerview.R;
import com.example.learningrecyclerview.profile.ProfileActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ArrayList<Food> dataFoods = FoodsData.getlisdata();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showRecyclerViewList();
    }

    private void showRecyclerViewList(){
        AdapterFood adapterFood = new AdapterFood();
        adapterFood.setListHero(dataFoods);
        RecyclerView recyclerView = findViewById(R.id.rv_hero);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterFood);
        recyclerView.setHasFixedSize(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menus,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }
    private void showRecyclerGrid(){
        GridFoodAdapter adapterHero = new GridFoodAdapter();
        adapterHero.setFoods(dataFoods);
        RecyclerView recyclerView = findViewById(R.id.rv_hero);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
        recyclerView.setAdapter(adapterHero);
        recyclerView.setHasFixedSize(true);
    }

    private void showRecyclerCard(){
        CardFoodAdapter adapterHero = new CardFoodAdapter();
        adapterHero.setFoods(dataFoods);
        RecyclerView recyclerView = findViewById(R.id.rv_hero);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(adapterHero);
        recyclerView.setHasFixedSize(true);
    }

    private void setMode(int itemId) {
        switch (itemId){
            case R.id.action_list:
                showRecyclerViewList();
                break;
            case R.id.action_grid:
                showRecyclerGrid();
                break;
            case R.id.action_card:
                showRecyclerCard();
                break;
            case R.id.action_about:
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
        }
    }
}
