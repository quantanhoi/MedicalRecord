package com.example.medrecord;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class DoctorSelectionActivity extends AppCompatActivity {
    RecyclerView doctorListRV;
    ArrayList<Doctor> doctorList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_selection);
        doctorListRV = findViewById(R.id.AllDoctorsView);
        doctorList = Singleton_Doctor_List.getInstance().getDoctorsList();
        DoctorAdapter adapter = new DoctorAdapter(doctorList);
        doctorListRV.setAdapter(adapter);
        doctorListRV.setLayoutManager(new LinearLayoutManager(this));

    }


    public void onClick(View view){
        Intent intent = new Intent(this, DoctorActivity.class);
        startActivity(intent);
    }
}