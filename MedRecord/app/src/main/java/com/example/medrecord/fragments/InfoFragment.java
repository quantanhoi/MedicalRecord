package com.example.medrecord.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.medrecord.Patient;
import com.example.medrecord.R;

public class InfoFragment extends Fragment {

    ImageView patImg;
    Patient patient;
    public InfoFragment(Patient pat){
        this.patient = pat;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        patImg = view.findViewById(R.id.imageView3);
        if (patient != null && patient.getImage() != 0) {
            patImg.setImageResource(patient.getImage());
        } else {
            patImg.setImageResource(R.drawable.p1);
        }
        return view;
    }
}