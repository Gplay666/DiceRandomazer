package com.example.dicesim2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class About extends AppCompatActivity {
    TextView Discord, Git, Email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Discord = findViewById(R.id.Discord);
        Git = findViewById(R.id.Git);
        Email = findViewById(R.id.Email);
    }
}