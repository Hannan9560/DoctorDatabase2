package net.a6te.lazycoder.doctordatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Mobile App Develop on 4/5/2017.
 */

public class DoctorDataBase {
    private DoctorDatabaseHelper doctorDatabaseHelper;
    private SQLiteDatabase sqLiteDatabase;
    private Doctors doctors;

    public DoctorDataBase(Context context) {
        doctorDatabaseHelper = new DoctorDatabaseHelper(context);
    }
    public void open()
    {
        sqLiteDatabase = doctorDatabaseHelper.getWritableDatabase();
    }
    public void close()
    {
        sqLiteDatabase.close();
    }

    public boolean addDoctor(Doctors doctors)
    {
        this.open();
        ContentValues values = new ContentValues();
        values.put(DoctorDatabaseHelper.COL_DOCTORNAME,doctors.getDoctorName());
        values.put(DoctorDatabaseHelper.COL_DOCTORDETAILS,doctors.getDoctorDetails());
        values.put(DoctorDatabaseHelper.COL_DOCTORPHONE,doctors.getDoctorPhone());
        values.put(DoctorDatabaseHelper.COL_DOCTOREMAIL,doctors.getDoctorEmail());
       long id =  sqLiteDatabase.insert(DoctorDatabaseHelper.DOCTOR_TABLE, null, values);
        this.close();
        if(id > 0)
        {
            return true;
        }
        else {
            return false;
        }
    }

    public ArrayList<Doctors> getAllDoctors()
    {
        ArrayList<Doctors>doctorses = new ArrayList<>();
        this.open();
        Cursor cursor = sqLiteDatabase.query(DoctorDatabaseHelper.DOCTOR_TABLE,null,null, null, null, null,null);
        cursor.moveToFirst();
        if(cursor != null && cursor.getCount() > 0)
        {
            for(int i = 0; i < cursor.getCount(); i++)
            {
                int id = cursor.getInt(cursor.getColumnIndex(DoctorDatabaseHelper.COL_ID));
                String name = cursor.getString(cursor.getColumnIndex(DoctorDatabaseHelper.COL_DOCTORNAME));
                String details = cursor.getString(cursor.getColumnIndex(DoctorDatabaseHelper.COL_DOCTORDETAILS));
                String phone = cursor.getString(cursor.getColumnIndex(DoctorDatabaseHelper.COL_DOCTORPHONE));
                String email = cursor.getString(cursor.getColumnIndex(DoctorDatabaseHelper.COL_DOCTOREMAIL));

                doctorses.add(new Doctors(name, details, phone, email, id));
                cursor.moveToNext();
            }
        }
        cursor.close();
        this.close();
        return doctorses;
    }
}
