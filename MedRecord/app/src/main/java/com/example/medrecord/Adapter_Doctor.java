package com.example.medrecord;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter_Doctor extends RecyclerView.Adapter<ViewHolder_Doctor> {

    Context context;
    List<Doctor> mDoctors;
    interface DoctorItemClickListener{
        void onDoctorClick(int position);
    }
    static DoctorItemClickListener mOnClickListener;

    public Adapter_Doctor(Context context, List<Doctor> mDoctors, DoctorItemClickListener mOnClickListener) {
        this.context = context;
        this.mDoctors = mDoctors;
        Adapter_Doctor.mOnClickListener = mOnClickListener;
    }

    @NonNull
    @Override
    public ViewHolder_Doctor onCreateViewHolder(ViewGroup parent, int ViewType){
        return new ViewHolder_Doctor(LayoutInflater.from(context).inflate(R.layout.item_doctor,parent,false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder_Doctor holder, int position){


        holder.nameView.setText(mDoctors.get(position).getLastName() + ", " + mDoctors.get(position).getFirstName());
        holder.imageView.setImageResource(mDoctors.get(position).getImage());
        holder.idView.setText("ID: " + mDoctors.get(position).getDocID());

    }

    @Override
    public int getItemCount(){
        return mDoctors.size();
    }


}
