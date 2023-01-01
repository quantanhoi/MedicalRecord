package com.example.medrecord;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorViewHolder> {

    Context context;
    List<Doctor> mDoctors;
    interface DoctorItemClickListener{
        void onDoctorClick(int position);
    }
    static DoctorItemClickListener mOnClickListener;

    public DoctorAdapter(Context context, List<Doctor> mDoctors, DoctorItemClickListener mOnClickListener) {
        this.context = context;
        this.mDoctors = mDoctors;
        DoctorAdapter.mOnClickListener = mOnClickListener;
    }

    @NonNull
    @Override
    public DoctorViewHolder onCreateViewHolder(ViewGroup parent, int ViewType){
//        Context context = parent.getContext();
//        LayoutInflater inflater = LayoutInflater.from(context);
//
//        View doctorView = inflater.inflate(R.layout.item_doctor, parent, false);
//
//        ViewHolder viewHolder = new ViewHolder(doctorView);

        return new DoctorViewHolder(LayoutInflater.from(context).inflate(R.layout.item_doctor,parent,false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(DoctorViewHolder holder, int position){
        //Doctor doctor = mDoctors.get(position);

        //TextView nameView = holder.doctorName;

        holder.nameView.setText(mDoctors.get(position).getLastName() + ", " + mDoctors.get(position).getFirstName());
        holder.imageView.setImageResource(mDoctors.get(position).getImage());
        holder.idView.setText("ID: " + mDoctors.get(position).getDocID());

    }

    @Override
    public int getItemCount(){
        return mDoctors.size();
    }


}
