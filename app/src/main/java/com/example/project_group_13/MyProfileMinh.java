package com.example.project_group_13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MyProfileMinh extends AppCompatActivity {
    TextView goMyOrder1;
    TextView goSecurity;
    TextView goPayment1;
    TextView goBackMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile_minh);

        goMyOrder1 = (TextView) findViewById(R.id.myorder);
        goMyOrder1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyProfileMinh.this,Myorder1Duc.class);
                startActivity(intent);
            }
        });
        goSecurity = (TextView) findViewById(R.id.security);
        goSecurity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyProfileMinh.this,SecurityNg.class);
                startActivity(intent);
            }
        });
        goPayment1 = (TextView) findViewById(R.id.payment);
        goPayment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyProfileMinh.this,Payment1Tan.class);
                startActivity(intent);
            }
        });

        goBackMain = (TextView) findViewById(R.id.backmain);
        goBackMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyProfileMinh.this,MainScreen.class);
                startActivity(intent);
            }
        });
    }
}