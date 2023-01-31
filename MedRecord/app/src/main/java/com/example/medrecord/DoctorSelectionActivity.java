package com.example.medrecord;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class DoctorSelectionActivity extends AppCompatActivity implements Adapter_Doctor.DoctorItemClickListener{
    /**
     * list of doctor to select from
     */
    ArrayList<Doctor> doctorList = Singleton_Doctor_List.getInstance().getDoctorsList();
    /**
     * name of selected doctor
     */
    String doctorName;

    /**
     * activity initiation
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_selection);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        RecyclerView doctorListRV = findViewById(R.id.AllDoctorsView);
        doctorListRV.setLayoutManager(new LinearLayoutManager(this));
        doctorListRV.setAdapter(new Adapter_Doctor(getApplicationContext(), doctorList, this));

    }


//    public void onDoctorClick(View view){
//        TextView tv = (TextView) view;
//        doctorName = tv.getText().toString();
//
//    }

    /**
     * Handler for every doctor in recycle view
     * @param position
     */
    @Override
    public void onDoctorClick(int position) {
        doctorName = doctorList.get(position).getLastName() + ", " + doctorList.get(position).getFirstName();
        Intent intent = new Intent(this, DoctorActivity.class);
        intent.putExtra("doctorName", doctorName);
        startActivity(intent);
    }
    /**
     * Handler for navigation button
     * @return true if button is pressed
     */
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    /**
     * Save and write the current data to json file
     */

    @Override
    public void onPause() {
        super.onPause();
        Singleton_Doctor_List.getInstance().saveDoctors(this);
        Singleton_Patient_List.getInstance().savePatients(this);
    }

}