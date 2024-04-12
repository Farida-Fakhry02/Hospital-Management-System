import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Define a class for the billing module
public class Billing {
    // Define instance variables
    private List<Invoice> invoices;

    // Constructor
    public Billing() {
        invoices = new ArrayList<>();
    }

    // Method to add an invoice
    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }

    // Method to generate a bill for a patient
    public double generateBillForPatient(String patientName) {
        double totalBill = 0.0;
        for (Invoice invoice : invoices) {
            if (invoice.getPatientName().equals(patientName)) {
                totalBill += invoice.getAmount();
            }
        }
        return totalBill;
    }

    // Method to retrieve the list of invoices
    public List<Invoice> getInvoices() {
        return invoices;
    }

    // Inner class representing an invoice
    public static class Invoice {
        private String patientName;
        private double amount;
        private LocalDate dateIssued;

        // Constructor
        public Invoice(String patientName, double amount) {
            this.patientName = patientName;
            this.amount = amount;
            this.dateIssued = LocalDate.now(); // Set current date as the date issued
        }

        // Getters and setters
        public String getPatientName() {
            return patientName;
        }

        public void setPatientName(String patientName) {
            this.patientName = patientName;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public LocalDate getDateIssued() {
            return dateIssued;
        }

        // Method to print invoice details
        public void printInvoiceDetails() {
            System.out.println("Invoice Details:");
            System.out.println("Patient Name: " + patientName);
            System.out.println("Amount: $" + amount);
            System.out.println("Date Issued: " + dateIssued.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }
    }
}
