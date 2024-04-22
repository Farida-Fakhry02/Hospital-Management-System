import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.List;
import javax.swing.JTextArea;

public class AppointmentWindow {

    private JFrame frame;
    private JTextField textField;
    private JComboBox<Integer> dayComboBox;
    private JComboBox<String> monthComboBox;
    private JComboBox<Integer> yearComboBox;
    private AppointmentManager appointmentManager;
    private JTextArea textArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppointmentWindow window = new AppointmentWindow();
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
    public AppointmentWindow() {
        appointmentManager = new AppointmentManager();
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 708, 611);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Date");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(57, 42, 65, 42);
        frame.getContentPane().add(lblNewLabel);
        
        JLabel lblDoctor = new JLabel("Doctor");
        lblDoctor.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblDoctor.setBounds(57, 105, 65, 42);
        frame.getContentPane().add(lblDoctor);
        
        JLabel lblPatient = new JLabel("Patient ID ");
        lblPatient.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPatient.setBounds(57, 172, 112, 42);
        frame.getContentPane().add(lblPatient);
        
        JLabel lblSlot = new JLabel("Slot");
        lblSlot.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblSlot.setBounds(57, 239, 65, 42);
        frame.getContentPane().add(lblSlot);
        
        // Day ComboBox
        dayComboBox = new JComboBox<>();
        dayComboBox.setBounds(187, 60, 46, 21);
        frame.getContentPane().add(dayComboBox);
        
        // Month ComboBox
        monthComboBox = new JComboBox<>(new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"});
        monthComboBox.setBounds(243, 60, 73, 21);
        frame.getContentPane().add(monthComboBox);
        
        // Year ComboBox
        yearComboBox = new JComboBox<>();
        for (int year = 2024; year <= 2100; year++) {
            yearComboBox.addItem(year);
        }
        yearComboBox.setSelectedItem(2024); // Default year is 2024
        yearComboBox.setBounds(326, 60, 73, 21);
        frame.getContentPane().add(yearComboBox);
        
        textField = new JTextField();
        textField.setBounds(187, 184, 82, 28);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        // Add key listener to validate input
        textField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    e.consume();  // ignore non-numeric input
                }
            }
        });
        
        JComboBox comboBox_3 = new JComboBox();
        comboBox_3.setBounds(187, 250, 137, 28);
        frame.getContentPane().add(comboBox_3);
        
        JButton btnNewButton = new JButton("Add");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton.setBounds(57, 343, 112, 42);
        frame.getContentPane().add(btnNewButton);
        
        JButton btnUpdate = new JButton("Update");
        btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnUpdate.setBounds(202, 343, 112, 42);
        frame.getContentPane().add(btnUpdate);
        
        JButton btnNewButton_1_1 = new JButton("Back");
        btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_1_1.setBounds(495, 343, 112, 42);
        frame.getContentPane().add(btnNewButton_1_1);
        
        JButton btnCancel = new JButton("Cancel");
        btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnCancel.setBounds(350, 343, 112, 42);
        frame.getContentPane().add(btnCancel);
        
        JButton btnPrintDetails = new JButton("Print Details");
        btnPrintDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnPrintDetails.setBounds(57, 430, 122, 42);
        frame.getContentPane().add(btnPrintDetails);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(202, 419, 396, 113);
        frame.getContentPane().add(scrollPane);
        
        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);
        
        JComboBox<Integer> dayComboBox_1 = new JComboBox<Integer>();
        dayComboBox_1.setBounds(187, 123, 112, 21);
        frame.getContentPane().add(dayComboBox_1);
        
        // Add action listeners to month and year JComboBoxes
        monthComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateDayComboBox();
            }
        });
        
        yearComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateDayComboBox();
            }
        });
        
        // Initialize day JComboBox
        updateDayComboBox();
        
        // Action listener for Add button
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get selected date
                int day = (int) dayComboBox.getSelectedItem();
                int monthIndex = monthComboBox.getSelectedIndex() + 1;
                int year = (int) yearComboBox.getSelectedItem();
                
                // Create LocalDateTime object for appointment date and time
                LocalDateTime dateTime = LocalDateTime.of(year, monthIndex, day, 0, 0);
                
                // Sample doctor and patient parameters (modify as needed)
                String doctorFirstName = "John";
                String doctorLastName = "Doe";
                String doctorSpecialty = "General Physician";
                String doctorPhoneNumber = "1234567890";
                String doctorID = "DOC123";
                String doctorEmailAddress = "john.doe@example.com";
                int doctorExperienceYears = 5;
                String doctorDepartment = "Internal Medicine";
                double consultationFee = 50.0;
                List<String> doctorAvailability = Arrays.asList("Monday 9:00 AM - 11:00 AM", "Tuesday 2:00 PM - 4:00 PM");

                Doctor doctor = new Doctor(doctorFirstName, doctorLastName, doctorSpecialty, doctorPhoneNumber, doctorID, doctorEmailAddress, doctorExperienceYears, doctorDepartment, consultationFee, doctorAvailability);
                
                int patientID = Integer.parseInt(textField.getText()); // Assuming patient ID is entered in the text field
                
                // Sample patient parameters (modify as needed)
                String patientFirstName = "Alice";
                String patientLastName = "Smith";
                LocalDate patientDateOfBirth = LocalDate.of(1990, 5, 15);
                String patientGender = "Female";
                String patientAddress = "123 Main St, City";
                String patientPhoneNumber = "9876543210";
                double patientHeight = 165.0;
                double patientWeight = 60.0;

                Patient patient = new Patient(patientFirstName, patientLastName, patientDateOfBirth, patientGender, patientAddress, patientPhoneNumber, patientHeight, patientWeight, patientID);
                
                // Create an appointment
                Appointment appointment = new Appointment(dateTime, doctor, patient);
                
                // Add the appointment to the manager
                appointmentManager.addAppointment(appointment);
                
                // Append confirmation to the text area
                textArea.append("Appointment added: \n");
                textArea.append("Date: " + dateTime.toString() + "\n");
                textArea.append("Doctor: " + doctor.getFirstName() +' '+ doctor.getLastName() + "\n");
                textArea.append("Patient ID: " + patientID + "\n");
                textArea.append("---------------\n");
            }
        });
    }
    
    // Method to update day JComboBox options based on the selected month and year
    private void updateDayComboBox() {
        int monthIndex = monthComboBox.getSelectedIndex();
        int year = (int) yearComboBox.getSelectedItem();
        int daysInMonth = YearMonth.of(year, monthIndex + 1).lengthOfMonth(); // Get the number of days in the selected month
        dayComboBox.removeAllItems();
        for (int day = 1; day <= daysInMonth; day++) {
            dayComboBox.addItem(day);
        }
    }
}
