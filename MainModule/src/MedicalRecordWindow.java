import java.awt.EventQueue;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MedicalRecordWindow {

	
    public JFrame frmMedicalRecords;
    private JTextField textField;
    private JComboBox<String> comboBoxDay;
    private JComboBox<String> comboBoxMonth;
    private JComboBox<String> comboBoxYear;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JButton btnNewButton;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnBack;
    private JButton btnSearch;
    private JScrollPane scrollPane;

    /**
     * Launch the application.
     */
    private List<MedicalRecord> medicalRecords = new ArrayList<>();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MedicalRecordWindow window = new MedicalRecordWindow();
                    window.frmMedicalRecords.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public MedicalRecordWindow() {
        initialize();
    }

   
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmMedicalRecords = new JFrame();
        frmMedicalRecords.getContentPane().setBackground(new Color(135,206,250));
        frmMedicalRecords.setTitle("Medical Records");
        frmMedicalRecords.setBounds(100, 100, 722, 551);
        frmMedicalRecords.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmMedicalRecords.getContentPane().setLayout(null);
        
        
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false); // Make it non-editable
        scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(451, 20, 231, 457);
        frmMedicalRecords.getContentPane().add(scrollPane);

        JLabel lblNewLabel = new JLabel("Record ID");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(31, 20, 133, 27);
        frmMedicalRecords.getContentPane().add(lblNewLabel);

        JLabel lblPatientName = new JLabel("Patient Name");
        lblPatientName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPatientName.setBounds(31, 76, 133, 27);
        frmMedicalRecords.getContentPane().add(lblPatientName);

        JLabel lblDiagnosis = new JLabel("Diagnosis");
        lblDiagnosis.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblDiagnosis.setBounds(31, 138, 133, 27);
        frmMedicalRecords.getContentPane().add(lblDiagnosis);

        JLabel lblTreatment = new JLabel("Treatment");
        lblTreatment.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTreatment.setBounds(31, 199, 106, 27);
        frmMedicalRecords.getContentPane().add(lblTreatment);

        JLabel lblDate = new JLabel("Date");
        lblDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblDate.setBounds(31, 260, 53, 27);
        frmMedicalRecords.getContentPane().add(lblDate);

        textField = new JTextField();
        textField.setBounds(174, 20, 205, 27);
        frmMedicalRecords.getContentPane().add(textField);
        textField.setColumns(10);
        
        comboBoxDay = new JComboBox<>();
        comboBoxDay.setBounds(144, 264, 53, 27);
        for (int i = 1; i <= 31; i++) {
            comboBoxDay.addItem(String.valueOf(i));
        }
        frmMedicalRecords.getContentPane().add(comboBoxDay);
        
        comboBoxMonth = new JComboBox<>();
        comboBoxMonth.setBounds(207, 264, 115, 27);
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        for (String month : months) {
            comboBoxMonth.addItem(month);
        }
        frmMedicalRecords.getContentPane().add(comboBoxMonth);
        
        comboBoxYear = new JComboBox<>();
        comboBoxYear.setBounds(332, 264, 70, 27);
        int currentYear = java.time.Year.now().getValue();
        for (int i = currentYear; i >= currentYear - 100; i--) {
        	comboBoxYear.addItem(String.valueOf(i));
        }
        
        frmMedicalRecords.getContentPane().add(comboBoxYear);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(174, 76, 205, 27);
        frmMedicalRecords.getContentPane().add(textField_1);
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(174, 138, 205, 27);
        frmMedicalRecords.getContentPane().add(textField_2);
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(174, 199, 205, 27);
        frmMedicalRecords.getContentPane().add(textField_3);
        
        btnNewButton = new JButton("Add");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton.setBounds(21, 339, 115, 51);
        frmMedicalRecords.getContentPane().add(btnNewButton);

        // Add action listener to the "Add" button
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the values from the input fields
                int recordID = Integer.parseInt(textField.getText());
                String patientName = textField_1.getText();
                String diagnosis = textField_2.getText();
                String treatment = textField_3.getText();
                LocalDate date = LocalDate.of(Integer.parseInt(comboBoxYear.getSelectedItem().toString()),
                        comboBoxMonth.getSelectedIndex() + 1, Integer.parseInt(comboBoxDay.getSelectedItem().toString()));

                // Create a new medical record
                MedicalRecord medicalRecord = new MedicalRecord(recordID, patientName, diagnosis, treatment, date);

                // Add the medical record to the array
                medicalRecords.add(medicalRecord);

                // Display success message
                textArea.append("Record added successfully.\n");
            }
        });
    
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton.setBounds(21, 339, 115, 51);
        frmMedicalRecords.getContentPane().add(btnNewButton);
        
        btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the record ID from the text field
                int recordIDToUpdate = Integer.parseInt(textField.getText());
                
                // Find the index of the record with the specified record ID
                int index = -1;
                for (int i = 0; i < medicalRecords.size(); i++) {
                    if (medicalRecords.get(i).getRecordId() == recordIDToUpdate) {
                        index = i;
                        break;
                    }
                }
                
                // If the record ID is found
                if (index != -1) {
                    // Update the fields of the medical record
                    medicalRecords.get(index).setPatientName(textField_1.getText());
                    medicalRecords.get(index).setDiagnosis(textField_2.getText());
                    medicalRecords.get(index).setTreatment(textField_3.getText());
                    // Update the text area to display the updated information
                    JTextArea textArea = new JTextArea();
                    for (MedicalRecord record : medicalRecords) {
                        textArea.append(record.toString() + "\n");
                    }
                    scrollPane.setViewportView(textArea);
                    // Display a success message
                    textArea.append("Record updated successfully.\n");
                    
                } else {
                    // Display an error message if the record ID is not found
                    JTextArea textArea = new JTextArea();
                    for (MedicalRecord record : medicalRecords) {
                        textArea.append(record.toString() + "\n");
                    }
                    scrollPane.setViewportView(textArea);
                    textArea.append("Record ID not found.\n");
                }
            }
        });


        btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnUpdate.setBounds(155, 339, 115, 51);
        frmMedicalRecords.getContentPane().add(btnUpdate);
        
        btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the record ID from the text field
                int recordIDToDelete = Integer.parseInt(textField.getText());
                
                // Find the index of the record with the specified record ID
                int index = -1;
                for (int i = 0; i < medicalRecords.size(); i++) {
                    if (medicalRecords.get(i).getRecordId() == recordIDToDelete) {
                        index = i;
                        break;
                    }
                }
                
                // If the record ID is found
                if (index != -1) {
                    // Remove the record from the list
                    medicalRecords.remove(index);
                    // Clear all text fields
                    textField.setText("");
                    textField_1.setText("");
                    textField_2.setText("");
                    textField_3.setText("");
                    // Clear the text area
                    JTextArea textArea = new JTextArea();
                    scrollPane.setViewportView(textArea);
                    // Display a success message
                    textArea.append("Record deleted successfully.\n");
                } else {
                    // Display an error message if the record ID is not found
                    JTextArea textArea = new JTextArea();
                    for (MedicalRecord record : medicalRecords) {
                        textArea.append(record.toString() + "\n");
                    }
                    scrollPane.setViewportView(textArea);
                    textArea.append("Record ID not found.\n");
                }
            }
        });


        btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnDelete.setBounds(107, 426, 115, 51);
        frmMedicalRecords.getContentPane().add(btnDelete);
        
        btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Dispose of the current MedicalRecordWindow frame
                frmMedicalRecords.dispose();
                
                // Create and show the Receptionist_GUI window
                Receptionist_GUI receptionistGUI = new Receptionist_GUI();
                receptionistGUI.frame.setVisible(true);
            }
        });
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnBack.setBounds(253, 426, 115, 51);
        frmMedicalRecords.getContentPane().add(btnBack);
        
        btnSearch = new JButton("Search");
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the record ID from the text field
                int searchRecordID = Integer.parseInt(textField.getText());
                
                // Check if the record ID exists in the list
                boolean found = false;
                for (MedicalRecord record : medicalRecords) {
                    if (record.getRecordId() == searchRecordID) {
                        // Record found, print its information
                        textArea.setText(""); // Clear previous content
                        textArea.append("Record ID: " + record.getRecordId() + "\n");
                        textArea.append("Patient Name: " + record.getPatientName() + "\n");
                        textArea.append("Diagnosis: " + record.getDiagnosis() + "\n");
                        textArea.append("Treatment: " + record.getTreatment() + "\n");
                        textArea.append("Date: " + record.getDate() + "\n");
                        found = true;
                        break;
                    }
                }
                
                // If the record ID is not found, display an error message
                if (!found) {
                    textArea.setText("Record ID not found");
                }
            }
        });

        btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnSearch.setBounds(287, 339, 115, 51);
        frmMedicalRecords.getContentPane().add(btnSearch);
        
        JFormattedTextField formattedTextField = new JFormattedTextField();
        formattedTextField.setBounds(451, 20, 231, 457);
        frmMedicalRecords.getContentPane().add(formattedTextField);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(451, 20, 231, 457);
        frmMedicalRecords.getContentPane().add(scrollPane);
        
        JButton btnAdd = new JButton("Add");
        btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnAdd.setBounds(22, 339, 115, 51);
        frmMedicalRecords.getContentPane().add(btnAdd);
    }

    // Create a MaskFormatter for the date field
    protected MaskFormatter createFormatter(String format) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(format);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return formatter;
    }
    public void setVisible(boolean visible) {
    	frmMedicalRecords.setVisible(visible);
    }
}
