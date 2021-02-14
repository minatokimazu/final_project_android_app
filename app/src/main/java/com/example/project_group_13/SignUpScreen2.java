package com.example.project_group_13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUpScreen2 extends AppCompatActivity {
    Button signvao123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_screen2);

        signvao123 = (Button) findViewById(R.id.tieptuc);
        signvao123.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpScreen2.this,SignUpScreen3.class);
                startActivity(intent);
            }
        });

    }
}