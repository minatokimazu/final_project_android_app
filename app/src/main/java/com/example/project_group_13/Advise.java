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
import android.widget.TextView;


public class Advise extends AppCompatActivity {
    DrawerLayout drawerLayout;
    private TextView time;
    private final int lux = EnvironmentData.luxdata;
    private final int uv = EnvironmentData.uvdata;
    private final int temp = EnvironmentData.temdata;
    private final int hum = EnvironmentData.humdata;
    private TextView t_advise, h_advise, u_advise, l_advise;
    int count = 20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advise);
        drawerLayout = findViewById(R.id.drawer_layout);
        findAllViews();
        giveAdvise(lux, uv, temp, hum);
    }

    private static void sleep(long millies) {
        try {
            Thread.sleep(millies);
        } catch (InterruptedException e) {
            System.out.println("Thread is interrupted");
            Thread.currentThread().interrupt();
        }
    }
    private void findAllViews(){
        u_advise = findViewById(R.id.u_advise);
        l_advise = findViewById(R.id.l_advise);
        t_advise = findViewById(R.id.t_advise);
        h_advise = findViewById(R.id.h_advise);
    }

    public void giveAdvise(int lux, int uv, int temp, int hum){
            String advise_temp = "";
            String advise_uv = "";
            String advise_lux = "";
            String advise_hum = "";

            // Condition for humidity
            if (hum < 20){
                advise_hum ="The humid is too low, you should use";
                advise_hum += "\n\t-Using Pump Sprayer: Spray the plants 2 times a day, 6 hours-gap per day";
                if (temp > 20) {
                    advise_hum += "\n\t-Put a large bucket of water inside greenhouse. The evaporation in the bucket due to the temperature will give the best humid condition for your greenhouse";
                }
            }
            if ((hum >= 20) && (hum < 60)){
                advise_hum = "This is the ideal humid for tree, you don't have to do anything because it's perfect for tree to grow right now.";
            }
            if (hum >= 60){
                advise_hum = "The humidity is high, you should:";
                advise_hum += "\n\t-Care about your watering schedule: Watering the greenhouse plant early in the morning can give the plant enough time to dry the plant’s surface before the evening. As a consequence, it helps to reduce the humidity level inside the greenhouse.";
                advise_hum += "\n\t-Weeding on a regular basis: Weed also helps to generate extra humidity by holding moisture on its leaf’s bellow part. It can also create extra humidity through its transpiration process. So regular weeding using proper weeder can help also to reduce the humidity level inside a greenhouse.";
                advise_hum += "\n\t-Use ventilation and heating: Because hot air has more capacity to hold humidity than natural or cool air. So maintaining the ventilation and heat inside a greenhouse in an optimum way we can also reduce the humidity level.";
            }
            // Condition for light
            if (lux < 900){
                advise_lux = "It's too dark for your tree. Give it extra light in order to help it grow faster";
            }
            if (lux > 900){
                advise_lux = "This is the ideal light for plant to grow perfectly. Keep holding this condition";
            }
            if (uv < 6){
                advise_uv = "The UV is safe to grow tree, you don't have to do anything because this is the ideal condition for tree to grow";
            }
            if (uv >=6){
                advise_uv = "The UV is not safe for your tree, you should";
                advise_uv += "\n\t-Using dome to shade direct sunlight to avoid UV exposure";
                advise_uv += "\n\t-Using sunglasses and sunscreen to avoid UV when take care for the tree";
            }
            if (temp >= 25){
                if (hum < 40){
                    advise_temp = "The weather is hot and dry, you should";
                    advise_temp += "\n\tTurn on the ventilation or open the window";
                    advise_temp += "\n\tPoor water for tree. Do not pour too much. Instead of pouring too much, do it less but more frequency, 1 hour per time";
                }
                advise_temp = "The weather is hot, you should turn on the ventilation or open the window";
            }
            if ((20 < temp) && (temp < 25)){
                advise_temp = "This is the ideal temperature for your greenhouse. Keep holding this condition";
            }
            if (temp <= 20){
                advise_temp = "The weather is cold for tree, you should use heat-machine in order to keep the ideal temperature between 20°C and 25°C";
            }

            u_advise.setText(advise_uv);
            t_advise.setText(advise_temp);
            h_advise.setText(advise_hum);
            l_advise.setText(advise_lux);
    }

    public void ClickMenu(View view){
        //Open drawer
        openDrawer(drawerLayout);
    }

    public void Home(View view){
        //Recreate activity
        redirectActivity(this,MainScreen.class);
    }

    public void EnvironmentData(View view){
        //Redirect activity to dashboard
        redirectActivity(this, EnvironmentData.class);
    }

    public void Advise(View view){
        //redirect activity to about us
        redirectActivity(this, Advise.class);
    }

    public void MyProfile(View view){
        //redirect activity to about us
        redirectActivity(this,MyProfileMinh.class);
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