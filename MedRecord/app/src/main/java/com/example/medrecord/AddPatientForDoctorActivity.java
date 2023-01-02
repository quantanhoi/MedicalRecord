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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class AddPatientForDoctorActivity extends AppCompatActivity {
    RecyclerView patientToAddRV;
    ArrayList<Patient> patients;
    ArrayList<Doctor> docs;
    static Doctor theDoc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient_for_doctor);
        patientToAddRV = findViewById(R.id.toAddPatientList);
        patients = Singleton_Patient_List.getInstance().getPatientsList();
        docs = Singleton_Doctor_List.getInstance().getDoctorsList();

        //Adapter_AddPatientForDoctor adapter = new Adapter_AddPatientForDoctor(patients);
        patientToAddRV.setLayoutManager(new LinearLayoutManager(this));
        Adapter_AddPatientForDoctor adapter = new Adapter_AddPatientForDoctor(patients);
        patientToAddRV.setAdapter(adapter);
//        adapter.getB().setOnClickListener(view -> {
//            theDoc.addPatient(patients.get(adapter.getVh().getAdapterPosition()));
//            Toast.makeText(this,"Patient added", Toast.LENGTH_SHORT);
//        });

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

    }

}



