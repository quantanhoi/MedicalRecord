package com.example.medrecord;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.medrecord.fragments.ActionFragment;
import com.example.medrecord.fragments.InfoFragment;
import com.example.medrecord.fragments.MedicalHistoryFragment;

public class Adapter_MyViewPager extends FragmentStateAdapter {
    Patient patient;
    public Adapter_MyViewPager(@NonNull FragmentActivity fragmentActivity, Patient pat) {
        super(fragmentActivity);
        this.patient = pat;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new MedicalHistoryFragment();
            case 2:
                return new ActionFragment(patient);
            default:
                return new InfoFragment(patient);
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
