package com.example.medrecord;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder_Patient extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView patientPictureView;
    TextView patientNameView, patientIDView;
    public ViewHolder_Patient(@NonNull View itemView) {
        super(itemView);
        patientPictureView = itemView.findViewById(R.id.patientImage_Labor);
        patientNameView = itemView.findViewById(R.id.patientName_Labor);
        patientIDView = itemView.findViewById(R.id.patientID_Labor);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int position = getAdapterPosition();
    }
}
