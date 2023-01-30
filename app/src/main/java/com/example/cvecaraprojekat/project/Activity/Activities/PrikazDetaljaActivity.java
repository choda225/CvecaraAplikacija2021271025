package com.example.cvecaraprojekat.project.Activity.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.cvecaraprojekat.R;
import com.example.cvecaraprojekat.project.Activity.Domain.FlowerDomain;
import com.example.cvecaraprojekat.project.Activity.Helper.ManagmentCart;

public class PrikazDetaljaActivity extends AppCompatActivity {
    private TextView Titletxt, feeTxt, opisTxt, numberOrderTxt;
    private TextView dodajUKorpuBtn;
    private ImageView plusBtn,minusBtn,PicBtn;
    
    private FlowerDomain object;
    int numberOrder = 1;
    private ManagmentCart managmentCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prikaz_detalja);
        
        managmentCart=new ManagmentCart(this);
        initView();
        getBundle();
    }

    private void getBundle() {
        object=(FlowerDomain) getIntent().getSerializableExtra("object");

        int drawableResourceId=this.getResources().getIdentifier(object.getPic(), "drawable", this.getPackageName());
        Glide.with(this)
                .load(drawableResourceId)
                .into(PicBtn);
        Titletxt.setText(object.getTitle());
        feeTxt.setText(object.getFee()+"RSD");
        opisTxt.setText(object.getDescription());
        numberOrderTxt.setText(String.valueOf(numberOrder));

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOrder= numberOrder+1;
                numberOrderTxt.setText(String.valueOf(numberOrder));
            }
        });


        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numberOrder > 1){
                    numberOrder = numberOrder -1;
                }
                numberOrderTxt.setText(String.valueOf(numberOrder));
            }
        });

        dodajUKorpuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                object.setNumberInCart(numberOrder);
                managmentCart.insertFlower(object);
            }
        });

    }


    private void initView() {
        dodajUKorpuBtn=findViewById(R.id.dodajUKorpuBtn);
        Titletxt=findViewById(R.id.Titletxt);
        feeTxt=findViewById(R.id.priceTxt);
        opisTxt=findViewById(R.id.opisTxt);
        numberOrderTxt=findViewById(R.id.numberOrderTxt);
        plusBtn=findViewById(R.id.plusBtn);
        minusBtn=findViewById(R.id.minusBtn);
        PicBtn=findViewById(R.id.picBtn);
    }
}