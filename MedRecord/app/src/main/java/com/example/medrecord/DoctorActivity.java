package com.example.medrecord;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Activity wrap for the doctor
 */
public class DoctorActivity extends AppCompatActivity implements Adapter_Doctor_Manages_Patient.PatientItemClickListener{
    /**
     * selected doctor
     */
    public static Doctor Doc ;
    /**
     * patient list of selected doctor
     */
    ArrayList<Patient> patientList;
    /**
     * Recycle View for patient list
     */
    RecyclerView patientListRV;


    @SuppressLint("MissingInflatedId")
    /**
     * activity initiation
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        //transfer doctor name to this activity
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String doctorName = extras.getString("doctorName");
            ArrayList<Doctor>doctorList = Singleton_Doctor_List.getInstance().getDoctorsList();

            for (Doctor d: doctorList){
                if(Objects.equals(d.getName(), doctorName)){
                    Doc = d;
                    break;
                }
            }
        }

        patientList = Doc.getPatientList();

        patientListRV = findViewById(R.id.addedPatientView);
        patientListRV.setLayoutManager(new LinearLayoutManager(this));
        patientListRV.setAdapter(new Adapter_Doctor_Manages_Patient(getApplicationContext(),patientList,this));


        findViewById(R.id.add_patient_button).setOnClickListener(view -> {
            Intent intent = new Intent(this, AddPatientForDoctorActivity.class);
            intent.putExtra("doctor", Doc.getName());
            startActivity(intent);
        });



    }

    /**
     * Handler for every Patient in the list
     * @param position
     */

    @Override
    public void onPatientClick(int position) {
        String patientName = patientList.get(position).getName();
        String doctorName = Doc.getName();

        Intent intent = new Intent(this, Doctor_Manages_Patient_Activity.class);
        intent.putExtra("patientName", patientName);
        intent.putExtra("doctorName", doctorName);
        startActivity(intent);
    }

    /**
     * update the data in the recycle view
     */
    @Override
    protected void onResume() {
        super.onResume();
        // update the data in the RecyclerView
        patientList = Doc.getPatientList();
        patientListRV.setAdapter(new Adapter_Doctor_Manages_Patient(getApplicationContext(),patientList,this));
        patientListRV.getAdapter().notifyDataSetChanged();
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