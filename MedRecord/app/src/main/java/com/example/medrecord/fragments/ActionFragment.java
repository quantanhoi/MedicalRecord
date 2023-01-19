package com.example.medrecord.fragments;

import android.annotation.SuppressLint;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.medrecord.Doctor;
import com.example.medrecord.Patient;
import com.example.medrecord.R;
import com.example.medrecord.Singleton_Doctor_List;
import com.example.medrecord.Singleton_Labor;
import com.example.medrecord.Singleton_Patient_List;

import java.util.ArrayList;
import java.util.Objects;

public class ActionFragment extends Fragment {

    Button saveChanges;
    CheckBox sendToLab, release, transfer;
    Patient patient;
    public ActionFragment(Patient pat){
        this.patient = pat;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_action, container, false);
        saveChanges = view.findViewById(R.id.save_changes_button);
        sendToLab = view.findViewById(R.id.send_to_lab);
        transfer = view.findViewById(R.id.transfer_to_selection);

        if(patient.isToLab()) {
            sendToLab.setEnabled(false);
            sendToLab.setChecked(true);
        }

        release = view.findViewById(R.id.release);
        saveChanges.setOnClickListener(view1 -> {
            if(transfer.isChecked()){
                Toast.makeText(getContext(),"Patients shall be transferred", Toast.LENGTH_SHORT).show();
                Doctor hausarzt = Singleton_Doctor_List.getInstance().getDoctorById(patient.getPersonalDoctorId());
                hausarzt.removePatientFromList(patient);
                patient.setPersonalDoctorId(0);
                requireActivity().finish();
            }
            if (release.isChecked()){
                Toast.makeText(getContext(),"Patients shall be removed", Toast.LENGTH_SHORT).show();
                Doctor hausarzt = Singleton_Doctor_List.getInstance().getDoctorById(patient.getPersonalDoctorId());
                hausarzt.removePatientFromList(patient);
                Singleton_Patient_List.getInstance().getPatientsList().remove(patient);
                requireActivity().finish();
            }
            if(sendToLab.isChecked()){
                if (patient.isToLab()) {
                    sendToLab.setEnabled(false);
                }
                else {
                    sendToLab.setEnabled(true);
                    patient.setToLab(true);
                    sendToLab.setEnabled(false);
                }
            }
            else{
                sendToLab.setEnabled(true);
                patient.setToLab(true);
            }
            Toast.makeText(getContext(),"Changes saved", Toast.LENGTH_SHORT).show();
            refreshMyFragment();
        });
        // Inflate the layout for this fragment
        return view;
    }
    public void refreshMyFragment() {
        FragmentTransaction ft = requireActivity().getSupportFragmentManager().beginTransaction();
        ft.detach(this).attach(this).commit();

    }

}