package com.example.medrecord;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter_AdminRemovesPatient extends RecyclerView.Adapter<ViewHolder_AdminRemovesPatient>{
    List<Patient> mPatients;
    Doctor doctor;
    Admin_Removes_Patient_Activity activity;

    public Adapter_AdminRemovesPatient(List<Patient> mPatients, Admin_Removes_Patient_Activity activity) {
        this.mPatients = mPatients;
        this.activity = activity;
    }

    public ViewHolder_AddPatientsForDoctor getVh() {
        return vh;
    }

    ViewHolder_AddPatientsForDoctor vh;
    @NonNull
    @Override
    public ViewHolder_AdminRemovesPatient onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder_AdminRemovesPatient(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_admin_removes_patient,parent,false)
                ,mPatients.get(viewType));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder_AdminRemovesPatient holder, int position) {
        holder.patientNameView.setText(mPatients.get(position).getName());
        holder.patientIDView.setText("ID: " + mPatients.get(position).getId());
        holder.buttonView.setOnClickListener(view -> {
            holder.onClick(mPatients.get(position));
            //mPatients.remove(position);
            notifyItemRemoved(position);
            activity.refreshRecyclerView();
        });
    }

    @Override
    public int getItemCount() {
        return mPatients.size();
    }
}
