package com.example.medrecord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminActivity extends AppCompatActivity {
    /**
     * activity initiation
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    /**
     * handler for manage button button
     * @param view
     */
    public void onManagePatientClick(View view) {
        openManagePatientActivity();
    }

    /**
     * open manage patient activity
     */
    public void openManagePatientActivity() {
        Intent intent = new Intent(this, ManagePatientActivity.class);
        startActivity(intent);
    }

    /**
     * handler for manage doctor button
     * @param view
     */
    public void onManageDoctorClick(View view) {
        openManageDoctorActivity();
    }

    /**
     * open manage doctor activity
     */
    public void openManageDoctorActivity() {
        Intent intent = new Intent(this, ManageDoctorActivity.class);
        startActivity(intent);
    }
    /**
     * Handler for navigation button
     * @return true if button is pressed
     */
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    /**
     * Save and write the current data to json file
     */

    @Override
    public void onPause() {
        super.onPause();
        Singleton_Doctor_List.getInstance().saveDoctors(this);
        Singleton_Patient_List.getInstance().savePatients(this);
    }
}