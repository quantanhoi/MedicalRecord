package com.example.medrecord;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter_AddPatientForDoctor extends RecyclerView.Adapter<ViewHolder_AddPatientsForDoctor> {
    List<Patient> mPatients;

    public Button getB() {
        return b;
    }

    Button b;

    public ViewHolder_AddPatientsForDoctor getVh() {
        return vh;
    }

    ViewHolder_AddPatientsForDoctor vh;

    public Adapter_AddPatientForDoctor(List<Patient> mPatients) {
        this.mPatients = mPatients;
    }

    @NonNull
    @Override
    public ViewHolder_AddPatientsForDoctor onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        vh = new ViewHolder_AddPatientsForDoctor(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_add_patient,parent,false));
        return vh;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder_AddPatientsForDoctor holder, int position) {
        holder.patientNameView.setText(mPatients.get(position).getName());
        holder.patientIDView.setText("ID: " + mPatients.get(position).getId());
        b = holder.buttonView;
//        holder.buttonView.setOnClickListener(view -> {
//
//            Intent intent = new Intent(this, AddPatientForDoctorActivity.class);
//            intent.putExtra("doctor", AddPatientForDoctorActivity.theDoc.getName());
//            startActivity(intent);
//        });
    }

    @Override
    public int getItemCount() {
        return mPatients.size();
    }
}
