package com.example.lab5_milestone1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;

public class NotesActivity extends AppCompatActivity {

    TextView welcomeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        SharedPreferences sharedPreferences = getSharedPreferences("com.example.lab5_milestone1", Context.MODE_PRIVATE);
        String usernameKey = sharedPreferences.getString("username","");

        welcomeText = (TextView) findViewById(R.id.welcomeTextView);
        //Intent intent = getIntent();
        //String str = intent.getStringExtra("message");
        welcomeText.setText("Hello " + usernameKey + "!");
    }

    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu, popup.getMenu());
        popup.show();
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        switch (item.getItemId()) {
            case R.id.AddNote:
                //Nothing for now
                return true;
            case R.id.Logout:
                goToMainActivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void goToMainActivity() {
        Intent openMainActivity = new Intent(this, MainActivity.class);
        SharedPreferences sharedPreferences = getSharedPreferences("com.example.lab5_milestone1", Context.MODE_PRIVATE);
        sharedPreferences.edit().remove("username").apply();
        startActivity(openMainActivity);
    }
}