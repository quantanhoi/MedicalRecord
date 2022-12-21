package com.example.medrecord;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView doctorLastName;
        public TextView doctorFirstName;
        public ViewHolder(View itemView){
            super(itemView);
            doctorLastName = (TextView) itemView.findViewById(R.id.doctorLastName);
            doctorFirstName = (TextView)  itemView.findViewById(R.id.doctorFirstName);

        }
    }
    private List<Doctor> mDoctors;
    public DoctorAdapter(List<Doctor> docs){
        mDoctors = docs;
    }

    @Override
    public DoctorAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int ViewType){
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View doctorView = inflater.inflate(R.layout.item_doctor, parent, false);

        ViewHolder viewHolder = new ViewHolder(doctorView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DoctorAdapter.ViewHolder holder, int position){
        Doctor doctor = mDoctors.get(position);

        TextView firstNameView = holder.doctorFirstName;
        TextView lastNameView = holder.doctorLastName;

        firstNameView.setText(doctor.getFirstName());
        lastNameView.setText(doctor.getLastName());
    }

    @Override
    public  int getItemCount(){
        return mDoctors.size();
    }
}
