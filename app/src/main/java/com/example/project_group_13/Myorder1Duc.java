package com.example.project_group_13;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Myorder1Duc extends AppCompatActivity {

    public TextView seeDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myorder1_duc);
        seeDetail= (TextView) findViewById(R.id.seeDetail20);
        seeDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Myorder1Duc.this,Myorder2Duc.class);
                startActivity(intent);
            }
        });
    }
}