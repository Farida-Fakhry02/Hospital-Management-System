//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }

        Patient johnDoe = new Patient("John", "Doe", LocalDate.of(1990, 5, 15), "Male", "123 Main St", "123-456-7890", 180.0, 75.0);
        Patient janeSmith = new Patient("Jane", "Smith", LocalDate.of(1985, 9, 20), "Female", "456 Oak St", "987-654-3210", 160.0, 60.0);
        Patient aliceJohnson = new Patient("Alice", "Johnson", LocalDate.of(1975, 3, 10), "Female", "789 Elm St", "555-123-4567", 170.0, 65.0);

        // Create a billing instance
        Billing billingSystem = new Billing();

        // Add some sample invoices
        billingSystem.addInvoice(new Billing.Invoice(johnDoe.getFirstName() + " " + johnDoe.getLastName(), 100.0));
        billingSystem.addInvoice(new Billing.Invoice(janeSmith.getFirstName() + " " + janeSmith.getLastName(), 200.0));
        billingSystem.addInvoice(new Billing.Invoice(johnDoe.getFirstName() + " " + johnDoe.getLastName(), 150.0));
        billingSystem.addInvoice(new Billing.Invoice(aliceJohnson.getFirstName() + " " + aliceJohnson.getLastName(), 300.0));

        // Generate bill for a patient
        String patientName = johnDoe.getFirstName() + " " + johnDoe.getLastName(); // Example: John Doe
        double totalBill = billingSystem.generateBillForPatient(patientName);
        System.out.println("Total bill for patient " + patientName + ": $" + totalBill);
    }
}