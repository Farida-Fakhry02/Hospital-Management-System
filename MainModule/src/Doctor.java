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

    //garaby delete ml list ama y7gz
    //momkn list not available
    //if
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

    // Method to check the doctor's availability on a specific day and time
    private boolean checkDoctorAvailability(LocalDateTime dateTime) {
        // Iterate through existing appointments to check for conflicts
        for (Appointment appointment : appointments) {
            System.out.println("Checking appointment at: " + appointment.getDateTime());
            if (appointment.getDateTime().isEqual(dateTime)) {
                // Doctor is not available at this date and time
                return false;
            }
        }
        // Doctor is available
        return true;
    }

    // Method to schedule an appointment
    public void scheduleAppointment(Appointment appointment) {

        // Get the slot of the appointment
        String appointmentSlot = appointment.getSlot();

        // Debugging: Print available slots
        System.out.println("Available Slots:");
        for (String slot : availability) {
            System.out.println(slot);
        }

        // Check if the desired slot is available
        if (availability.contains(appointmentSlot)) {
            // Remove the slot from available slots
            availability.remove(appointmentSlot);
            // Add the appointment to booked appointments
            appointments.add(appointment);
            System.out.println("Appointment successfully scheduled.");
        } else {
            System.out.println("Sorry, the doctor is not available at the specified day and time.");
        }
    }



    // Method to reschedule an appointment
    public void rescheduleAppointment(Appointment oldAppointment, Appointment newAppointment) {
        LocalDateTime oldDateTime = oldAppointment.getDateTime();
        LocalDateTime newDateTime = newAppointment.getDateTime();

        // Check if the new slot is available
        if (checkDoctorAvailability(newDateTime)) {
            // Remove the old appointment from booked appointments
            appointments.remove(oldAppointment);

            // Add the old appointment slot back to the availability list
            String oldSlot = oldAppointment.getSlot();
            availability.add(oldSlot);
            System.out.println("Added back to availability: " + oldSlot); // Debug statement

            // Add the new appointment to booked appointments
            appointments.add(newAppointment);

            // Remove the new appointment slot from the availability list
            String newSlot = newAppointment.getSlot();
            availability.remove(newSlot);
            System.out.println("Removed from availability: " + newSlot); // Debug statement

            System.out.println("Appointment successfully rescheduled to: " + newDateTime);
        } else {
            System.out.println("Sorry, the doctor is not available at the specified date and time.");
        }
    }


    // Utility method to format slot with full date
    private String getSlotString(LocalDateTime dateTime) {
        String dayOfWeek = dateTime.getDayOfWeek().toString().substring(0, 3);
        String date = dateTime.toLocalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String time = dateTime.toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm"));
        return dayOfWeek + " " + date + " " + time;
    }

    // Method to retrieve the list of available slots
    public List<String> getAvailability() {
        return availability;
    }



/*
ScheduleAppointment(Patient patient, String day, String time): This method allows scheduling an appointment for a patient with the doctor on a specific day and time.

CancelAppointment(Appointment appointment): This method cancels a previously scheduled appointment.

GenerateAppointmentConfirmation(Appointment appointment): This method generates an appointment confirmation for a scheduled appointment.

PrescribeMedication(Patient patient, Medication medication): This method allows the doctor to prescribe medication for a patient.

RequestTests(Patient patient, Test[] tests): This method allows the doctor to request medical tests for a patient.

RecordDiagnosis(Patient patient, String diagnosis): This method records a diagnosis for a patient after examination.

GenerateMedicalReport(Patient patient): This method generates a medical report summarizing the patient's visit and treatment.

CalculateConsultationDuration(Patient patient): This method calculates the expected duration of a consultation based on the patient's condition or appointment type.

UpdateAvailability(String day, String time, boolean isAvailable): This method updates the doctor's availability for a specific day and time slot.


HandleEmergency(Patient patient): This method allows the doctor to handle emergency cases and provide immediate medical assistance.


// Method to retrieve the list of appointments
    public List<Appointment> getAppointments() {
        return appointments;
    }


CheckPatientHistory(Patient patient): This method retrieves the medical history of a patient previously treated by the doctor.
------b3d mn3ml medical record---------
public class Doctor {
    // Other attributes and methods...

    // List to store medical records of patients treated by the doctor
    private List<MedicalRecord> patientMedicalRecords;

    // Constructor and other methods...

    // Method to retrieve patient history
    public List<MedicalRecord> checkPatientHistory(Patient patient) {
        List<MedicalRecord> history = new ArrayList<>();

        // Iterate through the medical records and find those belonging to the specified patient
        for (MedicalRecord record : patientMedicalRecords) {
            if (record.getPatient().equals(patient)) {
                history.add(record);
            }
        }

        return history;
    }
}


----lma a3ml class appointment

public class Doctor {
    // Other attributes and methods...

    // List to store booked appointments
    private List<Appointment> appointments;

    // Constructor and other methods...

    // Method to retrieve appointment schedule
    public List<Appointment> getAppointmentSchedule() {
        return appointments;
    }

    // Method to add an appointment to the schedule
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    // Method to remove an appointment from the schedule
    public void removeAppointment(Appointment appointment) {
        appointments.remove(appointment);
    }
}

*/

}
