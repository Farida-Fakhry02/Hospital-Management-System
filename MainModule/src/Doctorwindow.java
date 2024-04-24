import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.util.LinkedList;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JOptionPane;



public class Doctorwindow {

    private JFrame frmP;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField specialityField;
    private JTextField doctorIdField;
    private JTextField emailField;
    private JTextField departmentField;
    private JTextField consultationFeeField;
    private JSpinner experienceSpinner;
    private JButton btnPrintDetails;
    private Doctor doctor;
    private JScrollPane scrollPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Doctorwindow window = new Doctorwindow();
                    window.frmP.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Doctorwindow() {
        initialize();
        doctor = new Doctor();
    }
    

    private void initialize() {
        frmP = new JFrame();
        frmP.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 20));
        frmP.getContentPane().setBackground(new Color(135,206,250));
        frmP.setTitle("Doctor");
        frmP.setBounds(100, 100, 682, 583);
        frmP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmP.getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("First name");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(10, 34, 103, 20);
        frmP.getContentPane().add(lblNewLabel);
        
        firstNameField = new JTextField();
        firstNameField.setColumns(10);
        firstNameField.setBounds(191, 26, 139, 28);
        frmP.getContentPane().add(firstNameField);
        
        JLabel lblNewLabel_1 = new JLabel("Last name");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(10, 64, 103, 20);
        frmP.getContentPane().add(lblNewLabel_1);
        
        lastNameField = new JTextField();
        lastNameField.setColumns(10);
        lastNameField.setBounds(191, 62, 139, 28);
        frmP.getContentPane().add(lastNameField);
        
        specialityField = new JTextField();
        specialityField.setColumns(10);
        specialityField.setBounds(191, 101, 139, 28);
        frmP.getContentPane().add(specialityField);
        
        JLabel lblSpeciality = new JLabel("Speciality");
        lblSpeciality.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblSpeciality.setBounds(10, 101, 103, 28);
        frmP.getContentPane().add(lblSpeciality);
        
        JLabel lblNewLabel_3 = new JLabel("DoctorId");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_3.setBounds(10, 150, 103, 20);
        frmP.getContentPane().add(lblNewLabel_3);
        
        doctorIdField = new JTextField();
        doctorIdField.setColumns(10);
        doctorIdField.setBounds(191, 142, 139, 28);
        frmP.getContentPane().add(doctorIdField);
        
        JLabel lblNewLabel_4 = new JLabel("Email-Address");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_4.setBounds(10, 189, 139, 21);
        frmP.getContentPane().add(lblNewLabel_4);
        
        emailField = new JTextField();
        emailField.setColumns(10);
        emailField.setBounds(191, 182, 139, 28);
        frmP.getContentPane().add(emailField);
        
        JLabel lblNewLabel_5 = new JLabel("Experience Years");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_5.setBounds(10, 220, 171, 28);
        frmP.getContentPane().add(lblNewLabel_5);
        
        JLabel lblNewLabel_7 = new JLabel("Department");
        lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_7.setBounds(10, 258, 151, 20);
        frmP.getContentPane().add(lblNewLabel_7);
        
        departmentField = new JTextField();
        departmentField.setColumns(10);
        departmentField.setBounds(191, 259, 139, 28);
        frmP.getContentPane().add(departmentField);
        
        JLabel lblNewLabel_8 = new JLabel("Consultation fee");
        lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_8.setBounds(10, 300, 151, 20);
        frmP.getContentPane().add(lblNewLabel_8);
        
        consultationFeeField = new JTextField();
        consultationFeeField.setColumns(10);
        consultationFeeField.setBounds(191, 301, 139, 28);
        frmP.getContentPane().add(consultationFeeField);
        
        JButton btnNewButton = new JButton("Add");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isValidDoctorId() && isValidExperienceYears((int) experienceSpinner.getValue())) {
                    addDoctor();
                } else {
                    displayErrorMessage("Invalid input");
                }
            }
        });

        btnNewButton.setBounds(36, 343, 125, 46);
        frmP.getContentPane().add(btnNewButton);
        
        JButton btnUpdate = new JButton("Update");
        btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnUpdate.setBounds(36, 401, 125, 46);
        frmP.getContentPane().add(btnUpdate);
        
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Update doctor details
                String doctorIdToUpdate = doctorIdField.getText();

                // Get the instance of DoctorDataModel
                DoctorDataModel dataModel = DoctorDataModel.getInstance();

                // Get the list of doctors
                LinkedList<Doctor> doctorList = dataModel.getDoctors();

                // Iterate through the list to find the doctor with the matching ID
                for (Doctor currentDoctor : doctorList) {
                    if (currentDoctor.getDoctorID().equals(doctorIdToUpdate)) {
                        currentDoctor.setFirstName(firstNameField.getText());
                        currentDoctor.setLastName(lastNameField.getText());
                        currentDoctor.setSpecialty(specialityField.getText());
                        currentDoctor.setDoctorID(doctorIdField.getText());
                        currentDoctor.setEmailAddress(emailField.getText());
                        currentDoctor.setDepartment(departmentField.getText());

                        // Validate and set experience years
                        int experienceYears;
                        try {
                            experienceYears = Integer.parseInt(experienceSpinner.getValue().toString());
                            if (experienceYears < 0) {
                                displayErrorMessage("Experience years must be positive");
                                return;
                            }
                            currentDoctor.setExperienceYears(experienceYears);
                        } catch (NumberFormatException ex) {
                            displayErrorMessage("Invalid experience years");
                            return;
                        }

                        // Validate and set consultation fee
                        double consultationFee;
                        try {
                            consultationFee = Double.parseDouble(consultationFeeField.getText());
                            if (consultationFee < 0) {
                                displayErrorMessage("Consultation fee must be positive");
                                return;
                            }
                            currentDoctor.setConsultationFee(consultationFee);
                        } catch (NumberFormatException ex) {
                            displayErrorMessage("Invalid consultation fee");
                            return;
                        }

                        // Display success message
                        JTextArea textArea = (JTextArea) scrollPane.getViewport().getView();
                        textArea.append("Updated successfully.\n");

                        // Break the loop after the doctor is found and updated
                        break;
                    }
                }
            }
        });



        
        JButton btnDelete = new JButton("Delete");
        btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnDelete.setBounds(191, 401, 125, 46);
        frmP.getContentPane().add(btnDelete);

        // Method to clear input fields
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the selected doctor's ID
                String doctorIDToDelete = doctorIdField.getText();

                // Get the instance of DoctorDataModel
                DoctorDataModel dataModel = DoctorDataModel.getInstance();

                // Get the list of doctors
                LinkedList<Doctor> doctorList = dataModel.getDoctors();

                // Iterate through the list to find the doctor with the matching ID
                for (Doctor currentDoctor : doctorList) {
                    if (currentDoctor.getDoctorID().equals(doctorIDToDelete)) {
                        // Remove the current doctor from the list
                        doctorList.remove(currentDoctor);

                        // Optionally, update the GUI to reflect the changes
                        // For example, clear the input fields
                        clearInputFields();

                        // Display success message
                        JTextArea textArea = (JTextArea) scrollPane.getViewport().getView();
                        textArea.append("Doctor deleted successfully.\n");

                        // Break the loop after the doctor is found and removed
                        break;
                    }
                }
            }

            private void clearInputFields() {
                firstNameField.setText("");
                lastNameField.setText("");
                specialityField.setText("");
                doctorIdField.setText("");
                emailField.setText("");
                departmentField.setText("");
                consultationFeeField.setText("");
                // Clear any other fields if needed
            }
        });


        
        JButton btnExit = new JButton("Back");
        btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnExit.setBounds(191, 457, 125, 46);
        frmP.getContentPane().add(btnExit);

        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Close the current doctor window
                frmP.dispose();

                // Show the receptionist window
                Receptionist_GUI receptionistWindow = new Receptionist_GUI();
                receptionistWindow.getFrame().setVisible(true);
            }
        });

        
        experienceSpinner = new JSpinner();
        experienceSpinner.setBounds(191, 220, 51, 29);
        frmP.getContentPane().add(experienceSpinner);
        
        btnPrintDetails = new JButton("Print details");
        btnPrintDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnPrintDetails.setBounds(191, 343, 125, 46);
        btnPrintDetails.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                printDoctorDetails();
            }
        });

        frmP.getContentPane().add(btnPrintDetails);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(382, 26, 256, 483);
        frmP.getContentPane().add(scrollPane);
        
        JTextArea textArea = new JTextArea();
        scrollPane.setViewportView(textArea);
        
        JButton btnClear = new JButton("Clear");
        btnClear.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		clearInputFields(); 
        	}
        });
        
        btnClear.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnClear.setBounds(36, 457, 125, 46);
        frmP.getContentPane().add(btnClear);
    }
    
 
 // Method to clear input fields
    private void clearInputFields() {
        firstNameField.setText("");
        lastNameField.setText("");
        specialityField.setText("");
        doctorIdField.setText("");
        emailField.setText("");
        departmentField.setText("");
        consultationFeeField.setText("");
        experienceSpinner.setValue(0); // Reset spinner value
    }
    
    private void addDoctor() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String specialty = specialityField.getText();
        String doctorId = doctorIdField.getText();
        String email = emailField.getText();
        String department = departmentField.getText();
        double consultationFee = Double.parseDouble(consultationFeeField.getText());
        int experienceYears = (int) experienceSpinner.getValue();
        
        Doctor doctorToAdd = new Doctor(firstName, lastName, specialty, "", doctorId, email, experienceYears, department, consultationFee, new ArrayList<>());
        DoctorDataModel dataModel = DoctorDataModel.getInstance();
        dataModel.getDoctors().add(doctorToAdd);

        // Update success label
        JTextArea textArea = (JTextArea) scrollPane.getViewport().getView();
        textArea.append("Doctor added successfully.\n");
    }

    
    
    private void printDoctorDetails() {
        DoctorDataModel dataModel = DoctorDataModel.getInstance();
        LinkedList<Doctor> doctors = dataModel.getDoctors();
        StringBuilder details = new StringBuilder("Doctor Details:\n");

        for (Doctor doctor : doctors) {
            details.append("First Name: ").append(doctor.getFirstName()).append("\n");
            details.append("Last Name: ").append(doctor.getLastName()).append("\n");
            details.append("Specialty: ").append(doctor.getSpecialty()).append("\n");
            details.append("Doctor ID: ").append(doctor.getDoctorID()).append("\n");
            details.append("Email Address: ").append(doctor.getEmailAddress()).append("\n");
            details.append("Experience Years: ").append(doctor.getExperienceYears()).append("\n");
            details.append("Department: ").append(doctor.getDepartment()).append("\n");
            details.append("Consultation Fee: $").append(doctor.getConsultationFee()).append("\n\n");
        }
        
        JTextArea textArea = (JTextArea) scrollPane.getViewport().getView();
        textArea.setText(details.toString());
    }


    public JFrame getFrame() {
        return frmP;
    }
    private boolean isValidDoctorId() {
        String doctorId = doctorIdField.getText();
        return doctorId.matches("\\d+");
    }
    private void displayErrorMessage(String message) {
        // Display the error message in a dialog box
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    private boolean isValidExperienceYears(int experienceYears) {
        if (experienceYears < 0) {
            displayErrorMessage("Experience year must be positive");
            return false;
        }
        return true;
    }

}
