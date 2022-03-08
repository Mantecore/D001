package com.example.d001;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import util.BMI;

public class CalculateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        BMI bmi = new BMI();

        TextView height = findViewById(R.id.calculateInsertedHeight);
        TextView weight = findViewById(R.id.calculateInsertedWeight);
        TextView OutputBMI = findViewById(R.id.calculateOutputBMI);
        TextView OutputRating = findViewById(R.id.calculateRatingOutput);

        String insertedHeight = getIntent().getStringExtra("Height");
        String insertedWeight = getIntent().getStringExtra("Weight");

        height.setText(insertedHeight);
        weight.setText(insertedWeight);

        double parsedHeight = Double.parseDouble(insertedHeight);
        double parsedWeight = Double.parseDouble(insertedWeight);

        double calculatedBMI = bmi.compute(parsedHeight, parsedWeight);
        String calculatedRating = bmi.BMICategory(bmi.BMIValue);

        OutputBMI.setText(String.format("%.2f",calculatedBMI));
        OutputRating.setText(calculatedRating);




    }
}