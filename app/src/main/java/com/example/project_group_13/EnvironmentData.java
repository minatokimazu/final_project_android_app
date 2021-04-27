package com.example.project_group_13;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EnvironmentData extends AppCompatActivity {
    private ProgressBar pg_temp;
    private ProgressBar pg_light;
    private ProgressBar pg_hum;
    private ProgressBar pg_uv;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    public String date;
    DataStructure mData;
    public static int temdata,humdata,uvdata,luxdata;
    private TextView temperature, humidity, uv, timestamp, lux;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_environment_data);
        drawerLayout = findViewById(R.id.drawer_layout);
            getDatabase();
            findAllViews();
            retrieveData();
    }
    private void findAllViews(){
        uv = findViewById(R.id.uv);
        lux = findViewById(R.id.lux);
        temperature = findViewById(R.id.temperature);
        humidity = findViewById(R.id.humidity);
        timestamp = findViewById(R.id.timestamp);
    }

    private void getDatabase(){
        // TODO: Find the reference form the database.
        database = FirebaseDatabase.getInstance();
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        String path = "userdata/" + mAuth.getUid();  // read from the user account.
        myRef = database.getReference(path);
    }

    public void retrieveData(){
        // TODO: Get the data on a single node.
        myRef.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                DataStructure ds = dataSnapshot.getValue(DataStructure.class);
                lux.setText(ds.getLight() + "lux");
                temperature.setText(ds.getTemperature() + "℃");
                humidity.setText(ds.getHumidity() + "%");
                uv.setText(ds.getUV() + "index");

                // Convert from timestamp to Date and time
                timestamp.setText(convertTimestamp(Long.toString(ds.getTimestamp())));

                // Take value to make advise
                temdata = (int) ds.getTemperature();
                humdata = (int) ds.getHumidity();
                luxdata = (int) ds.getLight();
                uvdata = (int) ds.getUV();

                //Make a progressBar
                pg_temp = (ProgressBar)findViewById(R.id.pgtem);
                pg_temp.setProgress((int) ds.getTemperature());

                pg_light = (ProgressBar)findViewById(R.id.pglux);
                pg_light.setProgress((int) ds.getLight());

                pg_hum = (ProgressBar)findViewById(R.id.pghum);
                pg_hum.setProgress((int) ds.getHumidity());

                pg_uv = (ProgressBar)findViewById(R.id.pguv);
                pg_uv.setProgress((int) ds.getUV());
            }

            private String convertTimestamp(String timestamp){

                long yourSeconds = Long.valueOf(timestamp);
                Date mDate = new Date(yourSeconds * 1000);
                DateFormat df = new SimpleDateFormat("dd MMM yyyy HH:mm:ss aa");
                return df.format(mDate);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                DataStructure ds = dataSnapshot.getValue(DataStructure.class);
                lux.setText("Light: "+ ds.getLight());
                temperature.setText("Temperature: "+ds.getTemperature());
                humidity.setText("Humidity: " + ds.getHumidity());
                uv.setText("UV: " + ds.getUV());

                // Convert from timestamps to Date and time
                date = convertTimestamp(Long.toString(ds.getTimestamp()));
                timestamp.setText(date);
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        // TODO: Get the whole data array on a reference.
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<DataStructure> arraylist= new ArrayList<DataStructure>();

                // TODO: Now data is retrieved, needs to process data.
                if (dataSnapshot != null && dataSnapshot.getValue() != null) {

                    // iterate all the items in the dataSnapshot
                    for (DataSnapshot a : dataSnapshot.getChildren()) {
                        DataStructure dataStructure = new DataStructure();
                        dataStructure.setLight(a.getValue(DataStructure.class).getLight());
                        dataStructure.setTemperature(a.getValue(DataStructure.class).getTemperature());
                        dataStructure.setHumidity(a.getValue(DataStructure.class).getHumidity());
                        dataStructure.setUV(a.getValue(DataStructure.class).getUV());
                        dataStructure.setTimestamp(a.getValue(DataStructure.class).getTimestamp());

                        arraylist.add(dataStructure);  // now all the data is in arraylist.
                        Log.d("GreenLight", "dataStructure " + dataStructure.getTimestamp());
                    }
                }else
                {
                    Toast.makeText(getApplicationContext(), getString(R.string.data_unavailable), Toast.LENGTH_LONG).show();
                }

            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Getting data failed, log a message
                Log.d("GreenLight", "Data Loading Canceled/Failed.", databaseError.toException());
            }
        });
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