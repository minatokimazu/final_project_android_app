package com.example.project_group_13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ForgotPassword extends AppCompatActivity {
    Button forgot;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password);

        forgot = (Button) findViewById(R.id.tieptucpassword);
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgotPassword.this,GreetingScreen.class);
                startActivity(intent);
            }
        });

        back = (ImageView) findViewById(R.id.imageView14);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View v) {
            Intent intent = new Intent(ForgotPassword.this,SignIn.class);
            startActivity(intent);
        }
    });
}
}