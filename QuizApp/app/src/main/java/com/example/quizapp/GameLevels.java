package com.example.quizapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameLevels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_level);

        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
        final int level = save.getInt("Level", 1);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button buttonBack = findViewById(R.id.button_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameLevels.this, MainActivity.class);
                startActivity(intent);
            }
        });

//        TextView textView1 = findViewById(R.id.textView1);
//        textView1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(GameLevels.this, Level1.class);
//                startActivity(intent);
//            }
//        });
//
//        TextView textView2 = findViewById(R.id.textView2);
//        textView2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(GameLevels.this, Level2.class);
//                startActivity(intent);
//            }
//        });

        for (int i = 0; i < 15; i++) {
            int resId=getResources().getIdentifier("textView"+(i+1),"id",getPackageName());
            if (resId != 0) {
                TextView tmp = findViewById(resId);
                if (tmp != null) {
                    final int  index=i;
                    tmp.setOnClickListener(v-> {
                        try {
                            Class<?> cls = Class.forName("com.example.quizapp.Level"+(index+1));
                            if(level >= index + 1) {
                                Intent intent = new Intent(GameLevels.this, cls);
                                startActivity(intent);
                            }
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                            Log.e("DynamicStart", "Класс " + "Level" +(index+1)+ " не найден");
                        }
                    });
                    //levels.add(tmp);
                }
                else {
                    Log.e("Level", "TextView с id selectLevel" + (i+1) + " не найден");
                }
            } else {
                Log.e("Level", "ResID для selectLevel" + (i+1) + " не найден");
            }
        }

        final int[] x = {
                R.id.textView1,
                R.id.textView2,
                R.id.textView3,
                R.id.textView4
        };

        for (int i = 0; i < level; i++) {
            TextView tv = findViewById(x[i]);
            tv.setText("" + (i + 1));
        }
    }
}