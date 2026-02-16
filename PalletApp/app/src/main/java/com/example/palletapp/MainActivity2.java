package com.example.palletapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button calculateButton = findViewById(R.id.calculate_button);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText costService = findViewById(R.id.cost_of_service);
                String keywords = costService.getText().toString();
                int cost = Integer.parseInt(keywords);

                double tip = 0;

                RadioGroup tipOptions = findViewById(R.id.tip_options);
                int selectedId = tipOptions.getCheckedRadioButtonId();

                if(selectedId == R.id.option_ten_percent){
                    tip = cost * 0.1;
                } else if (selectedId == R.id.options_seven_percent) {
                    tip = cost * 0.07;
                } else if (selectedId == R.id.options_five_percent) {
                    tip = cost * 0.05;
                }

                SwitchMaterial roundSwitch = findViewById(R.id.round_switch);
                boolean round = roundSwitch.isChecked();
                if(round){
                    tip = Math.ceil(tip);
                }

                TextView tipResult = findViewById(R.id.tip_result);
//                String result = String.valueOf(tip);
//                tipResult.setText(result);

//                Locale usLocale = new Locale("en", "US");
                Locale usLocale = new Locale("ru", "RU");
                NumberFormat usCurrentFormat = NumberFormat.getCurrencyInstance(usLocale);
                String currencyTip = usCurrentFormat.format(tip);
//                tipResult.setText(currencyTip);
                String text = "Оставь на чай: " + currencyTip;
                tipResult.setText(text);
            }
        });

    }
}