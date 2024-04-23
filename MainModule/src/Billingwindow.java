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

public class Billingwindow {

    private JFrame frame;
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
                    window.frame.setVisible(true);
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
        frame = new JFrame();
        frame.setBounds(100, 100, 505, 428);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        patientNameField = new JTextField();
        patientNameField.setBounds(152, 29, 192, 20);
        frame.getContentPane().add(patientNameField);
        patientNameField.setColumns(10);

        amountField = new JTextField();
        amountField.setBounds(152, 74, 192, 20);
        frame.getContentPane().add(amountField);
        amountField.setColumns(10);

        JButton addButton = new JButton("Add Invoice");
        addButton.setBounds(26, 117, 144, 35);
        addButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String patientName = patientNameField.getText();
                double amount = Double.parseDouble(amountField.getText());
                Billing.Invoice invoice = new Billing.Invoice(patientName, amount);
                billingModule.addInvoice(invoice);
                outputArea.setText("Invoice added for " + patientName + " with amount $" + amount);
            }
        });
        frame.getContentPane().add(addButton);

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
                invoiceDetails.append("Total bill for ").append(patientName).append(" is $").append(totalBill).append("\n");
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
        frame.getContentPane().add(generateBillButton);

        JButton totalInvoicesButton = new JButton("Total Invoices");
        totalInvoicesButton.setBounds(323, 117, 144, 35);
        totalInvoicesButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        totalInvoicesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int totalInvoices = billingModule.getInvoices().size();
                outputArea.setText("Total invoices: " + totalInvoices);
            }
        });
        frame.getContentPane().add(totalInvoicesButton);

        JButton totalAmountButton = new JButton("Total Amount for Patient");
        totalAmountButton.setBounds(138, 163, 191, 23);
        totalAmountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String patientName = patientNameField.getText();
                double totalAmount = billingModule.totalAmountForPatient(patientName);
                outputArea.setText("Total amount for " + patientName + " is $" + totalAmount);
            }
        });
        frame.getContentPane().add(totalAmountButton);

        outputArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBounds(26, 196, 414, 91);
        frame.getContentPane().add(scrollPane);
        
        JLabel lblNewLabel = new JLabel("Patient Name");
        lblNewLabel.setBounds(26, 28, 98, 20);
        lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        frame.getContentPane().add(lblNewLabel);
        
        JLabel lblAmount = new JLabel("Amount");
        lblAmount.setBounds(26, 77, 98, 20);
        lblAmount.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        frame.getContentPane().add(lblAmount);
        
        JButton btnNewButton = new JButton("Back");
        btnNewButton.setBounds(180, 319, 119, 45);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform action to return to the Receptionist_GUI window
                frame.dispose(); // Close the current window
                receptionistGUI = new Receptionist_GUI(); // Create an instance of Receptionist_GUI
                receptionistGUI.getFrame().setVisible(true); // Show the Receptionist_GUI window
            }
        });
        frame.getContentPane().add(btnNewButton);
    
    }

    public JFrame getFrame() {
        return frame;
    }
}
