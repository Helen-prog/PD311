package com.example.intentapplication;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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

                Animation out = AnimationUtils.loadAnimation(SecondActivity.this, R.anim.anim_alpha);
                image.startAnimation(out);
            }
        });
    }

    public void goBack(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}