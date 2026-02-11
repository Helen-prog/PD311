package com.example.intentapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ImageView image = findViewById(R.id.imageView3);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               ((AnimationDrawable)image.getDrawable()).start();

//                Animation out = AnimationUtils.loadAnimation(SecondActivity.this, R.anim.anim_alpha);
//                image.startAnimation(out);

                Animation translate = AnimationUtils.loadAnimation(SecondActivity.this, R.anim.anum_translate);
                image.startAnimation(translate);
            }
        });

        @SuppressLint("MissingInflatedId") ImageView imageView4 = findViewById(R.id.imageView4);
        @SuppressLint("MissingInflatedId") ImageView imageView5 = findViewById(R.id.imageView5);
        @SuppressLint("MissingInflatedId") Button button3 = findViewById(R.id.button3);
        @SuppressLint("MissingInflatedId") Button button4 = findViewById(R.id.button4);

        Animation center = AnimationUtils.loadAnimation(SecondActivity.this, R.anim.rotate_center);
        Animation corner = AnimationUtils.loadAnimation(SecondActivity.this, R.anim.rotate_corner);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView4.startAnimation(center);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView5.startAnimation(corner);
            }
        });

        Animation shrink = AnimationUtils.loadAnimation(this, R.anim.shrink);

        Button btn = findViewById(R.id.button2);
        btn.startAnimation(shrink);

    }

    public void goBack(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}