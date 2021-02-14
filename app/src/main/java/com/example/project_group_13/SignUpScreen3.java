package com.example.project_group_13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUpScreen3 extends AppCompatActivity {

    Button signvao2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_screen3);

        signvao2 = (Button) findViewById(R.id.tieptucsignup3);
        signvao2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpScreen3.this,ThanksForRegistration.class);
                startActivity(intent);
            }
        });
    }
}