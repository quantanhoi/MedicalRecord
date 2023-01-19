package com.example.medrecord.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.medrecord.Adapter_Diagnose;
import com.example.medrecord.Adapter_Doctor;
import com.example.medrecord.Adapter_Doctor_Manages_Patient;
import com.example.medrecord.Diagnose_Manage_Activity;
import com.example.medrecord.Doctor_Manages_Patient_Activity;
import com.example.medrecord.Patient;
import com.example.medrecord.R;


public class MedicalHistoryFragment extends Fragment implements Adapter_Diagnose.DiagnoseItemClickListener{


    RecyclerView diagnoseRV;
    Patient patient;
    public MedicalHistoryFragment(Patient pat){
        patient = pat;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        diagnoseRV = view.findViewById(R.id.MedicalHistoryView);
        diagnoseRV.setLayoutManager(new LinearLayoutManager(getActivity()));
        diagnoseRV.setAdapter(new Adapter_Diagnose(getActivity(), patient.getMedicalHistory(), this));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_medical_history, container, false);
    }


    @Override
    public void onDiagnoseClick(int position) {
        String diagnoseDate = patient.getMedicalHistory().get(position).getDate();

        Intent intent = new Intent(getActivity(), Diagnose_Manage_Activity.class);
        intent.putExtra("diagnoseDate", diagnoseDate);
        intent.putExtra("patientID", patient.getId());
        startActivity(intent);
    }
    @Override
    public void onResume() {
        super.onResume();
        diagnoseRV.setAdapter(new Adapter_Diagnose(getActivity(), patient.getMedicalHistory(), this));
        diagnoseRV.getAdapter().notifyDataSetChanged();
    }
}