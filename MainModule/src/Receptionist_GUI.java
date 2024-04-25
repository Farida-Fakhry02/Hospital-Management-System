import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Receptionist_GUI {

    public static JFrame frmReceptionist;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Receptionist_GUI window = new Receptionist_GUI();
                    window.frmReceptionist.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Receptionist_GUI() {
        initialize();
    }

    private void initialize() {
        frmReceptionist = new JFrame();
        frmReceptionist.setTitle("Receptionist");
        frmReceptionist.getContentPane().setBackground(new Color(135,206,250));
        frmReceptionist.setBounds(100, 100, 600, 454);
        frmReceptionist.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmReceptionist.getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Welcome !");
        lblNewLabel.setFont(new Font("Monotype Corsiva", Font.PLAIN, 30));
        lblNewLabel.setBounds(229, 11, 128, 80);
        frmReceptionist.getContentPane().add(lblNewLabel);
        
        JButton btnNewButton = new JButton("Doctor");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton.setBounds(28, 101, 175, 59);
        frmReceptionist.getContentPane().add(btnNewButton);
        
        JButton btnBilling = new JButton("Billing");
        btnBilling.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnBilling.setBounds(371, 102, 175, 59);
        frmReceptionist.getContentPane().add(btnBilling);
        
        JButton btnInventory = new JButton("Inventory");
        btnInventory.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnInventory.setBounds(28, 212, 175, 59);
        frmReceptionist.getContentPane().add(btnInventory);
        
        JButton btnAppointment = new JButton("Appointment");
        btnAppointment.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnAppointment.setBounds(371, 212, 175, 59);
        frmReceptionist.getContentPane().add(btnAppointment);
        
        JButton btnPatient = new JButton("Patient");
        btnPatient.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnPatient.setBounds(28, 334, 175, 59);
        frmReceptionist.getContentPane().add(btnPatient);
        
        JButton btnMedicalRecoreds = new JButton("Medical Records");
        btnMedicalRecoreds.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnMedicalRecoreds.setBounds(371, 334, 180, 59);
        frmReceptionist.getContentPane().add(btnMedicalRecoreds);
        
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Doctorwindow doctorWindow = new Doctorwindow();
                doctorWindow.getFrame().setVisible(true);
            }
        });
        
        btnBilling.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Billingwindow billingWindow = new Billingwindow();
                billingWindow.getFrame().setVisible(true);
            }
        });
        
        btnInventory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InventoryControlGUI inventoryWindow = new InventoryControlGUI();
                inventoryWindow.setVisible(true);
            }
        });
        
        btnAppointment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AppointmentWindow appointmentWindow = new AppointmentWindow();
                appointmentWindow.frmAppointment.setVisible(true); // Corrected
            }
        });

        
        btnPatient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Patientwindow patientWindow = new Patientwindow();
                patientWindow.frame.setVisible(true);
            }
        });
        
        btnMedicalRecoreds.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MedicalRecordWindow medicalRecordWindow = new MedicalRecordWindow();
                medicalRecordWindow.frmMedicalRecords.setVisible(true);
            }
        });

        
    }

    public JFrame getFrame() {
        return frmReceptionist;
    }
}
