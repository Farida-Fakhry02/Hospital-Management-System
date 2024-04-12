import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Appointment {
    private LocalDateTime dateTime;
    private Doctor doctor;
    private Patient patient;
    private String description;
    private String slot;

    // Constructor


    public Appointment(LocalDateTime dateTime, Doctor doctor, Patient patient, String description) {
        this.dateTime = dateTime;
        this.doctor = doctor;
        this.patient = patient;
        this.description = description;
        this.slot = formatSlot(dateTime);
    }

    public Appointment(LocalDateTime dateTime, Doctor doctor, Patient patient, String description, String slot) {
        this.dateTime = dateTime;
        this.doctor = doctor;
        this.patient = patient;
        this.description = description;
        this.slot = slot;
    }

// Getters and setters

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //other methods

    // Method to print appointment details
    public void printDetails() {
        System.out.println("Appointment Details:");
        System.out.println("Date and Time: " + dateTime);
        System.out.println("Doctor: " + doctor.getFirstName() + " " + doctor.getLastName());
        System.out.println("Patient: " + patient.getFirstName() + " " + patient.getLastName());
        System.out.println("Description: " + description);
        System.out.println("Slot: "+slot);
    }


    // Method to format the slot
    private String formatSlot(LocalDateTime dateTime) {
        // Get the day of the week in a shorter format (e.g., "Mon", "Tue", etc.)
        String dayOfWeek = dateTime.getDayOfWeek().toString().substring(0, 3);
        // Get the time in HH:mm format
        String time = dateTime.toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm"));
        // Combine day of the week and time
        return dayOfWeek + " " + time;
    }



/*

RescheduleAppointment(LocalDateTime newDateTime): This method allows rescheduling the appointment to a new date and time.

CancelAppointment(): This method cancels the appointment.

GetAppointmentDuration(): This method calculates and returns the duration of the appointment.

GetAppointmentDetails(): This method retrieves and returns the details of the appointment, such as the appointment time, doctor, patient, and reason.

IsSameDayAppointment(): This method checks if the appointment is scheduled for the same day.

IsUpcomingAppointment(): This method checks if the appointment is upcoming (i.e., scheduled for a future date and time).

CheckDoctorAvailability(): This method checks if the doctor is available at the scheduled appointment time.

CheckPatientEligibility(): This method checks if the patient is eligible for the appointment (e.g., if they have met certain criteria or completed necessary prerequisites).

GenerateAppointmentConfirmation(): This method generates a confirmation message or document for the appointment.

SendAppointmentReminder(): This method sends a reminder to the patient about the upcoming appointment.

UpdateReason(String newReason): This method allows updating the reason for the appointment.

CalculateCost(): This method calculates the cost of the appointment (if applicable, e.g., consultation fee).

RecordAppointmentOutcome(String outcome): This method records the outcome of the appointment (e.g., diagnosis, treatment plan).

AddNotes(String notes): This method allows adding additional notes or comments related to the appointment.

ValidateAppointment(): This method validates the appointment details to ensure they meet certain criteria or constraints.

CheckConflicts(List<Appointment> appointments): This method checks for any conflicts or overlaps with other appointments.

PrintAppointmentDetails(): This method prints out the details of the appointment in a formatted manner.*/


}
