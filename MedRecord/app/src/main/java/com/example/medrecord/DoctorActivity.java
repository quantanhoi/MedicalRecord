package com.example.medrecord;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DoctorActivity extends AppCompatActivity {
    public Doctor Doc = new Doctor();
    private ListView patientList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
        patientList = findViewById(R.id.patientRecyclerView);
        ArrayList<String> patListName = new ArrayList<>();

        Doc = new Doctor("One", "Two");
        Doc.addPatient(new Patient("Jonah", "Doss"));
        Doc.addPatient(new Patient("Mike","Wazowski"));

        for(int i = 0; i < Doc.getPatientList().size(); i++) {
            patListName.add(Doc.getPatientList().get(i).getId() +" " + Doc.getPatientList().get(i).getM_firstName() + " " + Doc.getPatientList().get(i).getM_lastName());
        }
        ArrayAdapter<String> patientAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, patListName
        );
        patientList.setAdapter(patientAdapter);
        patientList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startPatientActivity();
            }
        });
    }
    public void onButtonAddPatientClick(View view) {
        Intent intent = new Intent(this, AddPatientActivity.class);
        startActivity(intent);
    }
    public void startPatientActivity() {
        Intent intent = new Intent(this, PatientActivity.class);
        startActivity(intent);
    }

}