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
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String patientName = patientNameField.getText();
                double amount = Double.parseDouble(amountField.getText());
                Billing.Invoice invoice = new Billing.Invoice(patientName, amount);
                billingModule.addInvoice(invoice);
                outputArea.setText("Invoice added for " + patientName + " with amount $" + amount);
            }
        });
        addButton.setBounds(26, 117, 117, 23);
        frame.getContentPane().add(addButton);

        JButton generateBillButton = new JButton("Generate Bill");
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

        generateBillButton.setBounds(180, 117, 117, 23);
        frame.getContentPane().add(generateBillButton);

        JButton totalInvoicesButton = new JButton("Total Invoices");
        totalInvoicesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int totalInvoices = billingModule.getInvoices().size();
                outputArea.setText("Total invoices: " + totalInvoices);
            }
        });
        totalInvoicesButton.setBounds(323, 117, 117, 23);
        frame.getContentPane().add(totalInvoicesButton);

        JButton totalAmountButton = new JButton("Total Amount for Patient");
        totalAmountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String patientName = patientNameField.getText();
                double totalAmount = billingModule.totalAmountForPatient(patientName);
                outputArea.setText("Total amount for " + patientName + " is $" + totalAmount);
            }
        });
        totalAmountButton.setBounds(138, 163, 191, 23);
        frame.getContentPane().add(totalAmountButton);

        outputArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBounds(26, 196, 414, 91);
        frame.getContentPane().add(scrollPane);
        
        JLabel lblNewLabel = new JLabel("Patient Name");
        lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblNewLabel.setBounds(26, 28, 98, 20);
        frame.getContentPane().add(lblNewLabel);
        
        JLabel lblAmount = new JLabel("Amount");
        lblAmount.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblAmount.setBounds(26, 77, 98, 20);
        frame.getContentPane().add(lblAmount);
    }

    public JFrame getFrame() {
        return frame;
    }
}
