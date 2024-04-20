import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Define a class for the billing module
public class Billing {
    // Define instance variables
    private List<Invoice> invoices;
    private int nextInvoiceNumber; // Keeps track of the next invoice number

    // Constructor
    public Billing() {
        invoices = new ArrayList<>();
        nextInvoiceNumber = 1; // Initialize the invoice number to start from 1
    }

    // Method to add an invoice
    public void addInvoice(Invoice invoice) {
        // Set the invoice number before adding the invoice
        invoice.setInvoiceNumber(nextInvoiceNumber++);
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

    // Method to get the total amount for a patient
    public double totalAmountForPatient(String patientName) {
        double totalAmount = 0.0;
        for (Invoice invoice : invoices) {
            if (invoice.getPatientName().equals(patientName)) {
                totalAmount += invoice.getAmount();
            }
        }
        return totalAmount;
    }

    // Inner class representing an invoice
    public static class Invoice {
        private int invoiceNumber; // Invoice number
        private String patientName;
        private double amount;
        private LocalDate dateIssued;
        private String itemizedBilling; // Itemized billing details

        // Constructor
        public Invoice(String patientName, double amount) {
            this.patientName = patientName;
            this.amount = amount;
            this.dateIssued = LocalDate.now(); // Set current date as the date issued
        }

        // Getters and setters
        public int getInvoiceNumber() {
            return invoiceNumber;
        }

        public void setInvoiceNumber(int invoiceNumber) {
            this.invoiceNumber = invoiceNumber;
        }

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

        public String getItemizedBilling() {
            return itemizedBilling;
        }

        public void setItemizedBilling(String itemizedBilling) {
            this.itemizedBilling = itemizedBilling;
        }

        // Method to print invoice details
        public void printInvoiceDetails() {
            System.out.println("Invoice Number: " + invoiceNumber);
            System.out.println("Patient Name: " + patientName);
            System.out.println("Amount: $" + amount);
            System.out.println("Date Issued: " + dateIssued.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            if (itemizedBilling != null && !itemizedBilling.isEmpty()) {
                System.out.println("Itemized Billing: " + itemizedBilling);
            }
        }
    }
}
