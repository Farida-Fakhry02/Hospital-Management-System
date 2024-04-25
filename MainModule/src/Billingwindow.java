import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JOptionPane;


public class Billingwindow {

    private JFrame frmBilling;
    private JTextField patientNameField;
    private JTextField amountField;
    private Billing billingModule;
    private JTextArea outputArea;
    private Receptionist_GUI receptionistGUI;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Billingwindow window = new Billingwindow();
                    window.frmBilling.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Billingwindow() {
        initialize();
        billingModule = new Billing();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmBilling = new JFrame();
        frmBilling.setTitle("Billing");
        frmBilling.getContentPane().setBackground(new Color(135, 206, 250));
        frmBilling.setBounds(100, 100, 506, 530);
        frmBilling.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmBilling.getContentPane().setLayout(null);

        patientNameField = new JTextField();
        patientNameField.setBounds(152, 29, 192, 20);
        frmBilling.getContentPane().add(patientNameField);
        patientNameField.setColumns(10);

        amountField = new JTextField();
        amountField.setBounds(152, 74, 192, 20);
        frmBilling.getContentPane().add(amountField);
        amountField.setColumns(10);

        JButton addButton = new JButton("Add Invoice");
        addButton.setBounds(26, 117, 144, 35);
        addButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Check if any of the text fields are empty
                if (patientNameField.getText().isEmpty() || amountField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in both fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return; // Exit the method if any field is empty
                }

                // Get the values from the input fields
                String patientName = patientNameField.getText();
                double amount;
                try {
                    amount = Double.parseDouble(amountField.getText());
                    if (amount <= 0) {
                        JOptionPane.showMessageDialog(null, "Amount must be a positive value.", "Input Error", JOptionPane.ERROR_MESSAGE);
                        return; // Exit the method if amount is not positive
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Amount must be a numeric value.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return; // Exit the method if amount is not numeric
                }
                
                Billing.Invoice invoice = new Billing.Invoice(patientName, amount);
                billingModule.addInvoice(invoice);
                outputArea.setText("Invoice added for " + patientName + " with amount $" + amount);
            }
        });
        frmBilling.getContentPane().add(addButton);

        JButton generateBillButton = new JButton("Generate Bill");
        generateBillButton.setBounds(180, 117, 133, 35);
        generateBillButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        generateBillButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String patientName = patientNameField.getText();
                double totalBill = billingModule.generateBillForPatient(patientName);

                // Fetch the list of invoices for the patient
                List<Billing.Invoice> patientInvoices = new ArrayList<>();
                for (Billing.Invoice invoice : billingModule.getInvoices()) {
                    if (invoice.getPatientName().equals(patientName)) {
                        patientInvoices.add(invoice);
                    }
                }

                // Create a StringBuilder to store the invoice details
                StringBuilder invoiceDetails = new StringBuilder();
                invoiceDetails.append("Total bill for ").append(patientName).append(" is $").append(totalBill)
                        .append("\n");
                invoiceDetails.append("Invoice Details:\n");

                // Iterate through each invoice and append details to the StringBuilder
                for (Billing.Invoice invoice : patientInvoices) {
                    invoiceDetails.append("Invoice Number: ").append(invoice.getInvoiceNumber()).append("\n");
                    invoiceDetails.append("Patient Name: ").append(invoice.getPatientName()).append("\n");
                    invoiceDetails.append("Amount: $").append(invoice.getAmount()).append("\n");
                    invoiceDetails.append("Date Issued: ").append(invoice.getDateIssued()).append("\n");
                    invoiceDetails.append("\n"); // Add a new line for separation
                }

                outputArea.setText(invoiceDetails.toString());
            }
        });
        frmBilling.getContentPane().add(generateBillButton);

        JButton totalInvoicesButton = new JButton("Total Invoices");
        totalInvoicesButton.setBounds(323, 117, 144, 35);
        totalInvoicesButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        totalInvoicesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int totalInvoices = billingModule.getInvoices().size();
                outputArea.setText("Total invoices: " + totalInvoices);
            }
        });
        frmBilling.getContentPane().add(totalInvoicesButton);

        JButton totalAmountButton = new JButton("Total Amount for Patient");
        totalAmountButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        totalAmountButton.setBounds(138, 163, 222, 34);
        totalAmountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String patientName = patientNameField.getText();
                double totalAmount = billingModule.totalAmountForPatient(patientName);
                outputArea.setText("Total amount for " + patientName + " is $" + totalAmount);
            }
        });
        frmBilling.getContentPane().add(totalAmountButton);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 222, 471, 190);
        frmBilling.getContentPane().add(scrollPane);
        
                outputArea = new JTextArea();
                scrollPane.setViewportView(outputArea);

        JLabel lblNewLabel = new JLabel("Patient Name");
        lblNewLabel.setBounds(26, 28, 98, 20);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        frmBilling.getContentPane().add(lblNewLabel);

        JLabel lblAmount = new JLabel("Amount");
        lblAmount.setBounds(26, 77, 98, 20);
        lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 15));
        frmBilling.getContentPane().add(lblAmount);

        JButton btnNewButton = new JButton("Back");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton.setBounds(251, 435, 119, 45);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform action to return to the Receptionist_GUI window
                frmBilling.dispose(); // Close the current window
                receptionistGUI = new Receptionist_GUI(); // Create an instance of Receptionist_GUI
                receptionistGUI.getFrame().setVisible(true); // Show the Receptionist_GUI window
            }
        });
        frmBilling.getContentPane().add(btnNewButton);

        JButton btnClear = new JButton("Clear");
        btnClear.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnClear.setBounds(122, 435, 119, 45);
        frmBilling.getContentPane().add(btnClear);

        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearInputFields(); // Call the method to clear input fields
            }
        });
    }

    // Method to clear input fields
    private void clearInputFields() {
        patientNameField.setText(""); // Clear patient name field
        amountField.setText(""); // Clear amount field
        outputArea.setText(""); // Clear output area
    }

    public JFrame getFrame() {
        return frmBilling;
    }
}
