import java.util.*;
import java.time.*;
import java.time.format.*;

public class Doctor {
    // Attributes
    private String firstName;
    private String lastName;
    private String specialty;
    private String phoneNumber;
    private String doctorID;
    private String emailAddress;
    private int experienceYears;
    private String department;
    private double consultationFee;


    // Availability schedule
    private List<String> availability;
    // List to store booked appointments
    private List<Appointment> appointments;

   
    public Doctor() {
        this.firstName = "";
        this.lastName = "";
        this.specialty = "";
        this.phoneNumber = "";
        this.doctorID = "";
        this.emailAddress = "";
        this.experienceYears = 0;
        this.department = "";
        this.consultationFee = 0.0;
        this.availability = new ArrayList<>();
        this.appointments = new ArrayList<>();
    }

    //constructor
    public Doctor(String firstName, String lastName, String specialty, String phoneNumber, String doctorID, String emailAddress, int experienceYears, String department, double consultationFee, List<String> availability) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
        this.phoneNumber = phoneNumber;
        this.doctorID = doctorID;
        this.emailAddress = emailAddress;
        this.experienceYears = experienceYears;
        this.department = department;
        this.consultationFee = consultationFee;
        this.availability = availability;
        // Initialize the appointments list
        this.appointments = new ArrayList<>();
    }


    //setters and getters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

//Other methods
    public void printDetails() {
        System.out.println("Doctor Details:");
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Specialty: " + specialty);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Doctor ID: " + doctorID);
        System.out.println("Email Address: " + emailAddress);
        System.out.println("Experience Years: " + experienceYears);
        System.out.println("Department: " + department);
        System.out.println("Consultation Fee: $" + consultationFee);

        // Print availability schedule
        System.out.println("Availability:");
        for (String availabilitySlot : availability) {
            System.out.println("- " + availabilitySlot);
        }
    }




}
