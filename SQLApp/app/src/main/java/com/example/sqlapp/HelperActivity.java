package com.example.sqlapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.LinkedList;

public class HelperActivity extends AppCompatActivity {

    DataBaseHelper dbHelper;
    TextView tvOut;
    EditText eName, eSurname, eYear;
    Button btnDel, btnAdd, btnGet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper);

        dbHelper = new DataBaseHelper(this);
        tvOut = findViewById(R.id.tvOut);

        eName = findViewById(R.id.editName);
        eSurname = findViewById(R.id.editSurname);
        eYear = findViewById(R.id.editYear);

        btnAdd = findViewById(R.id.buttonAdd);
        btnGet = findViewById(R.id.buttonGet);
        btnDel = findViewById(R.id.buttonDel);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = eName.getText().toString();
                String surname = eSurname.getText().toString();
                int year = Integer.parseInt(eYear.getText().toString());

                Data data = new Data(name, surname, year);
                dbHelper.addOne(data);

                eName.setText("");
                eSurname.setText("");
                eYear.setText("");
            }
        });

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinkedList<Data> list = dbHelper.getAll();
                String text = "";
                for (Data d : list){
                    text = text + d.name + " " + d.surname + " " + d.age + "\n";
                }
                tvOut.setText(text);
            }
        });


        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.deleteAll();
            }
        });
    }
}