package com.example.d001;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class CalculateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);


        TextView height = findViewById(R.id.calculateInsertedHeight);
        TextView weight = findViewById(R.id.calculateInsertedWeight);

        String insertedHeight = getIntent().getStringExtra("Height");
        String insertedWeight = getIntent().getStringExtra("Weight");

        height.setText(insertedHeight);
        weight.setText(insertedWeight);
    }
}