package com.example.medrecord;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.medrecord.fragments.ActionFragment;
import com.example.medrecord.fragments.InfoFragment;
import com.example.medrecord.fragments.MedicalHistoryFragment;

public class Adapter_MyViewPager extends FragmentStateAdapter {
    public Adapter_MyViewPager(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new InfoFragment();
            case 1:
                return new MedicalHistoryFragment();
            case 2:
                return new ActionFragment();
            default:
                return new InfoFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
