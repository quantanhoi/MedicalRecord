package com.example.medrecord;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder_Diagnose extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView dateOfDiagnose, nameOfDoctor;
    public ViewHolder_Diagnose(@NonNull View itemView) {
        super(itemView);
        dateOfDiagnose = itemView.findViewById(R.id.dateOfDiagnose);
        nameOfDoctor = itemView.findViewById(R.id.orderedByDoctor);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int position = getAdapterPosition();
        Adapter_Diagnose.mOnClickListener.onDiagnoseClick(position);
    }
}
