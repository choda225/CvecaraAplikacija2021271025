package com.example.cvecaraprojekat.project.Activity.Activities;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.cvecaraprojekat.R;
import com.example.cvecaraprojekat.project.Activity.Adaptor.CategoryAdaptor;
import com.example.cvecaraprojekat.project.Activity.Adaptor.PopularAdaptor;
import com.example.cvecaraprojekat.project.Activity.Domain.CategoryDomain;
import com.example.cvecaraprojekat.project.Activity.Domain.FlowerDomain;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewCategoryList,recyclerViewPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        recyclerViewPopular();
        bottomNavigation();
    }
    private void bottomNavigation(){
        FloatingActionButton floatingActionButton=findViewById(R.id.cartBtn);
        LinearLayout homeBtn=findViewById(R.id.homeBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CartListActivity.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });
    }
    private void recyclerViewCategory(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList=findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> category=new ArrayList<>();
        category.add(new CategoryDomain("Ruze","cvet1"));
        category.add(new CategoryDomain("Hrizanteme","cvet2"));
        category.add(new CategoryDomain("Orhideje","cvet3"));
        category.add(new CategoryDomain("Lale","cvet4"));
        category.add(new CategoryDomain("Ljiljani","cvet5"));
        adapter=new CategoryAdaptor(category);
        recyclerViewCategoryList.setAdapter(adapter);



    }
    private  void recyclerViewPopular(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList=findViewById(R.id.recyclerView2);

        ArrayList<FlowerDomain> flowerList=new ArrayList<>();
        flowerList.add(new FlowerDomain("Buket ruža", "cvet1", "Buket ruža upakovan ukrasnim papirom i dodatak grančicama", 749.89,1));
        flowerList.add(new FlowerDomain("Buket hrizantema", "cvet2", "Buket hrizantema upakovan ukrasnim papirom", 730.99,1));
        flowerList.add(new FlowerDomain("Buket orhideja", "cvet3", "Buket orhideja upakovan ukrasnim papirom", 1050.59,1));
        flowerList.add(new FlowerDomain("Buket lala", "cvet4", "Buket lala upakovan ukrasnim papirom", 570.60,1));
        flowerList.add(new FlowerDomain("Buket ljiljana", "cvet5", "Buket ljiljana upakovan ukrasnim papirom", 430.34,1));

        adapter=new PopularAdaptor(flowerList);
        recyclerViewPopularList.setAdapter(adapter);

    }
}