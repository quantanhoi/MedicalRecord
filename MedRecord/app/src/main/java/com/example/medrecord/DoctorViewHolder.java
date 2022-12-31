package com.example.medrecord;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class DoctorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView imageView;
    TextView nameView;
    public DoctorViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.doctorImage);
        nameView = itemView.findViewById(R.id.doctorName);
        itemView.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        int position = getAdapterPosition();
        DoctorAdapter.mOnClickListener.onDoctorClick(position);
    }
}
