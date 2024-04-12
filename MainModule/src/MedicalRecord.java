import java.util.HashMap;
import java.util.Map;

// Class to represent a medical record
class MedicalRecord {
    private int recordId;
    private String patientName;
    private String diagnosis;
    private String treatment;

    public MedicalRecord(int recordId, String patientName, String diagnosis, String treatment) {
        this.recordId = recordId;
        this.patientName = patientName;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
}

// Class to handle medical records operations
class MedicalRecordsModule {
    private Map<Integer, MedicalRecord> records;

    public MedicalRecordsModule() {
        records = new HashMap<>();
    }

    // Add a new medical record
    public void addMedicalRecord(int recordId, String patientName, String diagnosis, String treatment) {
        MedicalRecord newRecord = new MedicalRecord(recordId, patientName, diagnosis, treatment);
        records.put(recordId, newRecord);
    }

    // Retrieve a medical record by record ID
    public MedicalRecord getMedicalRecord(int recordId) {
        return records.get(recordId);
    }

    // Update a medical record
    public void updateMedicalRecord(int recordId, String diagnosis, String treatment) {
        MedicalRecord record = records.get(recordId);
        if (record != null) {
            record.setDiagnosis(diagnosis);
            record.setTreatment(treatment);
        } else {
            System.out.println("Medical record with ID " + recordId + " not found.");
        }
    }
}