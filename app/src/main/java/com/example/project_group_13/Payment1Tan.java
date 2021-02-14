package com.example.project_group_13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Payment1Tan extends AppCompatActivity {
    public TextView backprof;
    public TextView edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment1_tan);
        backprof = (TextView) findViewById(R.id.profileback);
        backprof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Payment1Tan.this,MyProfileMinh.class);
                startActivity(intent);
            }
        });
        edit = (TextView) findViewById(R.id.edit0);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Payment1Tan.this,Payment2Tan.class);
                startActivity(intent);
            }
        });
    }
}