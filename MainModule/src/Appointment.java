import java.util.*;
import java.time.*;
import java.time.format.*;

public class Appointment {
    private LocalDateTime date;
    private Doctor doctor;
    private String patientId;
    private String slot;

    // Constructor
    public Appointment(LocalDateTime localDateTime, Doctor doctor, String patientId, String slot) {
        this.date = localDateTime;
        this.doctor = doctor;
        this.patientId = patientId;
        this.slot = slot;
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

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
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
        System.out.println("Patient ID: " + patientId);
        System.out.println("Slot: " + slot);
    }

    // Other methods
    // Add appointment
    public static void addAppointment(List<Appointment> appointments, LocalDateTime date, Doctor doctor, String patientId, String slot) {
        appointments.add(new Appointment(date, doctor, patientId, slot));
    }

    // Cancel appointment
    public static void cancelAppointment(List<Appointment> appointments, LocalDateTime date, Doctor doctor, String patientId) {
        appointments.removeIf(appointment ->
                appointment.getDate().equals(date) &&
                appointment.getDoctor().equals(doctor) &&
                appointment.getPatientId().equals(patientId));
    }

    // Update appointment
    public static void updateAppointment(List<Appointment> appointments, LocalDateTime date, Doctor doctor, String patientId, String newSlot) {
        for (Appointment appointment : appointments) {
            if (appointment.getDate().equals(date) &&
                    appointment.getDoctor().equals(doctor) &&
                    appointment.getPatientId().equals(patientId)) {
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