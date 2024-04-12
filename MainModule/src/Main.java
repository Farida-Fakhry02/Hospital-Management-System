//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");


        Patient aliceJohnson = new Patient("Alice", "Johnson", LocalDate.of(1975, 3, 10), "Female", "789 Elm St", "555-123-4567", 170.0, 65.0);

        // Create a billing instance
        Billing billingSystem = new Billing();

        // Add an invoice for Alice Johnson
        billingSystem.addInvoice(new Billing.Invoice(aliceJohnson.getFirstName() + " " + aliceJohnson.getLastName(), 300.0));

        // Generate bill for Alice Johnson
        String patientName = aliceJohnson.getFirstName() + " " + aliceJohnson.getLastName(); // Example: Alice Johnson
        double totalBill = billingSystem.generateBillForPatient(patientName);

        // Print invoice details
        System.out.println("Invoice Details for " + patientName + ":");
        for (Billing.Invoice invoice : billingSystem.getInvoices()) {
            if (invoice.getPatientName().equals(patientName)) {
                invoice.printInvoiceDetails();
            }
        }

        // Print total bill
        System.out.println("Total bill for patient " + patientName + ": $" + totalBill);

        // Print total bill
        System.out.println("Total bill for patient " + patientName + ": $" + totalBill);

        //update patient info
        aliceJohnson.updateContactInfo("115 saad el din st. - Tanta - Gharbeya","01277174147");
        System.out.println("updated address : " + aliceJohnson.getAddress());
        System.out.println("updated phone number : " + aliceJohnson.getPhoneNumber());

        //checking information validity
        boolean isValid= aliceJohnson.validatePatientInfo();
        if (isValid) {
            System.out.println("Patient information is valid.");
        }
        else
        {
            System.out.println("Patient information is invalid.");
        }

        // Create a new medical records module
        MedicalRecordsModule medicalRecordsModule = new MedicalRecordsModule();

        // Add a new medical record
        medicalRecordsModule.addMedicalRecord(1, "John Doe", "Fever", "Rest and fluids", LocalDate.of(2024, 4, 12));

        // Retrieve and display the medical record
        MedicalRecord record = medicalRecordsModule.getMedicalRecord(1);
        System.out.println("Medical Record ID: " + record.getRecordId());
        System.out.println("Patient Name: " + record.getPatientName());
        System.out.println("Diagnosis: " + record.getDiagnosis());
        System.out.println("Treatment: " + record.getTreatment());
        System.out.println("Date: " + record.getDate());

        // Update the medical record
        medicalRecordsModule.updateMedicalRecord(1, "Cold", "Medication and rest");

        // Retrieve and display the updated medical record
        record = medicalRecordsModule.getMedicalRecord(1);
        System.out.println("\nUpdated Medical Record:");
        System.out.println("Medical Record ID: " + record.getRecordId());
        System.out.println("Patient Name: " + record.getPatientName());
        System.out.println("Diagnosis: " + record.getDiagnosis());
        System.out.println("Treatment: " + record.getTreatment());
        System.out.println("Date: " + record.getDate());

        // Testing additional methods
        System.out.println("\nSearch Medical Records by Patient Name:");
        List<MedicalRecord> recordsByName = medicalRecordsModule.searchMedicalRecordsByPatientName("John Doe");
        for (MedicalRecord r : recordsByName) {
            System.out.println(r.getRecordId() + " - " + r.getPatientName() + " - " + r.getDiagnosis() + " - " + r.getTreatment());
        }
        // Testing Inventory Control Class

        InventoryControl inventoryControl = new InventoryControl();

        // Add some sample items to inventory
        InventoryItem item1 = new InventoryItem(1, "Surgical Mask", "Disposable mask for surgical procedures", 100, 1);
        InventoryItem item2 = new InventoryItem(2, "Gauze Pads", "Sterile pads for wound dressing", 50, 1);
        inventoryControl.addItem(item1);
        inventoryControl.addItem(item2);

        System.out.println("Initial Inventory");

        inventoryControl.generateInventoryReport();

        inventoryControl.updateItemQuantity(1, 80);

        System.out.println("Inventory after updating an item's quantity");

        inventoryControl.generateInventoryReport();

        System.out.println("Is Surgical Mask available? " + inventoryControl.checkItemAvailability(1));

        System.out.println("Inventory after removing an item");

        inventoryControl.removeItem(1);

        System.out.println("Is Surgical Mask available? " + inventoryControl.checkItemAvailability(1));

        Supplier supplier1 = new Supplier(1, "Medical Supply Inc.", "contact@medicalsupply.com");

        inventoryControl.addSupplier(supplier1);

        inventoryControl.placeOrder(2, 20);
    }
}