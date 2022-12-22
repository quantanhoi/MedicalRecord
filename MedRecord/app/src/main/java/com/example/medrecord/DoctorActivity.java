package com.example.medrecord;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Objects;

public class DoctorActivity extends AppCompatActivity {
    public Doctor Doc = new Doctor();
    private RecyclerView patientList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
        patientList = findViewById(R.id.addedPatientView);
        ArrayList<String> patListName = new ArrayList<>();

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String doctorName = extras.getString("doctorName");
            ArrayList<Doctor>doctorList = Singleton_Doctor_List.getInstance().getDoctorsList();

            for (Doctor d: doctorList){
                if(Objects.equals(d.getName(), doctorName)){
                    Doc = d;
                }
            }
        }

//        Doc = new Doctor("One", "Two");
//        Doc.addPatient(new Patient("Jonah", "Doss"));
//        Doc.addPatient(new Patient("Mike","Wazowski"));

        for(int i = 0; i < Doc.getPatientList().size(); i++) {
            patListName.add(Doc.getPatientList().get(i).getId() +" " + Doc.getPatientList().get(i).getM_firstName() + " " + Doc.getPatientList().get(i).getM_lastName());
        }
        ArrayAdapter<String> patientAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, patListName
        );
        PatientAdapter p_adap = new PatientAdapter(Doc.getPatientList());
        patientList.setAdapter(p_adap);
        patientList.setLayoutManager(new LinearLayoutManager(this));
//        patientList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                startPatientActivity();
//            }
//        });


    }
    public void onButtonAddPatientClick(View view) {
        Intent intent = new Intent(this, AddPatientForDoctorActivity.class);
        intent.putExtra("doctor", Doc.getName());
        startActivity(intent);
    }
    public void startPatientActivity() {
        Intent intent = new Intent(this, PatientActivity.class);

        startActivity(intent);
    }

}