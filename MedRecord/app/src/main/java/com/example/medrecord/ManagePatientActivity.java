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
    private ListView patientList;
    private SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_patient);
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
    public void addPatientClick(View view) {
        Intent intent = new Intent(this, AddPatientActivity.class);
//        startActivityForResult(intent, requestCode);
        startActivity(intent);
    }
    public void deletePatientClick(View view){
        Intent intent = new Intent(this, Admin_Removes_Patient_Activity.class);
        startActivity(intent);
    }
    public void startPatientActivity() {
        Intent intent = new Intent(this, PatientActivity.class);
        startActivity(intent);
    }
}