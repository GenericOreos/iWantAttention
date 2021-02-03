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
import android.view.WindowManager;
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
        final Button btnEight = findViewById(R.id.btnEight);
        final Button btnSend = findViewById(R.id.btnSend);
        btnSend.setBackgroundColor(Color.MAGENTA);
        //string "message" will be the selected button as a string and will be sent in a message
        //starts blank, and once a button is pushed, the message will be updated
        final String[] message = {""};
        final Button[] buttons = {btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight};
        for (Button btn: buttons) {
            btn.setBackgroundColor(Color.MAGENTA);
        }
        //when a button is pressed, it changes colour to yellow,
        //and the message string matches the button text
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonPress(btnOne, buttons);
                message[0] = btnOne.getText().toString();
                disableEditText(textCustomRequest);
            }
        });
        btnOne.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                enableEditText(textCustomRequest);
                ButtonTextChange(btnOne, textCustomRequest);
                getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
                return true;
            }
        });
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonPress(btnTwo, buttons);
                message[0] = btnTwo.getText().toString();
                disableEditText(textCustomRequest);
            }
        });
        btnTwo.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                enableEditText(textCustomRequest);
                ButtonTextChange(btnTwo, textCustomRequest);
                return true;
            }
        });
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonPress(btnThree, buttons);
                message[0] = btnThree.getText().toString();
                disableEditText(textCustomRequest);
            }
        });
        btnThree.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                enableEditText(textCustomRequest);
                ButtonTextChange(btnThree, textCustomRequest);
                return true;
            }
        });
        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonPress(btnFour, buttons);
                message[0] = btnFour.getText().toString();
                disableEditText(textCustomRequest);
            }
        });
        btnFour.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                enableEditText(textCustomRequest);
                ButtonTextChange(btnFour, textCustomRequest);
                return true;
            }
        });
        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonPress(btnFive, buttons);
                message[0] = btnFive.getText().toString();
                disableEditText(textCustomRequest);
            }
        });
        btnFive.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                enableEditText(textCustomRequest);
                ButtonTextChange(btnFive, textCustomRequest);
                return true;
            }
        });
        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonPress(btnSix, buttons);
                message[0] = btnSix.getText().toString();
                disableEditText(textCustomRequest);
            }
        });
        btnSix.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                enableEditText(textCustomRequest);
                ButtonTextChange(btnSix, textCustomRequest);
                return true;
            }
        });
        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonPress(btnSeven, buttons);
                message[0] = btnSeven.getText().toString();
                disableEditText(textCustomRequest);
            }
        });
        btnSeven.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                enableEditText(textCustomRequest);
                ButtonTextChange(btnSeven, textCustomRequest);
                return true;
            }
        });
        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonPress(btnEight, buttons);
                message[0] = btnEight.getText().toString();
                disableEditText(textCustomRequest);
            }
        });
        btnEight.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                enableEditText(textCustomRequest);
                ButtonTextChange(btnEight, textCustomRequest);
                return true;
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

    private void ButtonPress(Button button, Button[] buttons){
        for (Button btn: buttons) {
            if (btn.equals(button)){
                btn.setBackgroundColor(Color.WHITE);
                btn.setTextColor(Color.MAGENTA);
            } else {
                btn.setBackgroundColor(Color.MAGENTA);
                btn.setTextColor(Color.WHITE);
            }
        }
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
        et.setFocusableInTouchMode(true);
        et.setEnabled(true);
        et.requestFocus();
        et.setBackgroundColor(Color.WHITE);
        et.setTextColor(Color.MAGENTA);
    }
    public void SendMessage(String message){
        SmsManager smsManager = SmsManager.getDefault();
        String smsNumber = "";
        String smsText = message + "\n\n sent from the iWantAttention app";
        smsManager.sendTextMessage(smsNumber, null, smsText, null, null);
    }
    public void highlight(Button button){

    }
}

