package com.example.d001;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.text.Normalizer;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        String extra = getIntent().getStringExtra("keytext");
        Log.i(FormActivity.class.getSimpleName(), extra);
    }
}