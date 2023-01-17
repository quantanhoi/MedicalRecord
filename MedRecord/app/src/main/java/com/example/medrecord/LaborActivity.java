package com.example.medrecord;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class LaborActivity extends AppCompatActivity implements  Adapter_Patient.PatientItemClickListener{
    private Singleton_Labor theLab ;
    ArrayList<Patient> patientList;
    RecyclerView patientListRV;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labor);

        theLab = Singleton_Labor.getLabor();
        patientList = theLab.getmPatients();

        patientListRV = findViewById(R.id.patients_labor);
        patientListRV.setLayoutManager(new LinearLayoutManager(this));
        patientListRV.setAdapter(new Adapter_Patient(getApplicationContext(),patientList,this));


//        findViewById(R.id.add_patient_button).setOnClickListener(view -> {
//            Intent intent = new Intent(this, AddPatientForDoctorActivity.class);
//            intent.putExtra("doctor", Doc.getName());
//            startActivity(intent);
//        });
    }

    @Override
    public void onPatientClick(int position) {

    }
}