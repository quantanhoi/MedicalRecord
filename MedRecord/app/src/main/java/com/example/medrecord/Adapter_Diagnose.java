package com.example.medrecord;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter_Diagnose extends RecyclerView.Adapter<ViewHolder_Diagnose> {
    Context context;
    List<Diagnose> mDiagnose;

    public Adapter_Diagnose(Context context, List<Diagnose> mDiagnose, DiagnoseItemClickListener mOnClickListener) {
        this.context = context;
        this.mDiagnose = mDiagnose;
        Adapter_Diagnose.mOnClickListener = mOnClickListener;
    }

    public interface DiagnoseItemClickListener{
        void onDiagnoseClick(int position);
    }
    public static DiagnoseItemClickListener mOnClickListener;
    @NonNull
    @Override
    public ViewHolder_Diagnose onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder_Diagnose viewHolder_diagnose = new ViewHolder_Diagnose(LayoutInflater.from(context).inflate(R.layout.item_diagnose,parent,false));
        return viewHolder_diagnose;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder_Diagnose holder, int position) {
        holder.dateOfDiagnose.setText(mDiagnose.get(position).date);
        Patient patientOfDiagnose = Singleton_Patient_List.getInstance().findPatientByID(mDiagnose.get(position).patientID);
        Doctor doctorOfPatient = Singleton_Doctor_List.getInstance().getDoctorById(patientOfDiagnose.getPersonalDoctorId());
        holder.nameOfDoctor.setText(doctorOfPatient.getName());
    }

    @Override
    public int getItemCount() {
        return mDiagnose.size();
    }
}
