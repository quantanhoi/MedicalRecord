package com.example.medrecord;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AddPatientForDoctorActivity extends AppCompatActivity {
    RecyclerView patientToAddRV;
    ArrayList<Patient> patients;
    ArrayList<Doctor> docs;
    Doctor theDoc;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient_for_doctor);
        patientToAddRV = findViewById(R.id.toAddPatientList);
        patients = Singleton_Patient_List.getInstance().getPatientsList();
        docs = Singleton_Doctor_List.getInstance().getDoctorsList();

        PatientAdapter adapter = new PatientAdapter(patients);
        patientToAddRV.setAdapter(adapter);
        patientToAddRV.setLayoutManager(new LinearLayoutManager(this));

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String doctorName = extras.getString("doctor");

            for (Doctor d: docs){
                if(Objects.equals(d.getName(), doctorName)){
                    theDoc = d;
                }
            }
        }
    }
    public void onAddButtonClick(View view){
        TextView tv = findViewById(R.id.patientName);
        String patientName = tv.getText().toString();

        for(Patient p : patients){
            if(Objects.equals(p.getName(), patientName)){
                theDoc.addPatient(p);
            }
        }
    }

}



