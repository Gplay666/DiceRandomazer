package com.example.dicesim2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Stats extends AppCompatActivity {
    Button SAVE, button5, button6;
    EditText STR, DEX, CON, INT, WIS, CHA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        SAVE = findViewById(R.id.SAVE);
        STR = findViewById(R.id.STR);
        CON = findViewById(R.id.CON);
        DEX = findViewById(R.id.DEX);
        INT = findViewById(R.id.INT);
        WIS = findViewById(R.id.WIS);
        CHA = findViewById(R.id.CHA);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
    }
    String LOG_TAG = "Logs";
    void writeFile(String FILENAME, String FILE) {
        try {
            // отрываем поток для записи
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                    openFileOutput(FILENAME, MODE_PRIVATE)));
            // пишем данные
            bw.write(FILE);
            // закрываем поток
            bw.close();
            Log.d(LOG_TAG, "Установлено значение "+FILENAME+": "+FILE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
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
    String readFile1(String FILENAME) {
        String i = "";
        try {
            // открываем поток для чтения
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    openFileInput(FILENAME)));
            String str = "";
            Источник: https://java-blog.ru/osnovy/perevod-int-string-java
            // читаем содержимое
            while ((str = br.readLine()) != null) {
                Log.d(LOG_TAG, str);
                i = str;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return i;
    }
    public void Stats(View view){
        int DO = readFile("DO");
            if (DO == 1) {
                STR.setText(readFile("STR"));
                DEX.setText(readFile("DEX"));
                CON.setText(readFile("CON"));
                INT.setText(readFile("INT"));
                WIS.setText(readFile("WIS"));
                CHA.setText(readFile("CHA"));
            }
        writeFile("DO", "1");
    }
    public void hui(View v){ // Хуета, чтобы восстановить значения, сохранённые в файле
        STR.setText(readFile1("STR"));
        DEX.setText(readFile1("DEX"));
        CON.setText(readFile1("CON"));
        INT.setText(readFile1("INT"));
        WIS.setText(readFile1("WIS"));
        CHA.setText(readFile1("CHA"));
    }
    public void pisda(View v){ //Обнуление значений на экране (не в файле)
        STR.setText("0");
        DEX.setText("0");
        CON.setText("0");
        INT.setText("0");
        WIS.setText("0");
        CHA.setText("0");
    }
    public void SAVE(View v){
        writeFile("STR", String.valueOf(STR.getText()));
        writeFile("DEX", String.valueOf(DEX.getText()));
        writeFile("CON", String.valueOf(CON.getText()));
        writeFile("INT", String.valueOf(INT.getText()));
        writeFile("WIS", String.valueOf(WIS.getText()));
        writeFile("CHA", String.valueOf(CHA.getText()));
    }

}