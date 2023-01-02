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

public class DoctorActivity extends AppCompatActivity implements Adapter_Doctor_Manages_Patient.PatientItemClickListener{
    public static Doctor Doc ;
    ArrayList<Patient> patientList;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

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

        RecyclerView patientListRV = findViewById(R.id.addedPatientView);
        patientListRV.setLayoutManager(new LinearLayoutManager(this));
        patientListRV.setAdapter(new Adapter_Doctor_Manages_Patient(getApplicationContext(),patientList,this));


        findViewById(R.id.add_patient_button).setOnClickListener(view -> {
            Intent intent = new Intent(this, AddPatientForDoctorActivity.class);
            intent.putExtra("doctor", Doc.getName());
            startActivity(intent);
        });

//        findViewById(R.id.add_button).setOnClickListener(view ->{
//            //Doc.addPatient(patientList[pos]);
//        });
        Log.d("TAG", "so far: ");

//        ArrayList<String> patListName = new ArrayList<>();
//        for(int i = 0; i < Doc.getPatientList().size(); i++) {
//            patListName.add(Doc.getPatientList().get(i).getId() +" " + Doc.getPatientList().get(i).getM_firstName() + " " + Doc.getPatientList().get(i).getM_lastName());
//        }


    }

    public void onAddPatientClick(View view) {
        Intent intent = new Intent(this, AddPatientForDoctorActivity.class);
        intent.putExtra("doctor", Doc.getName());
        startActivity(intent);
    }





    @Override
    public void onPatientClick(int position) {
        String patientName = patientList.get(position).getName();
        Intent intent = new Intent(this, DoctorActivity.class);
        intent.putExtra("doctorName", patientName);
        startActivity(intent);
    }
}