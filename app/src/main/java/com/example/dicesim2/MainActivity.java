package com.example.dicesim2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button D2, D4, D6, D8, D10, D12, D20, D100, button, button2, button4, Shiz, Changelogs, About;
    TextView textView2;
    Toolbar toolbar;
    int ti = 1;
    int maxlol = 4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        D2 = findViewById(R.id.D2);
        D4 = findViewById(R.id.D4);
        D12 = findViewById(R.id.D12);
        textView2 = findViewById(R.id.textView2);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        Shiz = findViewById(R.id.Shiz);
        Changelogs = findViewById(R.id.Changelogs);
        About = findViewById(R.id.About);
    }

    public void Shiz(View view) {
        Intent i;
        i = new Intent(this, Stats.class);
        startActivity(i);
    }
    public void them(View v) {
        if (ti == 1) {
        }
    }
    public void less(View view){
        switch (maxlol){
            case 4:
                D12.setText("D4");
                break;
            case 6:
                D12.setText("D4");
                maxlol = 4;
                break;
            case 8:
                D12.setText("D6");
                maxlol = 6;
                break;
            case 10:
                D12.setText("D8");
                maxlol = 8;
                break;
            case 12:
                D12.setText("D10");
                maxlol = 10;
                break;
            case 20:
                D12.setText("D12");
                maxlol = 12;
                break;
            case 100:
                D12.setText("D20");
                maxlol = 20;
                break;
        }
    }
    public void more (View view){
        switch (maxlol){
            case 4:
                D12.setText("D6");
                maxlol = 6;
                break;
            case 6:
                D12.setText("D8");
                maxlol = 8;
                break;
            case 8:
                D12.setText("D10");
                maxlol = 10;
                break;
            case 10:
                D12.setText("D12");
                maxlol = 12;
                break;
            case 12:
                D12.setText("D20");
                maxlol = 20;
                break;
            case 20:
                D12.setText("D100");
                maxlol = 100;
                break;
            case 100:
                D12.setText("D100");
                maxlol = 100;
                break;
        }
    }
    public void kazino(View view) {
        int min = 1;
        int max = maxlol;
         int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff + 1);
        i += min; //Код на рандом из инета, лол
        textView2.setText(String.valueOf(i));
    }
    public void Changelogs(View view){
        Intent intent3 = new Intent(MainActivity.this, Changelogs.class);
        startActivity(intent3);
    }
    public void About(View view){
        Intent intent4 = new Intent(MainActivity.this, About.class);
        startActivity(intent4);
    }

    public void K20(View v){
        Intent intent2 = new Intent(MainActivity.this, D20.class);
        startActivity(intent2);
    }
    public void custom(View V){
        Intent intent = new Intent(MainActivity.this, CustomDice.class);
        startActivity(intent);
    }
    /*
    public void D2(View V){
        int i;
        i = kazino(2);
        textView2.setText(Integer.toString(i));
    }
    public void D4(View V){
        int i;
        i = kazino(4);
        textView2.setText(Integer.toString(i));
    }
    public void D6(View V){
        int i;
        i = kazino(6);
        textView2.setText(Integer.toString(i));
    }
    public void D8(View V){
        int i;
        i = kazino(8);
        textView2.setText(Integer.toString(i));
    }
    public void D10(View V){
        int i;
        i = kazino(10);
        textView2.setText(Integer.toString(i));
    }
    public void D12(View V){
        int i;
        i = kazino(12);
        textView2.setText(Integer.toString(i));
    }
    public void D20(View V){
        int i;
        i = kazino(20);
        textView2.setText(Integer.toString(i));
    }
    public void D100(View V){
        int i;
        i = kazino(100);
        textView2.setText(Integer.toString(i));
    }
*/
}