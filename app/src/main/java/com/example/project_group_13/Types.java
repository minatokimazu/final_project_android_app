package com.example.project_group_13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Types extends AppCompatActivity {

    public ImageView goRegistration;
    public ImageView goPayment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_types);

        goRegistration = (ImageView) findViewById(R.id.circleLeft);
        goRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Types.this,Registration.class);
                startActivity(intent);
            }
        });

        goPayment = (ImageView) findViewById(R.id.circleRight2);
        goPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Types.this,Payment.class);
                startActivity(intent);
            }
        });
    }
}