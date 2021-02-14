package com.example.project_group_13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class GreenLightFamily extends AppCompatActivity {

    private static RadioGroup radio_g;
    private static RadioButton radio_b, radio_b1, radio_b2;
    private static Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green_light_family);
        onClickListenerButton();
    }
    public void onClickListenerButton() {
        radio_g = (RadioGroup)findViewById(R.id.groupAccept);
        submit = (Button)findViewById(R.id.button);
        submit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int selected_id = radio_g.getCheckedRadioButtonId();
                        radio_b = (RadioButton)findViewById(selected_id);
                        radio_b1 = (RadioButton)findViewById(R.id.radioButton);
                        radio_b2 = (RadioButton)findViewById(R.id.radioButton2);
                        if( radio_b ==  radio_b1 ) {
                            Intent intent = new Intent(GreenLightFamily.this,Registration.class);
                            startActivity(intent);
                        }
                        if( radio_b ==  radio_b2 ) {
                            Intent intent = new Intent(GreenLightFamily.this,SubsActivity.class);
                            startActivity(intent);
                        }

                    }
                }
        );
    }
}