package com.example.lab5_milestone1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public void loginButtonClick(View view) {
        EditText usernameTextField = (EditText) findViewById(R.id.editTextUsername);
        String usernameString = usernameTextField.getText().toString();

        EditText passwordTextField = (EditText) findViewById(R.id.editTextPassword);
        String passwordString = passwordTextField.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences("com.example.lab5_milestone1", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("username", usernameString).apply();

        goToNotesActivity(usernameString);
    }

    public void goToNotesActivity(String s) {
        Intent intent = new Intent(this, NotesActivity.class);
        intent.putExtra("message",s);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String usernameKey = "username";
        SharedPreferences sharedPreferences = getSharedPreferences("com.example.lab5_milestone1", Context.MODE_PRIVATE);

        if (!sharedPreferences.getString(usernameKey, "").equals("")) {
            String username = sharedPreferences.getString(usernameKey, "");
            Intent intent = new Intent(this, NotesActivity.class);
            startActivity(intent);
        } else {
            setContentView(R.layout.activity_main);
        }
    }
}