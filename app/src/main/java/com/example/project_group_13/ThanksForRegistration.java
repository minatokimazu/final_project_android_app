package com.example.project_group_13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class ThanksForRegistration extends AppCompatActivity {

    Timer timer123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thanksfor_registration);

        timer123 = new Timer();
        timer123.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent (ThanksForRegistration.this,SignIn.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }
}