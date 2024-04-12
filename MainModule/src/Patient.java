import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;


public class Patient {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private String address;
    private String phoneNumber;
    private double height;
    private double weight;

    // Constructor
    public Patient(String firstName, String lastName, LocalDate dateOfBirth, String gender, String address, String phoneNumber, double height, double weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.height = height;
        this.weight = weight;
    }


    // Getters and setters
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


    public int calculateAge() {
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(this.dateOfBirth, currentDate);
        return period.getYears();
    }

    //print patient details
    public void printDetails() {
        System.out.println("Patient Details:");
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Date of Birth: " + dateOfBirth.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Gender: " + gender);
        System.out.println("Address: " + address);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Height: " + height + " cm");
        System.out.println("Weight: " + weight + " kg");
    }

    //calculate BMI
    public String calculateBMI() {
        // BMI formula: weight (kg) / height^2 (m^2)
        double heightInMeters = this.height / 100; // Convert height from centimeters to meters
        double bmi = this.weight / (heightInMeters * heightInMeters);
        System.out.println("BMI: "+bmi);
        // Determine BMI category
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi < 25) {
            return "Normal weight";
        } else if (bmi >= 25 && bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    //update data
    public void updateContactInfo(String newAddress, String newPhoneNumber) {
        if (newAddress != null && !newAddress.isEmpty()) {
            this.address = newAddress;
        }
        if (newPhoneNumber != null && !newPhoneNumber.isEmpty()) {
            this.phoneNumber = newPhoneNumber;
        }


    }

    // Method to validate patient information
    public boolean validatePatientInfo() {
        return isValidPhoneNumber(phoneNumber) && isValidDateOfBirth(dateOfBirth);
    }
    // Method to validate phone number format
    private boolean isValidPhoneNumber(String phoneNumber) {
        // Simple regex to match a typical phone number format (e.g., XXXXXXXXXXX)
        String phoneRegex = "\\d{11}";
        return Pattern.matches(phoneRegex, phoneNumber);
    }

    // Method to validate date of birth (simplified check)
    private boolean isValidDateOfBirth(LocalDate dateOfBirth) {
        //We're checking if it's not null
        return dateOfBirth != null ;
    }





    /*

updateContactInfo(String newAddress, String newPhoneNumber): This method could allow updating the address and phone number of the patient.

validatePatientInfo(): This method could validate the information of the patient, ensuring that it meets certain criteria (e.g., valid phone number format, valid date of birth).

generatePatientID(): This method could generate a unique identifier for the patient, which can be useful for database operations and tracking.

getAgeCategory(): This method could return the age category of the patient (e.g., child, adult, senior).

**** addMedicalRecord(MedicalRecord medicalRecord): This method could add a medical record object to the patient's record.

payBill(double amount): This method could handle payment of bills associated with the patient's medical services.


    */
}

