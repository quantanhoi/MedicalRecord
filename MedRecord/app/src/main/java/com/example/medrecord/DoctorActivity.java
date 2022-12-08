package com.example.medrecord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DoctorActivity extends AppCompatActivity {
    public static Doctor Doc = new Doctor();
    private ListView patientList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
        patientList = findViewById(R.id.patientListView);
        ArrayAdapter<Patient> patientAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, Doc.getPatientList()
        );
        patientList.setAdapter(patientAdapter);
    }
    public void onButtonAddPatientClick(View view) {
        Intent intent = new Intent(this, AddPatientActivity.class);
        startActivity(intent);
    }
}