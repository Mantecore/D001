package com.example.d001;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.Normalizer;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        String extra = getIntent().getStringExtra("keytext");
        Log.i(FormActivity.class.getSimpleName(), extra);

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
}