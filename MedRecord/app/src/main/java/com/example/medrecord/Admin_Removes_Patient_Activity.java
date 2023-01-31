package com.example.medrecord;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Objects;

public class Admin_Removes_Patient_Activity extends AppCompatActivity {
    /**
     * list of patient that can be removed
     */
    RecyclerView patientToRemoveRV;
    /**
     * adapter for recycle view
     */
    Adapter_AdminRemovesPatient adapter;
    /**
     * singleton list of patients
     */
    ArrayList<Patient> patients;
    /**s
     * singleton list of doctor
     */
    ArrayList<Doctor> docs;

    /**
     * activity initiation
     * @param savedInstanceState
     */
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_removes_patient);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        patientToRemoveRV = findViewById(R.id.patientList_toRemove);
        patients = Singleton_Patient_List.getInstance().getPatientsList();
        docs = Singleton_Doctor_List.getInstance().getDoctorsList();

        patientToRemoveRV.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter_AdminRemovesPatient(patients,this);
        patientToRemoveRV.setAdapter(adapter);

    }

    /**
     * removing the patient from singleton list
     * @param view
     */
    public void onSearchClickToRemove (View view) {
        EditText patientNameSearch = findViewById(R.id.inputPatientName_toRemove);
        String text = patientNameSearch.getText().toString();
        if(text == "") {
            adapter = new Adapter_AdminRemovesPatient(patients,this);
            patientToRemoveRV.setAdapter(adapter);
            return;
        }
        ArrayList<Patient> tempPatientList = new ArrayList<>();
        for(Patient p : Singleton_Patient_List.getInstance().getPatientsList()) {
            if(p.getM_firstName().contains(text) || p.getM_lastName().contains(text)) {
                tempPatientList.add(p);
            }
        }
        adapter = new Adapter_AdminRemovesPatient(tempPatientList, this);
        patientToRemoveRV.setAdapter(adapter);
    }

    /**
     * refresh recycle view after removing patient
     */
    public void refreshRecyclerView(){
        patients = Singleton_Patient_List.getInstance().getAvailablePatients();
        patientToRemoveRV.setAdapter(new Adapter_AdminRemovesPatient(patients,this));
        patientToRemoveRV.getAdapter().notifyDataSetChanged();
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