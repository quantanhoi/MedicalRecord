package com.example.medrecord;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ManagePatientActivity extends AppCompatActivity {
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_patient);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        patientList = findViewById(R.id.patientRecyclerView);
        ArrayList<String> patListName = new ArrayList<>();

        for(int i = 0; i < Singleton_Patient_List.getInstance().getPatientsList().size(); i++) {
            patListName.add(Singleton_Patient_List.getInstance().getPatientsList().get(i).getM_firstName());
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
}