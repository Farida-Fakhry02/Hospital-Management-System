import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class Patientwindow {

    private JFrame frame;
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
        frame.setTitle("Patient");
        frame.setBounds(100, 100, 617, 687);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("First name");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel.setBounds(10, 37, 103, 14);
        frame.getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(172, 37, 139, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Last name");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_1.setBounds(350, 37, 103, 14);
        frame.getContentPane().add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(441, 38, 139, 20);
        frame.getContentPane().add(textField_1);

        JLabel lblNewLabel_2 = new JLabel("Birth date");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_2.setBounds(10, 95, 103, 14);
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
        lblNewLabel_3.setBounds(10, 129, 103, 14);
        frame.getContentPane().add(lblNewLabel_3);

        JRadioButton rdbtnMale = new JRadioButton("Male");
        rdbtnMale.setBounds(172, 125, 70, 23);
        frame.getContentPane().add(rdbtnMale);

        JRadioButton rdbtnFemale = new JRadioButton("Female");
        rdbtnFemale.setBounds(241, 125, 70, 23);
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

        heightSpinner = new JSpinner();
        heightSpinner.setBounds(172, 238, 49, 20);
        frame.getContentPane().add(heightSpinner);

        JLabel lblNewLabel_7 = new JLabel("Weight");
        lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_7.setBounds(10, 276, 103, 21);
        frame.getContentPane().add(lblNewLabel_7);

        weightSpinner = new JSpinner();
        weightSpinner.setBounds(172, 276, 49, 20);
        frame.getContentPane().add(weightSpinner);

        JLabel lblId = new JLabel("ID");
        lblId.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblId.setBounds(10, 65, 34, 14);
        frame.getContentPane().add(lblId);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(172, 64, 59, 20);
        frame.getContentPane().add(textField_4);

        JButton btnNewButton = new JButton("Add");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton.setBounds(29, 311, 125, 46);
        frame.getContentPane().add(btnNewButton);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnUpdate.setBounds(186, 311, 125, 46);
        frame.getContentPane().add(btnUpdate);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnDelete.setBounds(327, 311, 125, 46);
        frame.getContentPane().add(btnDelete);

        JButton btnNewButton_2_1 = new JButton("Exit");
        btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_2_1.setBounds(186, 461, 125, 46);
        frame.getContentPane().add(btnNewButton_2_1);

        JButton btnPrintDetails = new JButton("Print Details");
        btnPrintDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnPrintDetails.setBounds(29, 384, 125, 46);
        frame.getContentPane().add(btnPrintDetails);

        JButton btnBmi = new JButton("BMI");
        btnBmi.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnBmi.setBounds(186, 384, 125, 46);
        frame.getContentPane().add(btnBmi);

        JButton btnAgeCategory = new JButton("Age Category");
        btnAgeCategory.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnAgeCategory.setBounds(327, 384, 125, 46);
        frame.getContentPane().add(btnAgeCategory);

        textArea = new JTextArea();
        textArea.setBounds(99, 540, 354, 89);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(99, 540, 354, 89);
        frame.getContentPane().add(scrollPane);

        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (patient != null) {
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

                    textArea.append("Patient details updated successfully.\n");
                } else {
                    textArea.append("No patient data to update.\n");
                }
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the identifier of the patient to delete
                String patientNameToDelete = textField.getText(); // Assuming the first name is used as the identifier

                // Get the instance of PatientDataModel
                PatientDataModel dataModel = PatientDataModel.getInstance();

                // Get the list of patients
                ArrayList<Patient> patientList = dataModel.getPatients();

                // Iterate through the list to find the patient with the matching name
                for (Patient patient : patientList) {
                    if (patient.getFirstName().equals(patientNameToDelete)) {
                        // Remove the patient from the list
                        patientList.remove(patient);
                        // Optionally, update the GUI to reflect the changes
                        // For example, clear the input fields
                        clearAllFields();
                        // Break the loop after the patient is found and removed
                        break;
                    }
                }
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
                textArea.setText("");
            }

        });

        btnNewButton_2_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

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

        btnBmi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (patient != null) {
                    textArea.append("BMI: " + patient.calculateBMI() + "\n");
                } else {
                    textArea.append("No patient data available to calculate BMI.\n");
                }
            }
        });

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstName = textField.getText();
                String lastName = textField_1.getText();
                int day = Integer.parseInt((String) dayComboBox.getSelectedItem());
                String month = (String) monthComboBox.getSelectedItem();
                int year = Integer.parseInt((String) yearComboBox.getSelectedItem());
                String gender = rdbtnMale.isSelected() ? "Male" : "Female";
                String address = textField_2.getText();
                String phoneNumber = textField_3.getText();
                double height = ((Number) heightSpinner.getValue()).doubleValue();
                double weight = ((Number) weightSpinner.getValue()).doubleValue();
                int id = Integer.parseInt(textField_4.getText()); // Assuming ID is provided in the input field

                patient = new Patient(firstName, lastName, LocalDate.of(year, Month.valueOf(month.toUpperCase()), day),
                        gender, address, phoneNumber, height, weight, id);

                // Add patient to data model
                PatientDataModel.getInstance().getPatients().add(patient);

                textArea.append("Patient added successfully.\n");
            }
        });

        btnAgeCategory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (patient != null) {
                    textArea.append("Age category: " + patient.getAgeCategory() + "\n");
                } else {
                    textArea.append("No patient data available to determine age category.\n");
                }
            }
        });
    }
}
