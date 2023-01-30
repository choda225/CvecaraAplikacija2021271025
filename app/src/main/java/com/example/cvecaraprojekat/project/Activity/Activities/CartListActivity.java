package com.example.cvecaraprojekat.project.Activity.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.cvecaraprojekat.R;
import com.example.cvecaraprojekat.project.Activity.Adaptor.CartListaAda;
import com.example.cvecaraprojekat.project.Activity.Helper.ManagmentCart;
import com.example.cvecaraprojekat.project.Activity.Interface.ChangeNumberListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CartListActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private ManagmentCart managmentCart;


    TextView ukupnoTxt,uslugaTxt,taxTxt,svetxt,praznaTxt;
    private ScrollView scrollView;
    private  double tax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);

        managmentCart = new ManagmentCart(this);
        initView();
        initList();
        CalculateCart();
        bottomNavigation();
    }

    private void bottomNavigation(){
        FloatingActionButton floatingActionButton=findViewById(R.id.cartBtn);
        LinearLayout homeBtn=findViewById(R.id.homeBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartListActivity.this,CartListActivity.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartListActivity.this, MainActivity.class));
            }
        });
    }

    private void initView() {
        recyclerViewList = findViewById(R.id.recyclerView);
        ukupnoTxt=findViewById(R.id.ukupnoTxt);
        uslugaTxt=findViewById(R.id.uslugaTxt);
        taxTxt=findViewById(R.id.taxxTxt);
        svetxt=findViewById(R.id.svetxt);
        praznaTxt=findViewById(R.id.praznaTxt);
        scrollView=findViewById(R.id.viewScroll);
        recyclerViewList=findViewById(R.id.cartView);
    }

    private void initList(){
        LinearLayoutManager llm=new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewList.setLayoutManager(llm);
        adapter=new CartListaAda(managmentCart.getListCart(), this, new ChangeNumberListener() {
            @Override
            public void changed() {
            CalculateCart();
            }
        });

        recyclerViewList.setAdapter(adapter);
        if (managmentCart.getListCart().isEmpty()){
            praznaTxt.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        }else{
            praznaTxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }

    }
    private void CalculateCart(){
        double percentTax=0.03;
        double dostava=10;

        tax=Math.round((managmentCart.getTotalFree() * percentTax)* 100 )/100;
        double total=Math.round((managmentCart.getTotalFree()+ tax + dostava) * 100) / 100;
        double itemTotal=Math.round(managmentCart.getTotalFree()* 100)/ 100;


        ukupnoTxt.setText(itemTotal + "RSD");
        taxTxt.setText(tax + "RSD");
        uslugaTxt.setText(dostava + "RSD");
        svetxt.setText(total + "RSD");

    }

}