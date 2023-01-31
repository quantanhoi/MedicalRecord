package com.example.medrecord;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class ManageDoctorActivity extends AppCompatActivity implements Adapter_Doctor.DoctorItemClickListener {
    /**
     * list of all doctor
     */
    ArrayList<Doctor> doctorList = Singleton_Doctor_List.getInstance().getDoctorsList();
    /**
     * selected doctor's name
     */
    String doctorName;
    /**
     * activity initiation
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_doctor);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        RecyclerView doctorListRV = findViewById(R.id.AllDoctorsView);
        doctorListRV.setLayoutManager(new LinearLayoutManager(this));
        doctorListRV.setAdapter(new Adapter_Doctor(getApplicationContext(), doctorList, this));
    }
    /**
     * Handler for Doctor button
     * @param position of the doctor in the recycle view list
     */
    @Override
    public void onDoctorClick(int position) {
        doctorName = doctorList.get(position).getLastName() + ", " + doctorList.get(position).getFirstName();
        //TODO: change this to another activity
        Intent intent = new Intent(this, ManageDoctorIndividualActivity.class);
        intent.putExtra("doctorName", doctorName);
        startActivity(intent);

    }
    /**
     * Handler for adding Doctor button
     * @param view
     */
    public void addDoctorClick(View view){
        Intent intent = new Intent(this, AddDoctorActivity.class);
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