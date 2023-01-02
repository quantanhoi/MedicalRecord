package com.example.medrecord;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder_Doctor_Manages_Patients extends RecyclerView.ViewHolder implements View.OnClickListener{
    TextView patNameView, patIDView;
    public ViewHolder_Doctor_Manages_Patients(@NonNull View itemView) {
        super(itemView);
        patNameView = itemView.findViewById(R.id._patientName);
        patIDView = itemView.findViewById(R.id._patientID);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int position = getAdapterPosition();

    }
}
