package com.example.medrecord;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class AddPatientForDoctorActivity extends AppCompatActivity {
    /**
     * list of patient that is able be added to doctor's patient list
     */
    RecyclerView patientToAddRV;
    /**
     * Adapter for recycle view
     */
    Adapter_AddPatientForDoctor adapter;
    /**
     * List of singleton patients
     */
    ArrayList<Patient> patients;
    /**
     * List of singleton doctors
     */
    ArrayList<Doctor> docs;
    /**
     * the chosen/logged in doctor
     */
    static Doctor theDoc;


    /**
     * activity initiation
     * @param savedInstanceState
     */
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient_for_doctor);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        patientToAddRV = findViewById(R.id.toAddPatientList);
        patients = Singleton_Patient_List.getInstance().getAvailablePatients();
        docs = Singleton_Doctor_List.getInstance().getDoctorsList();

        //Adapter_AddPatientForDoctor adapter = new Adapter_AddPatientForDoctor(patients);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String doctorName = extras.getString("doctor");

            for (Doctor d: docs){
                if(Objects.equals(d.getName(), doctorName)){
                    theDoc = d;
                }
            }
        }
        patientToAddRV.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter_AddPatientForDoctor(patients, theDoc,this);
        patientToAddRV.setAdapter(adapter);

    }

    /**
     * Handler for patient searching button
     * @param view
     */
    public void onSearchClick (View view) {
        EditText patientNameSearch = findViewById(R.id.editTextTextPersonName);
        String text = patientNameSearch.getText().toString();
        if(text == "") {
            adapter = new Adapter_AddPatientForDoctor(patients, theDoc,this);
            patientToAddRV.setAdapter(adapter);
            return;
        }
        ArrayList<Patient> tempPatientList = new ArrayList<>();
        for(Patient p : Singleton_Patient_List.getInstance().getPatientsList()) {
            if(p.getM_firstName().contains(text) || p.getM_lastName().contains(text)) {
                tempPatientList.add(p);
            }
        }
        adapter = new Adapter_AddPatientForDoctor(tempPatientList, theDoc, this);
        patientToAddRV.setAdapter(adapter);
    }

    /**
     * Refresh the recycle view after adding new patient to the list
     */
    public void refreshRecyclerView(){
        patients = Singleton_Patient_List.getInstance().getAvailablePatients();
        patientToAddRV.setAdapter(new Adapter_AddPatientForDoctor(patients, theDoc,this));
        patientToAddRV.getAdapter().notifyDataSetChanged();
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



