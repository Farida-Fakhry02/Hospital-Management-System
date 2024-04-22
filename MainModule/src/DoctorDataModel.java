

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class DoctorDataModel {
    
    
      private static DoctorDataModel instance;
    private LinkedList<Doctor> doctors;

    private DoctorDataModel() {
        doctors = new LinkedList<>();
        
doctors = new LinkedList<>();
        
        // Adding doctors
        List<String> availability1 = new ArrayList<>();
        availability1.add("Monday 9:00 AM");
        availability1.add("Tuesday 10:00 AM");
        Doctor doctor1 = new Doctor("John", "Doe", "General Physician", "1234567890", "DOC001", "john@example.com", 10, "General Medicine", 50.0, availability1);
        doctors.add(doctor1);

        List<String> availability2 = new ArrayList<>();
        availability2.add("Wednesday 11:00 AM");
        availability2.add("Thursday 12:00 PM");
        Doctor doctor2 = new Doctor("Jane", "Smith", "Pediatrician", "0987654321", "DOC002", "jane@example.com", 8, "Pediatrics", 60.0, availability2);
        doctors.add(doctor2);
    
    }
        
        
        // initialize the list with default values, if needed
    

    public static DoctorDataModel getInstance() {
        if (instance == null) {
            instance = new DoctorDataModel();
        }
        return instance;
    }

    public LinkedList<Doctor> getDoctors() {
        return doctors;
    }
}
    

