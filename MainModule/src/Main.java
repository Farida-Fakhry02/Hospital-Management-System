//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.time.LocalDate;

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
    }
}