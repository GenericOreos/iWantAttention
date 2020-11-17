package com.example.iwantattention;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.material.snackbar.Snackbar;
import android.telephony.SmsManager;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RequestPermission();
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
        //string "message" will be the selected button as a string and will be sent in a message
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
                ShowNotification("Message sent!");
            }
        });
    }

    private void RequestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                        android.Manifest.permission.SEND_SMS)) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Send SMS permission");
                    builder.setPositiveButton(android.R.string.ok, null);
                    builder.setMessage("Please enable access to SMS.");
                    builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @TargetApi(Build.VERSION_CODES.M)
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            requestPermissions(
                                    new String[]
                                            {android.Manifest.permission.SEND_SMS}
                                    , 1);
                        }
                    });
                    builder.show();
                } else {
                    ActivityCompat.requestPermissions(this,
                            new String[]{android.Manifest.permission.SEND_SMS},
                            1);
                }
            } else {
               //
            }
        } else {
            //
        }
    }

    public void ShowNotification(String message) {
        Snackbar display = Snackbar.make(findViewById(R.id.btnSend), message, Snackbar.LENGTH_LONG);
        display.show();
    }
    public void SendMessage(String message){
        //code to send over email - using SMS instead
        /*String[] TO = {"adambrewer88@gmail.com"};
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
        }*/
        SmsManager smsManager = SmsManager.getDefault();
        String smsNumber = "15062605793";
        String smsText = message + "\n\n sent from the iWantAttention app";
        smsManager.sendTextMessage(smsNumber, null, smsText, null, null);
    }
}

