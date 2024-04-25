import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.awt.Color;

public class Patientwindow {

    public JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JComboBox<String> dayComboBox;
    private JComboBox<String> monthComboBox;
    private JComboBox<String> yearComboBox;
    private JTextField textField_2;
    private JTextField textField_3;
    private JSpinner heightSpinner;
    private JSpinner weightSpinner;
    private JTextArea textArea;
    private JTextField textField_4; // For patient ID
    private Patient patient;
    private int nextId = 1; // Next available ID
    private JLabel errorLabel; // Label to display error messages

    // Error dialog frame and label
    private JFrame errorFrame;
    private JLabel errorDialogLabel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Patientwindow window = new Patientwindow();
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
    public Patientwindow() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(135,206,250));
        frame.setTitle("Patient");
        frame.setBounds(100, 100, 617, 630);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("First name");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel.setBounds(10, 37, 103, 20);
        frame.getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(172, 37, 139, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Last name");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_1.setBounds(350, 37, 103, 20);
        frame.getContentPane().add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(441, 38, 139, 20);
        frame.getContentPane().add(textField_1);

        JLabel lblNewLabel_2 = new JLabel("Birth date");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_2.setBounds(10, 95, 103, 21);
        frame.getContentPane().add(lblNewLabel_2);

        dayComboBox = new JComboBox<>();
        dayComboBox.setMaximumRowCount(31);
        for (int i = 1; i <= 31; i++) {
            dayComboBox.addItem(String.valueOf(i));
        }
        dayComboBox.setBounds(172, 94, 49, 22);
        frame.getContentPane().add(dayComboBox);

        monthComboBox = new JComboBox<>();
        monthComboBox.addItem("January");
        monthComboBox.addItem("February");
        monthComboBox.addItem("March");
        monthComboBox.addItem("April");
        monthComboBox.addItem("May");
        monthComboBox.addItem("June");
        monthComboBox.addItem("July");
        monthComboBox.addItem("August");
        monthComboBox.addItem("September");
        monthComboBox.addItem("October");
        monthComboBox.addItem("November");
        monthComboBox.addItem("December");
        monthComboBox.setBounds(231, 94, 98, 22);
        frame.getContentPane().add(monthComboBox);

        yearComboBox = new JComboBox<>();
        int currentYear = java.time.Year.now().getValue();
        for (int i = currentYear; i >= currentYear - 100; i--) {
            yearComboBox.addItem(String.valueOf(i));
        }
        yearComboBox.setBounds(341, 94, 75, 22);
        frame.getContentPane().add(yearComboBox);

        JLabel lblNewLabel_3 = new JLabel("Gender");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_3.setBounds(10, 129, 103, 19);
        frame.getContentPane().add(lblNewLabel_3);

        JRadioButton rdbtnMale = new JRadioButton("Male");
        rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 15));
        rdbtnMale.setBackground(new Color(135,206,250));
        rdbtnMale.setBounds(172, 125, 70, 23);
        frame.getContentPane().add(rdbtnMale);

        JRadioButton rdbtnFemale = new JRadioButton("Female");
        rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 15));
        rdbtnFemale.setBackground(new Color(135,206,250));
        rdbtnFemale.setBounds(241, 125, 103, 23);
        frame.getContentPane().add(rdbtnFemale);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(rdbtnMale);
        genderGroup.add(rdbtnFemale);

        JLabel lblNewLabel_4 = new JLabel("Address");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_4.setBounds(10, 164, 103, 14);
        frame.getContentPane().add(lblNewLabel_4);

        textField_2 = new JTextField();
        textField_2.setBounds(172, 164, 187, 20);
        frame.getContentPane().add(textField_2);
        textField_2.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("Phone number");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_5.setBounds(10, 199, 113, 28);
        frame.getContentPane().add(lblNewLabel_5);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(172, 206, 139, 20);
        frame.getContentPane().add(textField_3);

        JLabel lblNewLabel_6 = new JLabel("Height");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_6.setBounds(10, 238, 103, 27);
        frame.getContentPane().add(lblNewLabel_6);

        SpinnerNumberModel heightModel = new SpinnerNumberModel(0, 0, 300, 1); // Change the range and step size as needed
        heightSpinner = new JSpinner(heightModel);
        heightSpinner.setBounds(172, 238, 49, 20);
        frame.getContentPane().add(heightSpinner);


        JLabel lblNewLabel_7 = new JLabel("Weight");
        lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_7.setBounds(10, 276, 103, 21);
        frame.getContentPane().add(lblNewLabel_7);

        SpinnerNumberModel weightModel = new SpinnerNumberModel(0, 0, 500, 1); // Change the range and step size as needed
        weightSpinner = new JSpinner(weightModel);
        weightSpinner.setBounds(172, 276, 49, 20);
        frame.getContentPane().add(weightSpinner);
        
        JLabel lblId = new JLabel("ID");
        lblId.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblId.setBounds(10, 65, 34, 19);
        frame.getContentPane().add(lblId);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(172, 64, 59, 20);
        frame.getContentPane().add(textField_4);

        JButton btnNewButton = new JButton("Add");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton.setBounds(31, 318, 125, 46);
        frame.getContentPane().add(btnNewButton);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnUpdate.setBounds(31, 459, 125, 46);
        frame.getContentPane().add(btnUpdate);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnDelete.setBounds(191, 318, 125, 46);
        frame.getContentPane().add(btnDelete);

        JButton btnPrintDetails = new JButton("Print Details");
        btnPrintDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnPrintDetails.setBounds(31, 391, 125, 46);
        frame.getContentPane().add(btnPrintDetails);

        JButton btnBmi = new JButton("BMI");
        btnBmi.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnBmi.setBounds(195, 391, 125, 46);
        frame.getContentPane().add(btnBmi);

        JButton btnAgeCategory = new JButton("Age Category");
        btnAgeCategory.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnAgeCategory.setBounds(195, 459, 125, 46);
        frame.getContentPane().add(btnAgeCategory);
        
        // Create and add a label for displaying error messages
        errorLabel = new JLabel("");
        errorLabel.setForeground(Color.RED); // Set color to red
        errorLabel.setBounds(172, 10, 400, 20); // Adjust the position and size as needed
        frame.getContentPane().add(errorLabel);

        // JTextArea and JScrollPane
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(369, 130, 217, 439);
        frame.getContentPane().add(scrollPane);
        
                textArea = new JTextArea();
                scrollPane.setViewportView(textArea);

        
        
        JButton btnNewButton_2_1_1_1 = new JButton("Clear");
        btnNewButton_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_2_1_1_1.setBounds(31, 523, 125, 46);
        frame.getContentPane().add(btnNewButton_2_1_1_1);
        
        JLabel lblNewLabel_8 = new JLabel("cm");
        lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_8.setBounds(231, 237, 49, 14);
        frame.getContentPane().add(lblNewLabel_8);
        
        JLabel lblNewLabel_8_1 = new JLabel("Kg");
        lblNewLabel_8_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_8_1.setBounds(231, 276, 49, 21);
        frame.getContentPane().add(lblNewLabel_8_1);
        
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Dispose of the current frame
                frame.dispose();
                
                // Create and show the Receptionist_GUI window
                Receptionist_GUI receptionistGUI = new Receptionist_GUI();
                receptionistGUI.frmReceptionist.setVisible(true);
            }
        });

        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnBack.setBounds(195, 523, 125, 46);
        frame.getContentPane().add(btnBack);
        


     // ActionListener for Clear button
        btnNewButton_2_1_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearAllFields();
                textArea.setText(""); // Clear the text area as well
            }
            
            private void clearAllFields() {
                textField.setText("");
                textField_1.setText("");
                dayComboBox.setSelectedIndex(0);
                monthComboBox.setSelectedIndex(0);
                yearComboBox.setSelectedIndex(0);
                rdbtnMale.setSelected(false);
                rdbtnFemale.setSelected(false);
                textField_2.setText("");
                textField_3.setText("");
                heightSpinner.setValue(0);
                weightSpinner.setValue(0);
                textField_4.setText(""); 
            }

        });

        
 
     // ActionListener for Update button
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (patient != null) {
                    // Get the identifier of the patient to update
                    int idToUpdate;
                    try {
                        idToUpdate = Integer.parseInt(textField_4.getText());
                    } catch (NumberFormatException ex) {
                        showError("Invalid ID format. ID must be an integer.");
                        return;
                    }
                    
                    // Get the instance of PatientDataModel
                    PatientDataModel dataModel = PatientDataModel.getInstance();
                    
                    // Get the list of patients
                    ArrayList<Patient> patientList = dataModel.getPatients();
                    
                    // Check if the patient with the given ID exists in the list
                    boolean patientFound = false;
                    for (Patient p : patientList) {
                        if (p.getId() == idToUpdate) {
                            patientFound = true;
                            break;
                        }
                    }
                    
                    if (!patientFound) {
                        showError("Patient with ID " + idToUpdate + " not found. Cannot update.");
                        return;
                    }
                    
                    // Validation for height and weight can be kept here as before
                    
                    // Update patient details
                    patient.setFirstName(textField.getText());
                    patient.setLastName(textField_1.getText());
                    int day = Integer.parseInt((String) dayComboBox.getSelectedItem());
                    String month = (String) monthComboBox.getSelectedItem();
                    int year = Integer.parseInt((String) yearComboBox.getSelectedItem());
                    patient.setDateOfBirth(LocalDate.of(year, Month.valueOf(month.toUpperCase()), day));
                    patient.setGender(rdbtnMale.isSelected() ? "Male" : "Female");
                    patient.setAddress(textField_2.getText());
                    patient.setPhoneNumber(textField_3.getText());
                    patient.setHeight((int) heightSpinner.getValue());
                    patient.setWeight((int) weightSpinner.getValue());

                    // Update GUI components with updated patient details
                    textField.setText(patient.getFirstName());
                    textField_1.setText(patient.getLastName());
                    String[] dateParts = patient.getDateOfBirth().toString().split("-");
                    dayComboBox.setSelectedItem(dateParts[2]);
                    monthComboBox.setSelectedItem(dateParts[1]);
                    yearComboBox.setSelectedItem(dateParts[0]);
                    if (patient.getGender().equals("Male")) {
                        rdbtnMale.setSelected(true);
                        rdbtnFemale.setSelected(false);
                    } else {
                        rdbtnMale.setSelected(false);
                        rdbtnFemale.setSelected(true);
                    }
                    textField_2.setText(patient.getAddress());
                    textField_3.setText(patient.getPhoneNumber());
                    heightSpinner.setValue(patient.getHeight());
                    weightSpinner.setValue(patient.getWeight());

                    textArea.append("Patient details updated successfully.\n");
                } else {
                    textArea.append("No patient data to update.\n");
                }
            }
        });




     // ActionListener for Delete button
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the identifier of the patient to delete
                String idToDelete = textField_4.getText(); // Assuming the ID is entered as text

                // Get the instance of PatientDataModel
                PatientDataModel dataModel = PatientDataModel.getInstance();

                // Get the list of patients
                ArrayList<Patient> patientList = dataModel.getPatients();

                // Iterate through the list to find the patient with the matching ID
                for (Patient patient : patientList) {
                    if (String.valueOf(patient.getId()).equals(idToDelete)) {
                        // Remove the patient from the list
                        patientList.remove(patient);

                        // Display message indicating successful deletion
                        JOptionPane.showMessageDialog(frame, "Patient successfully deleted.");

                        // Break the loop after the patient is found and removed
                        break;
                    }
                }
            }
        });


        // ActionListener for Print Details button
        btnPrintDetails.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the instance of PatientDataModel
                PatientDataModel dataModel = PatientDataModel.getInstance();

                // Get the list of patients
                ArrayList<Patient> patientList = dataModel.getPatients();

                // Clear previous content
                textArea.setText("");

                if (!patientList.isEmpty()) {
                    // Print patient details in JTextArea
                    textArea.append("Patient Details:\n");
                    for (Patient patient : patientList) {
                        textArea.append("Name: " + patient.getFirstName() + " " + patient.getLastName() + "\n");
                        textArea.append("ID: " + patient.getId() + "\n");
                        textArea.append("Date of Birth: " + patient.getDateOfBirth().toString() + "\n");
                        textArea.append("Gender: " + patient.getGender() + "\n");
                        textArea.append("Address: " + patient.getAddress() + "\n");
                        textArea.append("Phone Number: " + patient.getPhoneNumber() + "\n");
                        textArea.append("Height: " + patient.getHeight() + " cm\n");
                        textArea.append("Weight: " + patient.getWeight() + " kg\n");
                        textArea.append("\n");
                    }
                } else {
                    textArea.setText("No patient data available to print.");
                }
            }
        });

        // ActionListener for BMI button
        btnBmi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (patient != null) {
                    textArea.append("BMI: " + patient.calculateBMI() + "\n");
                } else {
                    textArea.append("No patient data available to calculate BMI.\n");
                }
            }
        });

        // ActionListener for Age Category button
        btnAgeCategory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (patient != null) {
                    textArea.append("Age category: " + patient.getAgeCategory() + "\n");
                } else {
                    textArea.append("No patient data available to determine age category.\n");
                }
            }
        });


     // ActionListener for Add button
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Check if all mandatory fields are filled
                if (textField.getText().isEmpty()) {
                    showError("First name is mandatory.");
                    return;
                }
                if (textField_1.getText().isEmpty()) {
                    showError("Last name is mandatory.");
                    return;
                }
                if (textField_4.getText().isEmpty()) {
                    showError("ID is mandatory.");
                    return;
                }
                
                if (!rdbtnMale.isSelected() && !rdbtnFemale.isSelected()) {
                    showError("Gender is mandatory.");
                    return;
                }
                if (textField_3.getText().isEmpty()) {
                    showError("Phone number is mandatory.");
                    return;
                }

                // Check if ID is valid
                String idText = textField_4.getText();
                try {
                    int id = Integer.parseInt(idText);
                    // Check if ID is non-negative
                    if (id < 0) {
                        showError("ID must be a non-negative integer.");
                        return;
                    }
                    // Validate height
                    double heightDouble = ((Number) heightSpinner.getValue()).doubleValue();
                    int height = (int) heightDouble;
                    if (height <= 0) {
                        showError("Height must be a positive integer.");
                        return;
                    }
                    
                    // Validate weight
                    double weightDouble = ((Number) weightSpinner.getValue()).doubleValue();
                    int weight = (int) weightDouble;
                    if (weight <= 0) {
                        showError("Weight must be a positive integer.");
                        return;
                    }
                    
                    // If all validation passes, proceed to create the patient object and add it
                    String firstName = textField.getText();
                    String lastName = textField_1.getText();
                    int day = Integer.parseInt((String) dayComboBox.getSelectedItem());
                    String month = (String) monthComboBox.getSelectedItem();
                    int year = Integer.parseInt((String) yearComboBox.getSelectedItem());
                    String gender = rdbtnMale.isSelected() ? "Male" : "Female";
                    String address = textField_2.getText();
                    String phoneNumber = textField_3.getText();

                    // Create and add patient object
                    patient = new Patient(firstName, lastName, LocalDate.of(year, Month.valueOf(month.toUpperCase()), day),
                            gender, address, phoneNumber, height, weight, id);

                    // Add patient to data model
                    PatientDataModel.getInstance().getPatients().add(patient);

                    textArea.append("Patient added successfully.\n");
                } catch (NumberFormatException ex) {
                    showError("Invalid ID format. ID must be an integer.");
                    return;
                }
            }
        });
        }

    // Method to display error message in the error label
    private void showError(String errorMessage) {
        // Create and configure error dialog frame
        errorFrame = new JFrame();
        errorFrame.setBounds(100, 100, 300, 150);
        errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        errorFrame.getContentPane().setLayout(null);

        // Create and configure error dialog label
        errorDialogLabel = new JLabel(errorMessage);
        errorDialogLabel.setForeground(Color.RED);
        errorDialogLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        errorDialogLabel.setBounds(10, 10, 300, 100);

        // Add error dialog label to error dialog frame
        errorFrame.getContentPane().add(errorDialogLabel);

        // Create and configure OK button
        JButton btnOk = new JButton("OK");
        btnOk.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnOk.setBounds(100, 80, 89, 23);
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Close the error dialog frame
                errorFrame.dispose();
            }
        });

        // Add OK button to error dialog frame
        errorFrame.getContentPane().add(btnOk);

        // Set error dialog frame visibility to true
        errorFrame.setVisible(true);
    }
}
