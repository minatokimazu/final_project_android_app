package com.example.project_group_13;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class LighControl100 extends AppCompatActivity {

    ImageView congtac, threetia, left ,right;
    TextView note, nhietdo, doam, pressure;
    int count = 0;
    int pe = 0;
    double temp = 10.2;
    double humi = 60.5;
    double pres= 1031.4;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ligh_control100);
        drawerLayout = findViewById(R.id.drawer_layout);
        threetia = findViewById(R.id.threetia);
        congtac = findViewById(R.id.congtac);
        note = findViewById(R.id.note);
        nhietdo = findViewById(R.id.nhietdo);
        doam = findViewById(R.id.doam);
        pressure = findViewById(R.id.pressure);
        note.setText("Press to turn on");
        nhietdo.setText("Temperature:"+temp+"(C)temperature");
        doam.setText("Humidity:"+humi+"%");
        pressure.setText("Pressure:"+pres+"hPa");


        congtac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                if(count%2!=0){
                    congtac.setImageResource(R.drawable.congtacxanh);
                    threetia.setImageResource(R.drawable._tia);
                    note.setText("Press to turn off");
                } else {
                    congtac.setImageResource(R.drawable.congtacdo);
                    threetia.setImageDrawable(null);
                    note.setText("Press to turn on");
                }
            }
        });

        new Timer().schedule(new TimerTask(){
            @Override
            public void run() {
                runOnUiThread(new Runnable(){
                    @Override
                    public void run() {
                        pe++;
                        if(pe%3==0){
                            temp=temp+0.5;
                            humi=humi+1;
                            pres=pres+4;
                            nhietdo.setText(temp+"(C)");
                            doam.setText(humi+"%");
                            pressure.setText(pres+"hPa");
                        } else if(pe%3==1){
                            temp=temp-1;
                            humi=humi-1.5;
                            pres=pres-3;
                            nhietdo.setText(temp+"(C)");
                            doam.setText(humi+"%");
                            pressure.setText(pres+"hPa");
                        } else{
                            temp=temp+0.5;
                            humi=humi+0.5;
                            pres=pres-1;
                            nhietdo.setText(temp+"(C)");
                            doam.setText(humi+"%");
                            pressure.setText(pres+"hPa");
                        }
                    };
                });
            }
        }, 100, 1000);
    }
    public void ClickMenu(View view){
        //Open drawer
        openDrawer(drawerLayout);
    }

    public void AutoMode(View view){
        //Recreate activity
        redirectActivity(this,AutoMode100.class);
    }

    public void LightControl(View view){
        //Redirect activity to dashboard
        redirectActivity(this,LighControl100.class);
    }

    public void ManualSetup(View view){
        //redirect activity to about us
        redirectActivity(this,ManualSetup100.class);
    }

    public void MyProfile(View view){
        //redirect activity to about us
        redirectActivity(this,MyProfileMinh.class);
    }

    public void Subcription(View view){
        //redirect activity to about us
        redirectActivity(this,SubsActivity.class);
    }

    public void AboutUs(View view){
        //redirect activity to about us
        redirectActivity(this,AboutUs.class);
    }

    public void Communication(View view){
        //redirect activity to about us
        redirectActivity(this,CommunicationEmailMinh.class);
    }

    public void Logout(View view){
        //redirect activity to about us
        logout(this);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        //Open drawer layout
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        // CLose drawer layout
        //Check condition
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            //When drawer is opened
            //Close drawer
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public static void logout(Activity activity) {
        //Initialize alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        //Set title
        builder.setTitle("Logout");
        //Set message
        builder.setMessage("Are you sure you want to logout ?");
        //Positive yes button
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Finish activity
                activity.finishAffinity();
                //Exit app
                System.exit(0);
            }
        });
        //Negative no button
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Dismiss dialog
                dialog.dismiss();
            }
        });
        //SHow dialog
        builder.show();
    }

    public static void redirectActivity(Activity activity,Class aClass) {
        //Initialize intent
        Intent intent = new Intent(activity,aClass);
        //Set flag
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //Start activity
        activity.startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Close drawer
        closeDrawer(drawerLayout);
    }
}