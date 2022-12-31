package com.example.medrecord;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class DoctorSelectionActivity extends AppCompatActivity implements DoctorAdapter.DoctorItemClickListener{

    ArrayList<Doctor> doctorList = Singleton_Doctor_List.getInstance().getDoctorsList();

    String doctorName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_selection);

        RecyclerView doctorListRV = findViewById(R.id.AllDoctorsView);
        doctorListRV.setLayoutManager(new LinearLayoutManager(this));
        doctorListRV.setAdapter(new DoctorAdapter(getApplicationContext(), doctorList, this));

    }


//    public void onDoctorClick(View view){
//        TextView tv = (TextView) view;
//        doctorName = tv.getText().toString();
//
//    }

    @Override
    public void onDoctorClick(int position) {
        doctorName = doctorList.get(position).getLastName() + ", " + doctorList.get(position).getFirstName();
        Intent intent = new Intent(this, DoctorActivity.class);
        intent.putExtra("doctorName", doctorName);
        startActivity(intent);
    }
}