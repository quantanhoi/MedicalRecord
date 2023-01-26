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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

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
        String patientName = patientList.get(position).getName();
        Intent intent = new Intent(this, Lab_Diagnose_Patient_Activity.class);
        intent.putExtra("patientName", patientName);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // update the data in the RecyclerView
        patientList = theLab.getmPatients();
        patientListRV.setAdapter(new Adapter_Patient(getApplicationContext(),patientList,this));
        patientListRV.getAdapter().notifyDataSetChanged();
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