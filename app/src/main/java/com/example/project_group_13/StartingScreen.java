package com.example.project_group_13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartingScreen extends AppCompatActivity {

    Button signvao;
    Button signra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.starting_screen);

        signvao = (Button) findViewById(R.id.signin);
        signvao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartingScreen.this,SignIn.class);
                startActivity(intent);
            }
        });

        signra = (Button) findViewById(R.id.signup);
        signra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartingScreen.this,SignUpScreen1.class);
                startActivity(intent);
            }
        });
    }
}