package com.example.d001;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.home, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_general_item_home:
                startActivity(new Intent(this, HomeActivity.class));
            case R.id.menu_general_item_form:
                startActivity(new Intent(this, FormActivity.class));
                return true;
            case R.id.menu_general_item_bmioverview:
                startActivity(new Intent(this, CategoryActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }
}