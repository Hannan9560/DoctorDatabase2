package net.a6te.lazycoder.doctordatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class DoctorViewActivity extends AppCompatActivity {

    private ListView doctorList;
    private DoctorAdapter doctorAdapter;
    private ArrayList<Doctors>doctorses;
    private DoctorDataBase doctorDataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_view);
        doctorList = (ListView) findViewById(R.id.doctorList);
        doctorses = new ArrayList<>();
        doctorDataBase = new DoctorDataBase(this);
        doctorses = doctorDataBase.getAllDoctors();
        doctorAdapter = new DoctorAdapter(this, doctorses);
        doctorList.setAdapter(doctorAdapter);
    }
}
