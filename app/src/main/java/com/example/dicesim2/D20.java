package com.example.dicesim2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class D20 extends AppCompatActivity {
    RadioButton strr, dexx, conn, intt, wiss, chaa, Shtraf, Bonus, Nothing;
    Button FN;
    TextView FinalResult;
    EditText Mod, ShtrafBonus, CelNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d20);
        Shtraf = findViewById(R.id.Shtraf);
        Bonus = findViewById(R.id.Bonus);
        Nothing = findViewById(R.id.Nothing);
        ShtrafBonus = findViewById(R.id.ShtrafBonus);
        CelNum = findViewById(R.id.CelNum);
        strr = findViewById(R.id.strr);
        dexx = findViewById(R.id.dexx);
        conn = findViewById(R.id.conn);
        intt = findViewById(R.id.intt);
        wiss = findViewById(R.id.wiss);
        chaa = findViewById(R.id.chaa);
        FN = findViewById(R.id.FN);
    }
    String LOG_TAG = "Logs";
    int readFile(String FILENAME) {
        int i = 0;
        try {
            // открываем поток для чтения
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    openFileInput(FILENAME)));
            String str = "";
            Источник: https://java-blog.ru/osnovy/perevod-int-string-java
            // читаем содержимое
            while ((str = br.readLine()) != null) {
                Log.d(LOG_TAG, str);
                i = Integer.parseInt (str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return i;
    }
    public void D20(View view){
        int chara = 0;
        int i2;
        int min = 1;
        int max = 20;
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff + 1);
        i = i + min;
        if (strr.isChecked()){
            chara = readFile("STR");
        }else if (dexx.isChecked()){
            chara = readFile("DEX");
        }else if (conn.isChecked()){
            chara = readFile("CON");
        }else if (intt.isChecked()){
            chara = readFile("INT");
        }else if (wiss.isChecked()){
            chara = readFile("WIS");
        }else if (chaa.isChecked()){
            chara = readFile("CHA");
        }
        int mod = (chara-10)/2;
        i=i+mod;
        int sht = Integer.parseInt(ShtrafBonus.getText().toString());
            i=i+sht;
        int cn = Integer.parseInt(CelNum.getText().toString());
        if (Shtraf.isChecked()){
            int min1 = 1;
            int max1 = 20;
            int diff1 = max1 - min1;
            Random random1 = new Random();
            int i1 = random1.nextInt(diff + 1);
            i1=i1+sht+mod+min1;
            i2 = Math.min(i, i1);
        }else if (Shtraf.isChecked()){
            int min1 = 1;
            int max1 = 20;
            int diff1 = max1 - min1;
            Random random1 = new Random();
            int i1 = random1.nextInt(diff + 1);
            i1=i1+sht+mod+min1;
            i2 = Math.max(i, i1);
        }else {
            i2 = i;
        }
        if ((i2>cn)|(i2==cn)){
            FN.setText("Удача улыбнулась вам ("+i2+")");
        }else{
            FN.setText("Действие провалено ("+i2+")");
        }
    }
}