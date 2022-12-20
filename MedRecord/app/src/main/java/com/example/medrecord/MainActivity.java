package com.example.medrecord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onButtonDoctorClick(View view) {
        openDoctorActivity();
    }
    public void openDoctorActivity() {
        Intent intent = new Intent(this, DoctorActivity.class);
        startActivity(intent);
    }
    public void onButtonAdminClick(View view) {
        openAdminActivity();
    }
    public void openAdminActivity() {
        Intent intent = new Intent(this, AdminActivity.class);
        startActivity(intent);
    }

}