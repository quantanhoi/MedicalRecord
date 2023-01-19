package com.example.medrecord;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class ManageDoctorActivity extends AppCompatActivity implements Adapter_Doctor.DoctorItemClickListener {
    ArrayList<Doctor> doctorList = Singleton_Doctor_List.getInstance().getDoctorsList();
    String doctorName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_doctor);
        RecyclerView doctorListRV = findViewById(R.id.AllDoctorsView);
        doctorListRV.setLayoutManager(new LinearLayoutManager(this));
        doctorListRV.setAdapter(new Adapter_Doctor(getApplicationContext(), doctorList, this));
    }
    @Override
    public void onDoctorClick(int position) {
        doctorName = doctorList.get(position).getLastName() + ", " + doctorList.get(position).getFirstName();
        //TODO: change this to another activity
        Intent intent = new Intent(this, ManageDoctorIndividualActivity.class);
        intent.putExtra("doctorName", doctorName);
        startActivity(intent);

    }
    public void addDoctorClick(View view){
        Intent intent = new Intent(this, AddDoctorActivity.class);
        startActivity(intent);
    }

}