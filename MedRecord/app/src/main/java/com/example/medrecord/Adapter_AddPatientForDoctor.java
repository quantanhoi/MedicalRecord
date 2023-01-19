package com.example.medrecord;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter_AddPatientForDoctor extends RecyclerView.Adapter<ViewHolder_AddPatientsForDoctor> {
    List<Patient> mPatients;
    Doctor doctor;
    AddPatientForDoctorActivity activity;

    public ViewHolder_AddPatientsForDoctor getVh() {
        return vh;
    }

    ViewHolder_AddPatientsForDoctor vh;

    public Adapter_AddPatientForDoctor(List<Patient> mPatients, Doctor doctor, AddPatientForDoctorActivity activity) {
        this.mPatients = mPatients;
        this.doctor = doctor;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder_AddPatientsForDoctor onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        vh = new ViewHolder_AddPatientsForDoctor(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_add_patient,parent,false),
                doctor, mPatients.get(viewType));
        return vh;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder_AddPatientsForDoctor holder, @SuppressLint("RecyclerView") int position) {
        holder.patientNameView.setText(mPatients.get(position).getName());
        holder.patientIDView.setText("ID: " + mPatients.get(position).getId());
        holder.buttonView.setOnClickListener(view -> {
            holder.onClick(mPatients.get(position));
            mPatients.remove(position);
            notifyItemRemoved(position);
            activity.refreshRecyclerView();
        });

    }

    @Override
    public int getItemCount() {
        return mPatients.size();
    }
}
