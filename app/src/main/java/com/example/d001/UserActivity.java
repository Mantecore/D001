package com.example.d001;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Button SaveButton = findViewById(R.id.userSaveButton);
        EditText userName = findViewById(R.id.editTextUser);

        SaveButton.setOnClickListener(view -> {
            String NameofUser = userName.getText().toString();

            SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("user", NameofUser);
            editor.commit();

        });
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.home, menu);
        menu.findItem(R.id.menu_general_item_user).setEnabled(false);
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