package com.example.d001;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import util.BMI;

public class LegendActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legend);


        String[] bmiCategorie = BMI.getBmiCategories();

        TextView LegendBMIName = findViewById(R.id.LegendBMIName);
        TextView LegendBMIDesc = findViewById(R.id.LegendBMIDesc);

        int position = getIntent().getIntExtra("position",0);

        switch (position)
        {
            case 0:
                BMI.Rating(0.0,18.5);
                break;
            case 1:
                BMI.Rating(18.5,24.9);
                break;
            case 2:
                BMI.Rating(25.0, 29.9);
                break;
            case 3:
                BMI.Rating(30.0,50.0);
                break;
        }


        double RatingHigh = BMI.getHigh();
        double RatingLow = BMI.getLow();

        LegendBMIName.setText(bmiCategorie[position]);
        LegendBMIDesc.setText(String.format("Values from %.1f to less than %.1f",RatingLow,RatingHigh));


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