package com.example.d001;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
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
            intent.putExtra("keytext","Button gedrückt");
            startActivity(intent);
                });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.home,menu);
        return true;
    }
}