package com.example.d001;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.Normalizer;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);



        Button calculateButton = findViewById(R.id.formButtonCalculate);
        Button clearButton = findViewById(R.id.formButtonClearValues);
        EditText editHeight = findViewById(R.id.formHeightInput);
        EditText editWeight = findViewById(R.id.formWeightInput);

        calculateButton.setOnClickListener(view -> {
            Intent calculateBMI = new Intent(this, CalculateActivity.class);
            String height = editHeight.getText().toString();
            String weight = editWeight.getText().toString();

            calculateBMI.putExtra("Height", height);
            calculateBMI.putExtra("Weight", weight);
            startActivity(calculateBMI);
        });

        clearButton.setOnClickListener(view -> {
            editHeight.setText("");
            editWeight.setText("");
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.home, menu);
        menu.findItem(R.id.menu_general_item_form).setEnabled(false);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_general_item_home:
                startActivity(new Intent(this, HomeActivity.class));
                return true;
            case R.id.menu_general_item_bmioverview:
                startActivity(new Intent(this, CategoryActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }
}