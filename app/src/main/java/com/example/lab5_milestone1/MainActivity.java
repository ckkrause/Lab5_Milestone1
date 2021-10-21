package com.example.lab5_milestone1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public void loginButtonClick(View view) {
        EditText myTextField = (EditText) findViewById(R.id.editTextUsername);
        String str = myTextField.getText().toString();

        goToNotesActivity(str);
    }

    public void goToNotesActivity(String s) {
        Intent intent = new Intent(this, NotesActivity.class);
        intent.putExtra("message",s);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}