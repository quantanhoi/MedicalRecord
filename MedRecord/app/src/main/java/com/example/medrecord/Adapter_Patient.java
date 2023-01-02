package com.example.medrecord;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter_Patient extends RecyclerView.Adapter<Adapter_Patient.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView patientName;
        public Button addButton;
        public ViewHolder(View itemView) {
            super(itemView);
            patientName = (TextView) itemView.findViewById(R.id.patientName);
            addButton = itemView.findViewById((R.id.add_button));
        }
    }

    private List<Patient> mPatients;

    public Adapter_Patient(List<Patient> pats) {
        mPatients = pats;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int ViewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View patView = inflater.inflate(R.layout.item_add_patient, parent, false);

        ViewHolder viewHolder = new ViewHolder(patView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Patient patient = mPatients.get(position);

        TextView nameView = holder.patientName;


        nameView.setText(patient.getName());

    }

    @Override
    public int getItemCount() {
        return mPatients.size();
    }
}
