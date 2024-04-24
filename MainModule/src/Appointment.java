import java.util.*;
import java.time.*;
import java.time.format.*;

public class Appointment {
    private LocalDateTime date;
    private Doctor doctor;
    private Patient patient;
    private String slot;

    // Constructor
    public Appointment(LocalDateTime localDateTime, Doctor doctor, Patient patient, String slot) {
        this.date = localDateTime;
        this.doctor = doctor;
        this.patient = patient;
        this.slot = slot;
    }

    public Appointment(LocalDateTime dateTime, Doctor doctor2, Patient patient2) {
    	
    	date=dateTime;
    	doctor=doctor2;
    	patient=patient2;
		// TODO Auto-generated constructor stub
	}

	// Getters and setters
    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    // Method to print appointment details
    public void printDetails() {
        System.out.println("Appointment Details:");
        System.out.println("Date: " + date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Doctor: " + doctor.getFirstName() + " " + doctor.getLastName());
        System.out.println("Patient ID: " + patient.getId());
        System.out.println("Slot: " + slot);
    }

    // Other methods
    // Add appointment
    public static void addAppointment(List<Appointment> appointments, LocalDateTime date, Doctor doctor, Patient patient, String slot) {
        appointments.add(new Appointment(date, doctor, patient, slot));
    }

    // Cancel appointment
    public static void cancelAppointment(List<Appointment> appointments, LocalDateTime date, Doctor doctor, Patient patient) {
        appointments.removeIf(appointment ->
                appointment.getDate().equals(date) &&
                appointment.getDoctor().equals(doctor) &&
                appointment.getPatient().equals(patient));
    }

    // Update appointment
    public static void updateAppointment(List<Appointment> appointments, LocalDateTime date, Doctor doctor, Patient patient, String newSlot) {
        for (Appointment appointment : appointments) {
            if (appointment.getDate().equals(date) &&
                    appointment.getDoctor().equals(doctor) &&
                    appointment.getPatient().equals(patient)) {
                appointment.setSlot(newSlot);
                return;
            }
        }
        System.out.println("Appointment not found for update.");
    }

    // Show all appointments
    public static void showAllAppointments(List<Appointment> appointments) {
        System.out.println("All Appointments:");
        for (Appointment appointment : appointments) {
            appointment.printDetails();
            System.out.println();
        }
    }
}
