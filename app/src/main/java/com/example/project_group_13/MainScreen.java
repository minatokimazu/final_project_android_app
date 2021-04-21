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

public class MainScreen extends AppCompatActivity {
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);

        drawerLayout = findViewById(R.id.drawer_layout);
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

    public void ManualSetup(View view){
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