package net.a6te.lazycoder.doctordatabase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mobile App Develop on 4/5/2017.
 */

public class DoctorAdapter extends ArrayAdapter<Doctors> {
    private Context context;
    private ArrayList<Doctors> doctorses;

    public DoctorAdapter(Context context, ArrayList<Doctors> doctorses) {
        super(context, R.layout.doctor_layout, doctorses);
        this.context = context;
        this.doctorses = doctorses;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.doctor_layout, parent, false);

        TextView name = (TextView) convertView.findViewById(R.id.doctorName);
        TextView details = (TextView) convertView.findViewById(R.id.doctorDetails);
        TextView phone = (TextView) convertView.findViewById(R.id.doctorPhone);
        TextView email = (TextView) convertView.findViewById(R.id.doctorEmail);

        name.setText(doctorses.get(position).getDoctorName());
        details.setText(doctorses.get(position).getDoctorDetails());
        phone.setText(doctorses.get(position).getDoctorPhone());
        email.setText(doctorses.get(position).getDoctorEmail());



        return convertView;
    }
}
