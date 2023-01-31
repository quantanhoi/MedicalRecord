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
    /**
     * @brief List of patients of the doctor
     */
    List<Patient> mPatients;
    /**
     * @brief the chosen/logged in doctor
     */
    Doctor doctor;
    AddPatientForDoctorActivity activity;

    /**
     *
     * @return View holder for Recycle View
     */
    public ViewHolder_AddPatientsForDoctor getVh() {
        return vh;
    }

    ViewHolder_AddPatientsForDoctor vh;

    /**
     * setting adapter
     * @param mPatients Patient data
     * @param doctor Doctor Data
     * @param activity
     */
    public Adapter_AddPatientForDoctor(List<Patient> mPatients, Doctor doctor, AddPatientForDoctorActivity activity) {
        this.mPatients = mPatients;
        this.doctor = doctor;
        this.activity = activity;
    }

    /**
     *
     * @param parent parent of the view holder
     * @param viewType
     * @return View holder
     */
    @NonNull
    @Override
    public ViewHolder_AddPatientsForDoctor onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        vh = new ViewHolder_AddPatientsForDoctor(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_add_patient,parent,false),
                doctor, mPatients.get(viewType));
        return vh;
    }

    /**
     * bind View holder to recycle view
     * @param holder holder of recycle view
     * @param position according to the data structure
     */
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

    /**
     *
     * @return show all the patients in the list to the recycle view
     */
    @Override
    public int getItemCount() {
        return mPatients.size();
    }
}
