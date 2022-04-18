package com.example.d001;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import util.BMI;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);


        ListView categoryList = findViewById(R.id.categoryList);

        String[] bmiCategories = BMI.getBmiCategories();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, bmiCategories);
        categoryList.setAdapter(adapter);
        categoryList.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(this, LegendActivity.class);
            intent.putExtra("position",position);
            startActivity(intent);
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.home, menu);
        menu.findItem(R.id.menu_general_item_bmioverview).setEnabled(false);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_general_item_form:
                startActivity(new Intent(this, FormActivity.class));
                return true;
            case R.id.menu_general_item_home:
                startActivity(new Intent(this, HomeActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }
}