

import java.time.LocalDate;
import java.util.ArrayList;


public class PatientDataModel {
    private static PatientDataModel instance;
    private ArrayList<Patient> patients;

    private PatientDataModel() {
        patients = new ArrayList<>();
        
     // Add some default patients
        patients.add(new Patient("John", "Doe", LocalDate.of(1990, 5, 15), "Male", "123 Main St", "1234567890", 170.0, 70.0,1));
        patients.add(new Patient("Jane", "Smith", LocalDate.of(1985, 10, 25), "Female", "456 Oak St", "9876543210", 160.0, 60.0,4));
        // Add more patients as needed
    }

    public static PatientDataModel getInstance() {
        if (instance == null) {
            instance = new PatientDataModel();
        }
        return instance;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }
}
