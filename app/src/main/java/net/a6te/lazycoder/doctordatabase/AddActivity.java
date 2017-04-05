package net.a6te.lazycoder.doctordatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    private EditText doctorName;
    private EditText doctorDetails;
    private EditText doctorPhone;
    private EditText doctorEmail;

    private int rowId;
    private String name;
    private String details;
    private String phone;
    private  String email;

    private DoctorDataBase doctorDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        doctorName = (EditText) findViewById(R.id.doctorNameET);
        doctorDetails = (EditText) findViewById(R.id.doctorDetailsET);
        doctorPhone = (EditText) findViewById(R.id.doctorPhoneET);
        doctorEmail = (EditText) findViewById(R.id.doctorEmailET);

        doctorDataBase = new DoctorDataBase(this);

        rowId = getIntent().getIntExtra("id", 0);
        name = getIntent().getStringExtra("name");
        details = getIntent().getStringExtra("details");
        phone = getIntent().getStringExtra("phone");
        email = getIntent().getStringExtra("email");

        doctorName.setText(name);
        doctorDetails.setText(details);
        doctorPhone.setText(phone);
        doctorEmail.setText(email);



    }

    public void addDoctor(View view) {
        String name = doctorName.getText().toString();
        String details = doctorDetails.getText().toString();
        String phone = doctorPhone.getText().toString();
        String email = doctorEmail.getText().toString();

        if(name.isEmpty()){
            doctorName.setError(getString(R.string.empty_field_msg));
        }else if(details.isEmpty()){
            doctorDetails.setError(getString(R.string.empty_field_msg));
        }
        else if(details.isEmpty()){
            doctorPhone.setError(getString(R.string.empty_field_msg));
        }
        else if(details.isEmpty()){
            doctorEmail.setError(getString(R.string.empty_field_msg));
        }
        else{
            Doctors doctors = new Doctors(name,details, phone, email);
            boolean status = doctorDataBase.addDoctor(doctors);
            if(status){
                Toast.makeText(this, "Successfull", Toast.LENGTH_SHORT).show();
                doctorName.setText("");
                doctorDetails.setText("");
                doctorPhone.setText("");
                doctorEmail.setText("");
            }else{
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
            }

        }
    }

    public void viewDoctor(View view) {
        startActivity(new Intent(AddActivity.this, DoctorViewActivity.class));
    }
}
