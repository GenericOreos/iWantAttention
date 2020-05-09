package com.example.iwantattention;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btnAttention = findViewById(R.id.btnAttention);
        btnAttention.setBackgroundColor(Color.MAGENTA);
        final Button btnSnuggles = findViewById(R.id.btnSnuggles);
        btnSnuggles.setBackgroundColor(Color.MAGENTA);
        final Button btnSnacks = findViewById(R.id.btnSnacks);
        btnSnacks.setBackgroundColor(Color.MAGENTA);
        final Button btnDrinks = findViewById(R.id.btnDrink);
        btnDrinks.setBackgroundColor(Color.MAGENTA);
        final Button btnTerry = findViewById(R.id.btnTerry);
        btnTerry.setBackgroundColor(Color.MAGENTA);
        final Button btnPrincess = findViewById(R.id.btnPrincess);
        btnPrincess.setBackgroundColor(Color.MAGENTA);
        Button btnSend = findViewById(R.id.btnSend);
        btnSend.setBackgroundColor(Color.MAGENTA);
        //string "message" will be the selected button as a string and will be sent in an email
        //starts blank, and once a button is pushed, the message will be updated
        final String[] message = {""};
        //when a button is pressed, it changes colour to yellow,
        //and the message string matches the button text
        btnAttention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAttention.setBackgroundColor(Color.YELLOW);
                btnSnuggles.setBackgroundColor(Color.MAGENTA);
                btnSnacks.setBackgroundColor(Color.MAGENTA);
                btnDrinks.setBackgroundColor(Color.MAGENTA);
                btnTerry.setBackgroundColor(Color.MAGENTA);
                btnPrincess.setBackgroundColor(Color.MAGENTA);
                message[0] = "I want attention";
            }
        });
        btnSnuggles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSnuggles.setBackgroundColor(Color.YELLOW);
                btnAttention.setBackgroundColor(Color.MAGENTA);
                btnSnacks.setBackgroundColor(Color.MAGENTA);
                btnDrinks.setBackgroundColor(Color.MAGENTA);
                btnTerry.setBackgroundColor(Color.MAGENTA);
                btnPrincess.setBackgroundColor(Color.MAGENTA);
                message[0] = "I want snuggles";
            }
        });
        btnSnacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSnacks.setBackgroundColor(Color.YELLOW);
                btnSnuggles.setBackgroundColor(Color.MAGENTA);
                btnAttention.setBackgroundColor(Color.MAGENTA);
                btnDrinks.setBackgroundColor(Color.MAGENTA);
                btnTerry.setBackgroundColor(Color.MAGENTA);
                btnPrincess.setBackgroundColor(Color.MAGENTA);
                message[0] = "I want snacks";
            }
        });
        btnDrinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDrinks.setBackgroundColor(Color.YELLOW);
                btnSnacks.setBackgroundColor(Color.MAGENTA);
                btnSnuggles.setBackgroundColor(Color.MAGENTA);
                btnAttention.setBackgroundColor(Color.MAGENTA);
                btnTerry.setBackgroundColor(Color.MAGENTA);
                btnPrincess.setBackgroundColor(Color.MAGENTA);
                message[0] = "I want a drink";
            }
        });
        btnTerry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnTerry.setBackgroundColor(Color.YELLOW);
                btnDrinks.setBackgroundColor(Color.MAGENTA);
                btnSnacks.setBackgroundColor(Color.MAGENTA);
                btnSnuggles.setBackgroundColor(Color.MAGENTA);
                btnAttention.setBackgroundColor(Color.MAGENTA);
                btnPrincess.setBackgroundColor(Color.MAGENTA);
                message[0] = "I want Terry";
            }
        });
        btnPrincess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPrincess.setBackgroundColor(Color.YELLOW);
                btnDrinks.setBackgroundColor(Color.MAGENTA);
                btnSnacks.setBackgroundColor(Color.MAGENTA);
                btnSnuggles.setBackgroundColor(Color.MAGENTA);
                btnAttention.setBackgroundColor(Color.MAGENTA);
                btnTerry.setBackgroundColor(Color.MAGENTA);
                message[0] = "I want Princess";
            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String msg = message[0];
                ShowNotification("Message sent to Adam: " + "'" + msg + "'");
            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = message[0];
                SendMessage(msg);
            }
        });
    }
    public void ShowNotification(String message) {
        Snackbar display = Snackbar.make(findViewById(R.id.btnSend), message, Snackbar.LENGTH_LONG);
        display.show();
    }
    public void SendMessage(String message){
        String[] TO = {"adambrewer88@gmail.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("message/rfc822");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, message);
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Sent from the iWantAttention app");
        try {
            startActivity(Intent.createChooser(emailIntent,"Send the message via email"));
            finish();
        } catch (android.content.ActivityNotFoundException ex) {
            ShowNotification("There is no email client installed on this device");
        }
    }
}
