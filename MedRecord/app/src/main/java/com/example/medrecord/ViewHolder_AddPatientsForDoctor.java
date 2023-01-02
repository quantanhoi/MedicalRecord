package com.example.medrecord;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

public class ViewHolder_AddPatientsForDoctor extends RecyclerView.ViewHolder {
    TextView patientNameView, patientIDView;
    Button buttonView;

    private Adapter_AddPatientForDoctor adapter;
    public ViewHolder_AddPatientsForDoctor linkAdapter (Adapter_AddPatientForDoctor adapter){
        this.adapter = adapter;
        return this;
    }
    public ViewHolder_AddPatientsForDoctor(@NonNull View itemView) {
        super(itemView);
        patientNameView = itemView.findViewById(R.id.patientName);
        patientIDView = itemView.findViewById(R.id.patientID);


    }



}
