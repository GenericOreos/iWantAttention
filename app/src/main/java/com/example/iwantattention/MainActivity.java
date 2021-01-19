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
        final Button btnTwo = findViewById(R.id.btnTwo);
        final Button btnThree = findViewById(R.id.btnThree);
        final Button btnFour = findViewById(R.id.btnFour);
        final Button btnFive = findViewById(R.id.btnFive);
        final Button btnSix = findViewById(R.id.btnSix);
        final Button btnSeven = findViewById(R.id.btnSeven);
        final Button btnCustom = findViewById(R.id.btnCustom);
        final Button btnSend = findViewById(R.id.btnSend);
        //string "message" will be the selected button as a string and will be sent in a message
        //starts blank, and once a button is pushed, the message will be updated
        final String[] message = {""};
        final Button[] buttons = {btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnCustom, btnSend};
        for (Button btn: buttons) {
            btn.setBackgroundColor(Color.MAGENTA);
        }
        //when a button is pressed, it changes colour to yellow,
        //and the message string matches the button text
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnActivate(btnOne, buttons);
                message[0] = btnOne.getText().toString();
                disableEditText(textCustomRequest);
            }
        });
        btnOne.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                btnActivate(btnOne, buttons);
                enableEditText(textCustomRequest);
                ButtonTextChange(btnOne, textCustomRequest);
                return true;
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnActivate(btnTwo, buttons);
                message[0] = btnTwo.getText().toString();
                disableEditText(textCustomRequest);
            }
        });
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnActivate(btnThree, buttons);
                message[0] = btnThree.getText().toString();
                disableEditText(textCustomRequest);
            }
        });
        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnActivate(btnFour, buttons);
                message[0] = btnFour.getText().toString();
                disableEditText(textCustomRequest);
            }
        });
        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnActivate(btnFive, buttons);
                message[0] = btnFive.getText().toString();
                disableEditText(textCustomRequest);
            }
        });
        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnActivate(btnSix, buttons);
                message[0] = btnSix.getText().toString();
                disableEditText(textCustomRequest);
            }
        });
        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnActivate(btnSeven, buttons);
                message[0] = btnSeven.getText().toString();
                disableEditText(textCustomRequest);
            }
        });
        btnCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnActivate(btnCustom, buttons);
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

    private Button[] btnActivate(Button btn, Button[] buttons) {
        for (Button button: buttons
             ) {
                if (button == btn) {
                    button.setBackgroundColor(Color.YELLOW);
                } else {
                    button.setBackgroundColor(Color.MAGENTA);
                }
        }
        return buttons;
    }

    private void ButtonTextChange(final Button button, final EditText editText){
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(!hasFocus){
                    button.setText(editText.getText().toString());
                }
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
        et.setText("");
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

