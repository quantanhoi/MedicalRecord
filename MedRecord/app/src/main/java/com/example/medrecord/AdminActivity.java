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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    public void onManagePatientClick(View view) {
        openManagePatientActivity();
    }
    public void openManagePatientActivity() {
        Intent intent = new Intent(this, ManagePatientActivity.class);
        startActivity(intent);
    }
    public void onManageDoctorClick(View view) {
        openManageDoctorActivity();
    }
    public void openManageDoctorActivity() {
        Intent intent = new Intent(this, ManageDoctorActivity.class);
        startActivity(intent);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onPause() {
        super.onPause();
        Singleton_Doctor_List.getInstance().saveDoctors(this);
        Singleton_Patient_List.getInstance().savePatients(this);
    }
}