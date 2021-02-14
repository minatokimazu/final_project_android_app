package com.example.project_group_13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Payment extends AppCompatActivity {

    public ImageView goRegistration;
    public ImageView goTypes;
    public TextView goThankYou;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        goTypes = (ImageView) findViewById(R.id.circleMid2);
        goTypes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Payment.this,Types.class);
                startActivity(intent);
            }
        });

        goRegistration = (ImageView) findViewById(R.id.circleLeft2);
        goRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Payment.this,Registration.class);
                startActivity(intent);
            }
        });

        goThankYou = (TextView) findViewById(R.id.completePurchase);
        goThankYou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Payment.this,ThankYou.class);
                startActivity(intent);
            }
        });
    }
}