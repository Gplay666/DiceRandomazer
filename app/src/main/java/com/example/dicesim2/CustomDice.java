package com.example.dicesim2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class CustomDice extends AppCompatActivity {
    TextView D, Result;
    Button Roll;
    EditText Number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dice);
        D = findViewById(R.id.D);
        Result = findViewById(R.id.Result);
        Roll = findViewById(R.id.Roll);
        Number = findViewById(R.id.Number);
    }
    public void Roll(View V){
        int min = 1;
        int max = Integer.parseInt(Number.getText().toString());
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff + 1);
        i += min;
        Result.setText(Integer.toString(i));
    }
}