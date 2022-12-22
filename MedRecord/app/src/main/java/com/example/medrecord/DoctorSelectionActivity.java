package com.example.medrecord;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class DoctorSelectionActivity extends AppCompatActivity {
    RecyclerView doctorListRV;
    ArrayList<Doctor> doctorList;

    String doctorName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_selection);
        doctorListRV = findViewById(R.id.AllDoctorsView);
        doctorList = Singleton_Doctor_List.getInstance().getDoctorsList();
        DoctorAdapter adapter = new DoctorAdapter(doctorList);
        doctorListRV.setAdapter(adapter);
        doctorListRV.setLayoutManager(new LinearLayoutManager(this));

        //doctorListRV.setOnContextClickListener();

    }


    public void onDoctorClick(View view){
        TextView tv = (TextView) view;
        doctorName = tv.getText().toString();
        Intent intent = new Intent(this, DoctorActivity.class);
        intent.putExtra("doctorName", doctorName);
        //startActivityForResult(intent, 1);
        startActivity(intent);
    }
}