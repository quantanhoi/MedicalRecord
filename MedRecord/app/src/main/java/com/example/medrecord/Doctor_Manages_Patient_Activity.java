package com.example.medrecord;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Objects;

public class Doctor_Manages_Patient_Activity extends AppCompatActivity {

    /**
     * selected Doctor
     */
    static Doctor theDoc;
    /**
     * selected Patient
     */
    static Patient thePatient;


    TabLayout tabLayout;
    ViewPager2 viewPager2;
    Adapter_MyViewPager myViewPagerAdapter;
    /**
     * activity initiation
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_manages_patient);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String doctorName = extras.getString("doctorName");
            String patientName = extras.getString("patientName");
            ArrayList<Doctor> doctorList = Singleton_Doctor_List.getInstance().getDoctorsList();


            for (Doctor d: doctorList){
                if(Objects.equals(d.getName(), doctorName)){
                    theDoc = d;
                    break;
                }
            }
            ArrayList<Patient> patientsList = theDoc.getPatientList();
            for (Patient p: patientsList){
                if(Objects.equals(p.getName(), patientName)){
                    thePatient = p;
                    break;
                }
            }
        }

        tabLayout = findViewById(R.id.doctorManagePatient_TabLayout);
        viewPager2 = findViewById(R.id.doctorManagesPatient_ViewPager);
        myViewPagerAdapter = new Adapter_MyViewPager(this, thePatient);
        viewPager2.setAdapter(myViewPagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });
    }
    /**
     * Handler for navigation button
     * @return true if button is pressed
     */

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    /**
     * Save and write the current data to json file
     */

    @Override
    public void onPause() {
        super.onPause();
        Singleton_Doctor_List.getInstance().saveDoctors(this);
        Singleton_Patient_List.getInstance().savePatients(this);
    }
}