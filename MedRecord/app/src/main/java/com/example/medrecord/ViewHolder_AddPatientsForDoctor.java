package com.example.medrecord;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

public class ViewHolder_AddPatientsForDoctor extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView patientNameView, patientIDView;
    Button buttonView;
    private Doctor doctor;
    private Patient patient;
    private Adapter_AddPatientForDoctor adapter;

    public ViewHolder_AddPatientsForDoctor(@NonNull View itemView, Doctor doctor, Patient patient) {
        super(itemView);
        patientNameView = itemView.findViewById(R.id.patientName);
        patientIDView = itemView.findViewById(R.id.patientID);
        buttonView = itemView.findViewById(R.id.add_button);
        this.doctor = doctor;
        this.patient = patient;
    }


    public void onClick(Patient patient) {
        doctor.addPatient(patient);
        patient.setPersonalDoctorId(doctor.getDocID());
        Toast.makeText(buttonView.getContext(), "Patient added successfully", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View view) {
         {
            doctor.addPatient(patient);
            Toast.makeText(view.getContext(), "Patient added to doctor", Toast.LENGTH_SHORT).show();
        }
    }
}
