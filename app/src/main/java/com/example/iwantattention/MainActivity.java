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
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RequestPermission();
        final EditText textCustomRequest = findViewById(R.id.txtCustomRequest);
        disableEditText(textCustomRequest);
        final Button btnOne = findViewById(R.id.btnOne);
        btnOne.setBackgroundColor(Color.MAGENTA);
        final Button btnTwo = findViewById(R.id.btnTwo);
        btnTwo.setBackgroundColor(Color.MAGENTA);
        final Button btnThree = findViewById(R.id.btnThree);
        btnThree.setBackgroundColor(Color.MAGENTA);
        final Button btnFour = findViewById(R.id.btnFour);
        btnFour.setBackgroundColor(Color.MAGENTA);
        final Button btnFive = findViewById(R.id.btnFive);
        btnFive.setBackgroundColor(Color.MAGENTA);
        final Button btnSix = findViewById(R.id.btnSix);
        btnSix.setBackgroundColor(Color.MAGENTA);
        final Button btnSeven = findViewById(R.id.btnSeven);
        btnSeven.setBackgroundColor(Color.MAGENTA);
        final Button btnCustom = findViewById(R.id.btnCustom);
        btnCustom.setBackgroundColor(Color.MAGENTA);
        final Button btnSend = findViewById(R.id.btnSend);
        btnSend.setBackgroundColor(Color.MAGENTA);
        //string "message" will be the selected button as a string and will be sent in a message
        //starts blank, and once a button is pushed, the message will be updated
        final String[] message = {""};
        //when a button is pressed, it changes colour to yellow,
        //and the message string matches the button text
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnOne.setBackgroundColor(Color.YELLOW);
                btnTwo.setBackgroundColor(Color.MAGENTA);
                btnThree.setBackgroundColor(Color.MAGENTA);
                btnFour.setBackgroundColor(Color.MAGENTA);
                btnFive.setBackgroundColor(Color.MAGENTA);
                btnSix.setBackgroundColor(Color.MAGENTA);
                btnSeven.setBackgroundColor(Color.MAGENTA);
                btnCustom.setBackgroundColor(Color.MAGENTA);
                message[0] = btnOne.getText().toString();
            }
        });
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnTwo.setBackgroundColor(Color.YELLOW);
                btnOne.setBackgroundColor(Color.MAGENTA);
                btnThree.setBackgroundColor(Color.MAGENTA);
                btnFour.setBackgroundColor(Color.MAGENTA);
                btnFive.setBackgroundColor(Color.MAGENTA);
                btnSix.setBackgroundColor(Color.MAGENTA);
                btnSeven.setBackgroundColor(Color.MAGENTA);
                btnCustom.setBackgroundColor(Color.MAGENTA);
                message[0] = btnTwo.getText().toString();
            }
        });
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnThree.setBackgroundColor(Color.YELLOW);
                btnOne.setBackgroundColor(Color.MAGENTA);
                btnTwo.setBackgroundColor(Color.MAGENTA);
                btnFour.setBackgroundColor(Color.MAGENTA);
                btnFive.setBackgroundColor(Color.MAGENTA);
                btnSix.setBackgroundColor(Color.MAGENTA);
                btnSeven.setBackgroundColor(Color.MAGENTA);
                btnCustom.setBackgroundColor(Color.MAGENTA);
                message[0] = btnThree.getText().toString();
            }
        });
        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnFour.setBackgroundColor(Color.YELLOW);
                btnOne.setBackgroundColor(Color.MAGENTA);
                btnTwo.setBackgroundColor(Color.MAGENTA);
                btnThree.setBackgroundColor(Color.MAGENTA);
                btnFive.setBackgroundColor(Color.MAGENTA);
                btnSix.setBackgroundColor(Color.MAGENTA);
                btnSeven.setBackgroundColor(Color.MAGENTA);
                btnCustom.setBackgroundColor(Color.MAGENTA);
                message[0] = btnFour.getText().toString();
            }
        });
        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnFive.setBackgroundColor(Color.YELLOW);
                btnOne.setBackgroundColor(Color.MAGENTA);
                btnTwo.setBackgroundColor(Color.MAGENTA);
                btnThree.setBackgroundColor(Color.MAGENTA);
                btnFour.setBackgroundColor(Color.MAGENTA);
                btnSix.setBackgroundColor(Color.MAGENTA);
                btnSeven.setBackgroundColor(Color.MAGENTA);
                btnCustom.setBackgroundColor(Color.MAGENTA);
                message[0] = btnFive.getText().toString();
            }
        });
        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSix.setBackgroundColor(Color.YELLOW);
                btnOne.setBackgroundColor(Color.MAGENTA);
                btnTwo.setBackgroundColor(Color.MAGENTA);
                btnThree.setBackgroundColor(Color.MAGENTA);
                btnFour.setBackgroundColor(Color.MAGENTA);
                btnFive.setBackgroundColor(Color.MAGENTA);
                btnSeven.setBackgroundColor(Color.MAGENTA);
                btnCustom.setBackgroundColor(Color.MAGENTA);
                message[0] = btnSix.getText().toString();
            }
        });
        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnSeven.setBackgroundColor(Color.YELLOW);
                btnOne.setBackgroundColor(Color.MAGENTA);
                btnTwo.setBackgroundColor(Color.MAGENTA);
                btnThree.setBackgroundColor(Color.MAGENTA);
                btnFour.setBackgroundColor(Color.MAGENTA);
                btnFive.setBackgroundColor(Color.MAGENTA);
                btnSix.setBackgroundColor(Color.MAGENTA);
                btnCustom.setBackgroundColor(Color.MAGENTA);
                message[0] = btnSeven.getText().toString();
            }
        });
        btnCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnCustom.setBackgroundColor(Color.YELLOW);
                btnOne.setBackgroundColor(Color.MAGENTA);
                btnTwo.setBackgroundColor(Color.MAGENTA);
                btnThree.setBackgroundColor(Color.MAGENTA);
                btnFour.setBackgroundColor(Color.MAGENTA);
                btnFive.setBackgroundColor(Color.MAGENTA);
                btnSix.setBackgroundColor(Color.MAGENTA);
                btnSeven.setBackgroundColor(Color.MAGENTA);
                enableEditText(textCustomRequest);
                message[0] = "";
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String customRequest = textCustomRequest.getText().toString();
                String msg = message[0];
                if(msg == ""){
                    msg = customRequest;
                }
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
    public void disableEditText(EditText et){
        et.setFocusable(false);
        et.setEnabled(false);
        et.setBackgroundColor(Color.TRANSPARENT);
    }
    public void enableEditText(EditText et){
        et.setBackgroundColor(Color.YELLOW);
        et.setFocusableInTouchMode(true);
        et.setEnabled(true);
        et.requestFocus();
    }
    public void SendMessage(String message){
        SmsManager smsManager = SmsManager.getDefault();
        String smsNumber = "15062605793";
        String smsText = message + "\n\n sent from the iWantAttention app";
        smsManager.sendTextMessage(smsNumber, null, smsText, null, null);
    }
}

