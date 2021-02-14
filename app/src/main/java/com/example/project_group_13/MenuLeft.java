package com.example.project_group_13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuLeft extends AppCompatActivity {

    TextView directchim;
    TextView directcu;
    TextView direct12123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_left);


        direct12123 = (TextView) findViewById(R.id.automodene);
        direct12123.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuLeft.this, AutoMode100.class);
                startActivity(intent);
            }
        });

        directcu = (TextView) findViewById(R.id.lightne);
        directcu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuLeft.this, LighControl100.class);
                startActivity(intent);
            }
        });

        directchim = (TextView) findViewById(R.id.setupne);
        directchim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuLeft.this, ManualSetup100.class);
                startActivity(intent);
            }
        });
    }
}