package com.example.medrecord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Objects;

public class ManageDoctorIndividualActivity extends AppCompatActivity {
    public static Doctor Doc ;
    public static int DocID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_doctor_individual);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String doctorName = extras.getString("doctorName");
            ArrayList<Doctor> doctorList = Singleton_Doctor_List.getInstance().getDoctorsList();

            for (Doctor d: doctorList){
                if(Objects.equals(d.getName(), doctorName)){
                    Doc = d;
                    break;
                }
            }
        }
    }
    public void onEditInformationClick(View view) {
        Intent intent = new Intent(this, ManageDoctorInvidivdualEditActivity.class);
        DocID = Doc.getDocID();
        intent.putExtra("doctorID", DocID);
        startActivity(intent);
    }
    public void onRemoveDoctorClick(View view){
        int DoctorID = Doc.getDocID();
        int index = -1;
        ArrayList<Doctor> doctorList = Singleton_Doctor_List.getInstance().getDoctorsList();
        for(int i = 0; i < doctorList.size(); i++) {
            if(DoctorID == doctorList.get(i).getDocID()) {
                index = i;
                break;
            }
        }
        Singleton_Doctor_List.getInstance().removeDoctor(index);

    }

}