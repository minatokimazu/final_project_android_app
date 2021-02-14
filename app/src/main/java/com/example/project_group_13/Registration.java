package com.example.project_group_13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Registration extends AppCompatActivity {

    public ImageView goTypes;
    public ImageView goPayment;
    EditText firstName, lastName, email, areCode, phone, address, city, state, zipCode, month, day ,year;
    CheckBox friend, web, article;
    FirebaseAuth auth;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        firstName = findViewById(R.id.editTextTextPersonName);
        lastName = findViewById(R.id.editTextTextPersonName2);
        email = findViewById(R.id.editTextTextEmailAddress);
        areCode = findViewById(R.id.editTextPhone);
        phone = findViewById(R.id.editTextPhone2);
        city = findViewById(R.id.editTextTextAddress2);
        state = findViewById(R.id.editTextTextAddress3);
        zipCode = findViewById(R.id.editTextTextPostalAddress);
        month = findViewById(R.id.editTextDate);
        day = findViewById(R.id.editTextDate2);
        year = findViewById(R.id.editTextDate3);
        friend = findViewById(R.id.checkBox);
        web = findViewById(R.id.checkBox2);
        article = findViewById(R.id.checkBox3);
        address = findViewById(R.id.editTextTextAddress);
        auth = FirebaseAuth.getInstance();


        goTypes = (ImageView) findViewById(R.id.circleMid1);
        goTypes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String m_firstName = firstName.getText().toString();
                String m_lastName = lastName.getText().toString();
                String m_email = email.getText().toString();
                String m_areCode = areCode.getText().toString();
                String m_phone =  phone.getText().toString();
                String m_address =  address .getText().toString();
                String m_city = city.getText().toString();
                String m_state = state.getText().toString();
                String m_zipCode = zipCode.getText().toString();
                String m_month = month.getText().toString();
                String m_day = day.getText().toString();
                String m_year = year.getText().toString();

                if (TextUtils.isEmpty(m_firstName)) {
                    firstName.setError("FirstName is Required");
                    return;
                }
                if (TextUtils.isEmpty(m_lastName)) {
                    lastName.setError("lastName is Required");
                    return;
                }
                if (TextUtils.isEmpty(m_email)) {
                    email.setError("Email is Required");
                    return;
                }
                if (TextUtils.isEmpty(m_areCode)) {
                    areCode.setError("areCode is Required");
                    return;
                }
                if (TextUtils.isEmpty(m_phone)) {
                    phone.setError("phone is Required");
                    return;
                }
                if (TextUtils.isEmpty(m_address)) {
                    address.setError("address is Required");
                    return;
                }
                if (TextUtils.isEmpty(m_city)) {
                    city.setError("city is Required");
                    return;
                }
                if (TextUtils.isEmpty(m_state)) {
                    state.setError("state is Required");
                    return;
                }
                if (TextUtils.isEmpty(m_zipCode)) {
                    zipCode.setError("zipCode is Required");
                    return;
                }
                if (TextUtils.isEmpty(m_month)) {
                    month.setError("month is Required");
                    return;
                }
                if (TextUtils.isEmpty(m_day)) {
                    day.setError("Day is Required");
                    return;
                }
                if (TextUtils.isEmpty(m_year)) {
                    year.setError("Year is Required");
                    return;
                }

                FirebaseDatabase.getInstance().getReference().child("RegistrationMembership").push().child("First Name").setValue(m_firstName);
                FirebaseDatabase.getInstance().getReference().child("RegistrationMembership").push().child("Last Name").setValue(m_lastName);
                FirebaseDatabase.getInstance().getReference().child("RegistrationMembership").push().child("Email").setValue(m_email);
                FirebaseDatabase.getInstance().getReference().child("RegistrationMembership").push().child("Area-Code").setValue(m_areCode);
                FirebaseDatabase.getInstance().getReference().child("RegistrationMembership").push().child("Phone Number").setValue(m_phone);
                FirebaseDatabase.getInstance().getReference().child("RegistrationMembership").push().child("Address").setValue(m_address);
                FirebaseDatabase.getInstance().getReference().child("RegistrationMembership").push().child("City").setValue(m_city);
                FirebaseDatabase.getInstance().getReference().child("RegistrationMembership").push().child("State/Province").setValue(m_state);
                FirebaseDatabase.getInstance().getReference().child("RegistrationMembership").push().child("ZipCode/Postal Code").setValue(m_zipCode);
                FirebaseDatabase.getInstance().getReference().child("RegistrationMembership").push().child("Month").setValue(m_month);
                FirebaseDatabase.getInstance().getReference().child("RegistrationMembership").push().child("Da").setValue(m_day);
                FirebaseDatabase.getInstance().getReference().child("RegistrationMembership").push().child("Year").setValue(m_year);
                Intent intent = new Intent(Registration.this,Types.class);
                startActivity(intent);
            }
        });

        goPayment = (ImageView) findViewById(R.id.circleRight1);
        goPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String m_firstName = firstName.getText().toString();
                String m_lastName = lastName.getText().toString();
                String m_email = email.getText().toString();
                String m_areCode = areCode.getText().toString();
                String m_phone =  phone.getText().toString();
                String m_address =  address .getText().toString();
                String m_city = city.getText().toString();
                String m_state = state.getText().toString();
                String m_zipCode = zipCode.getText().toString();
                String m_month = month.getText().toString();
                String m_day = day.getText().toString();
                String m_year = year.getText().toString();

                if (TextUtils.isEmpty(m_firstName)) {
                    firstName.setError("FirstName is Required");
                    return;
                }
                if (TextUtils.isEmpty(m_lastName)) {
                    lastName.setError("lastName is Required");
                    return;
                }
                if (TextUtils.isEmpty(m_email)) {
                    email.setError("Email is Required");
                    return;
                }
                if (TextUtils.isEmpty(m_areCode)) {
                    areCode.setError("areCode is Required");
                    return;
                }
                if (TextUtils.isEmpty(m_phone)) {
                    phone.setError("phone is Required");
                    return;
                }
                if (TextUtils.isEmpty(m_address)) {
                    address.setError("address is Required");
                    return;
                }
                if (TextUtils.isEmpty(m_city)) {
                    city.setError("city is Required");
                    return;
                }
                if (TextUtils.isEmpty(m_state)) {
                    state.setError("state is Required");
                    return;
                }
                if (TextUtils.isEmpty(m_zipCode)) {
                    zipCode.setError("zipCode is Required");
                    return;
                }
                if (TextUtils.isEmpty(m_month)) {
                    month.setError("month is Required");
                    return;
                }
                if (TextUtils.isEmpty(m_day)) {
                    day.setError("Day is Required");
                    return;
                }
                if (TextUtils.isEmpty(m_year)) {
                    year.setError("Year is Required");
                    return;
                }
                FirebaseDatabase.getInstance().getReference().child("RegistrationMembership").push().child("First Name").setValue(m_firstName);
                FirebaseDatabase.getInstance().getReference().child("RegistrationMembership").push().child("Last Name").setValue(m_lastName);
                FirebaseDatabase.getInstance().getReference().child("RegistrationMembership").push().child("Email").setValue(m_email);
                FirebaseDatabase.getInstance().getReference().child("RegistrationMembership").push().child("Area-Code").setValue(m_areCode);
                FirebaseDatabase.getInstance().getReference().child("RegistrationMembership").push().child("Phone Number").setValue(m_phone);
                FirebaseDatabase.getInstance().getReference().child("RegistrationMembership").push().child("Address").setValue(m_address);
                FirebaseDatabase.getInstance().getReference().child("RegistrationMembership").push().child("City").setValue(m_city);
                FirebaseDatabase.getInstance().getReference().child("RegistrationMembership").push().child("State/Province").setValue(m_state);
                FirebaseDatabase.getInstance().getReference().child("RegistrationMembership").push().child("ZipCode/Postal Code").setValue(m_zipCode);
                FirebaseDatabase.getInstance().getReference().child("RegistrationMembership").push().child("Month").setValue(m_month);
                FirebaseDatabase.getInstance().getReference().child("RegistrationMembership").push().child("Da").setValue(m_day);
                FirebaseDatabase.getInstance().getReference().child("RegistrationMembership").push().child("Year").setValue(m_year);
                Intent intent = new Intent(Registration.this,Payment.class);
                startActivity(intent);
            }
        });
    }
}