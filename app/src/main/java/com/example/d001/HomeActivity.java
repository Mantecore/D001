package com.example.d001;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.text.Normalizer;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button buttonStartCalculator = findViewById(R.id.homeButtonStartCalculator);
        //buttonStartCalculator.setOnClickListener(view -> System.out.println("Button gedrückt"));
        //buttonStartCalculator.setOnClickListener(view -> Log.i(HomeActivity.class.getSimpleName(),"Button gedrückt"));
        buttonStartCalculator.setOnClickListener(view -> {
            Intent intent = new Intent(this, FormActivity.class);
            startActivity(intent);
                });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.home, menu);
        menu.findItem(R.id.menu_general_item_home).setEnabled(false);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
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