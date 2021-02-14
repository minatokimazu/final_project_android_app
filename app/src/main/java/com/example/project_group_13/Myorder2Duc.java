package com.example.project_group_13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Myorder2Duc extends AppCompatActivity {

    public TextView seeDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myorder2_duc);
        seeDetail= (TextView) findViewById(R.id.seeDetail20);
        seeDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Myorder2Duc.this,Myorder3Duc.class);
                startActivity(intent);
            }
        });
    }
}