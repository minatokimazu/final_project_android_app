package com.example.project_group_13;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CommunicationEmailMinh extends AppCompatActivity {
    public TextView backprof;

    private static TextView savechange;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication_email_minh);
        backprof = (TextView) findViewById(R.id.profileback);
        backprof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommunicationEmailMinh.this,MyProfileMinh.class);
                startActivity(intent);
            }
        });
        onClickListenerButton();


    }
    public void onClickListenerButton() {
        savechange = (TextView) findViewById(R.id.savechanges1);
        savechange.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(CommunicationEmailMinh.this,savechange.getText().toString(),Toast.LENGTH_SHORT).show();;
                    }
                }
        );
    }
}