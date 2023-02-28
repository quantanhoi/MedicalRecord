package com.example.medrecord;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ManagePatientActivity extends AppCompatActivity implements  Adapter_Patient.PatientItemClickListener{
    /**
     * list view of all patient in singleton list
     */
    private ListView patientList;
    /**
     * swipe action to refesh
     */
    private SwipeRefreshLayout swipeRefreshLayout;
    /**
     * activity initiation
     * @param savedInstanceState
     */
    ArrayList<Patient> PatientList = Singleton_Patient_List.getInstance().getPatientsList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_patient);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        ArrayList<String> patListName = new ArrayList<>();
        RecyclerView PatientListRV = findViewById(R.id.AllPatientView);
        PatientListRV.setLayoutManager(new LinearLayoutManager(this));
        PatientListRV.setAdapter(new Adapter_Patient(getApplicationContext(), PatientList, this));
        swipeRefreshLayout = findViewById(R.id.swiperefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                recreate();
                //setRefreshing to false to stop action
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    /**
     * handler for add patient button
     * @param view
     */
    public void addPatientClick(View view) {
        Intent intent = new Intent(this, AddPatientActivity.class);
//        startActivityForResult(intent, requestCode);
        startActivity(intent);
    }
    /**
     * handler for delete patient button
     * @param view
     */
    public void deletePatientClick(View view){
        Intent intent = new Intent(this, Admin_Removes_Patient_Activity.class);
        startActivity(intent);
    }

    /**
     * start patient activity
     */
    public void startPatientActivity() {
        Intent intent = new Intent(this, PatientActivity.class);
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
    @Override
    public void onPatientClick(int position) {
        String patientName = PatientList.get(position).getName();
        Intent intent = new Intent(this, Lab_Diagnose_Patient_Activity.class);
        intent.putExtra("patientName", patientName);
        startActivity(intent);
    }
}