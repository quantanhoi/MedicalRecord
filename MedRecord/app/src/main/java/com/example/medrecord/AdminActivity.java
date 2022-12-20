package com.example.medrecord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }
    public void onManagePatientClick(View view) {
        openManagePatientActivity();
    }
    public void openManagePatientActivity() {
        Intent intent = new Intent(this, ManagePatientActivity.class);
        startActivity(intent);
    }
    public void onManageDoctorClick() {

    }
    public void openManageDoctorActivity() {

    }
}