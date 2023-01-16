package com.example.medrecord;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter_Patient extends RecyclerView.Adapter<ViewHolder_Patient> {
    Context context;
    List<Patient> mPatients;

    public Adapter_Patient(Context context, List<Patient> mPatients, PatientItemClickListener mOnClickListener) {
        this.context = context;
        this.mPatients = mPatients;
        Adapter_Patient.mOnClickListener = mOnClickListener;
    }

    interface PatientItemClickListener{
        void onPatientClick(int position);
    }
    static PatientItemClickListener mOnClickListener;
    @NonNull
    @Override
    public ViewHolder_Patient onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder_Patient(LayoutInflater.from(context).inflate(R.layout.item_patient,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder_Patient holder, int position) {
        holder.patientNameView.setText(mPatients.get(position).getName());
        holder.patientPictureView.setImageResource(mPatients.get(position).getImage());
        holder.patientIDView.setText("ID: " + mPatients.get(position).getId());
    }

    @Override
    public int getItemCount() {
        return mPatients.size();
    }
}
