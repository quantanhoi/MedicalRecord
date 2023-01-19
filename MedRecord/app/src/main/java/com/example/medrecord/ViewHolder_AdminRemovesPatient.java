package com.example.medrecord;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder_AdminRemovesPatient extends RecyclerView.ViewHolder implements View.OnClickListener{
    TextView patientNameView, patientIDView;
    Button buttonView;
    private Patient patient;
    private Adapter_AddPatientForDoctor adapter;

    public ViewHolder_AdminRemovesPatient(@NonNull View itemView, Patient patient) {
        super(itemView);
        patientNameView = itemView.findViewById(R.id.patientName_toRemove);
        patientIDView = itemView.findViewById(R.id.patientID_toRemove);
        buttonView = itemView.findViewById(R.id.delete_button_toRemove);
        this.patient = patient;
    }


    public void onClick(Patient patient) {
        Doctor doctor = Singleton_Doctor_List.getInstance().getDoctorById(patient.getPersonalDoctorId());
        if(doctor != null )doctor.removePatientFromList(patient);
        patient.setPersonalDoctorId(0);
        Singleton_Patient_List.getInstance().getPatientsList().remove(patient);
        Toast.makeText(buttonView.getContext(), "Patient deleted successfully", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View view) {
        {
            Doctor doctor = Singleton_Doctor_List.getInstance().getDoctorById(patient.getPersonalDoctorId());
            if(doctor != null )doctor.removePatientFromList(patient);
            Toast.makeText(view.getContext(), "Patient added to doctor", Toast.LENGTH_SHORT).show();
        }
    }
}
