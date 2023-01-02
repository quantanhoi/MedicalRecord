package com.example.medrecord;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter_Doctor_Manages_Patient extends RecyclerView.Adapter<ViewHolder_Doctor_Manages_Patients>{
    Context context;
    List<Patient> mPatients;
    interface PatientItemClickListener{
        void onPatientClick(int position);
    }
    static PatientItemClickListener mOnClickListener;

    public Adapter_Doctor_Manages_Patient(Context context, List<Patient> mPatients, PatientItemClickListener mOnClickListener) {
        this.context = context;
        this.mPatients = mPatients;
        Adapter_Doctor_Manages_Patient.mOnClickListener = mOnClickListener;
    }

    @NonNull
    @Override
    public ViewHolder_Doctor_Manages_Patients onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder_Doctor_Manages_Patients(LayoutInflater.from(context).inflate(R.layout.item_doctor_manages_patient,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder_Doctor_Manages_Patients holder, int position) {
        holder.patIDView.setText("ID: " + mPatients.get(position).getId());
        holder.patNameView.setText(mPatients.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mPatients.size();
    }
}
