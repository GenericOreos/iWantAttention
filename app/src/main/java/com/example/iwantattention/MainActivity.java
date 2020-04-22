package com.example.iwantattention;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnAttention = findViewById(R.id.btnAttention);
        Button btnSnuggles = findViewById(R.id.btnSnuggles);
        Button btnSnacks = findViewById(R.id.btnSnacks);
        Button btnDrinks = findViewById(R.id.btnDrink);
        Button btnTerry = findViewById(R.id.btnTerry);
        Button btnPrincess = findViewById(R.id.btnPrincess);
    }
}
