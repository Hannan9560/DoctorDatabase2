package net.a6te.lazycoder.doctordatabase;

/**
 * Created by Mobile App Develop on 4/5/2017.
 */

public class Doctors {
    private String doctorName;
    private  String doctorDetails;
    private String doctorPhone;
    private String doctorEmail;
    private int doctorId;

    public Doctors(String doctorName, String doctorDetails, String doctorPhone, String doctorEmail) {
        this.doctorName = doctorName;
        this.doctorDetails = doctorDetails;
        this.doctorPhone = doctorPhone;
        this.doctorEmail = doctorEmail;
    }

    public Doctors(String doctorName, String doctorDetails, String doctorPhone, String doctorEmail, int doctorId) {
        this.doctorName = doctorName;
        this.doctorDetails = doctorDetails;
        this.doctorPhone = doctorPhone;
        this.doctorEmail = doctorEmail;
        this.doctorId = doctorId;
    }

    public Doctors() {
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorDetails() {
        return doctorDetails;
    }

    public void setDoctorDetails(String doctorDetails) {
        this.doctorDetails = doctorDetails;
    }

    public String getDoctorPhone() {
        return doctorPhone;
    }

    public void setDoctorPhone(String doctorPhone) {
        this.doctorPhone = doctorPhone;
    }

    public String getDoctorEmail() {
        return doctorEmail;
    }

    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }
}
