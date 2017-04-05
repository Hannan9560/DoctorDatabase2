package net.a6te.lazycoder.doctordatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Mobile App Develop on 4/5/2017.
 */

public class DoctorDatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Doctor Database";
    public static final int DATABASE_VERSION = 1;
    public DoctorDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public static final String DOCTOR_TABLE = "tbl_doctor";
    public static final String COL_ID = "tbl_id";
    public static final String COL_DOCTORNAME = "tbl_doctor_name";
    public static final String COL_DOCTORDETAILS = "tbl_doctor_details";
    public static final String COL_DOCTORPHONE = "tbl_doctor_phone";
    public static final String COL_DOCTOREMAIL = "tbl_doctor_email";

    public static final String CREATE_TABLE_DOCTOR = "create table "+DOCTOR_TABLE+"("+
            COL_ID+" integer primary key, "+
            COL_DOCTORNAME+" text, "+
            COL_DOCTORDETAILS+" text, "+
            COL_DOCTORPHONE+" text, "+
            COL_DOCTOREMAIL+" text);";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_DOCTOR);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    db.execSQL("drop table if exists "+DOCTOR_TABLE);
        onCreate(db);

    }
}
