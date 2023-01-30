package com.example.cvecaraprojekat.project.Activity.Activities;

import com.example.cvecaraprojekat.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class IntroActivity extends AppCompatActivity {
private ConstraintLayout startBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IntroActivity.this, MainActivity.class));
            }
        });

//        @SuppressLint("WrongViewCast") ConstraintLayout startBtn = findViewById(R.id.startBtn);
//        startBtn.setOnClickListener(view -> startActivity(new Intent( IntroActivity.this, MainActivity.class)));

    }






}