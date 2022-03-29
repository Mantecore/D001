package com.example.d001;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);


        ListView categoryList = findViewById(R.id.categoryList);

        String[] bmiCategories = {
                "Underweight",
                "Healthy Weight",
                "Overweight",
                "Obese",
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, bmiCategories);
        categoryList.setAdapter(adapter);
        categoryList.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(this, HomeActivity.class);
            intent.putExtra("position",position);
            startActivity(intent);
        });


    }
}