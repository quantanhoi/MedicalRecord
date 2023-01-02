package com.example.medrecord;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class ViewHolder_Doctor extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView imageView;
    TextView nameView, idView;
    public ViewHolder_Doctor(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.doctorImage);
        nameView = itemView.findViewById(R.id.doctorName);
        idView = itemView.findViewById(R.id.doctorID);
        itemView.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        int position = getAdapterPosition();
        Adapter_Doctor.mOnClickListener.onDoctorClick(position);
    }
}
