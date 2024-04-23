import java.awt.EventQueue;
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

    /**
     * Launch the application.
     */
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
        
        btnUpdate = new JButton("Update");
        btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnUpdate.setBounds(155, 339, 115, 51);
        frmMedicalRecords.getContentPane().add(btnUpdate);
        
        btnDelete = new JButton("Delete");
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
        btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnSearch.setBounds(287, 339, 115, 51);
        frmMedicalRecords.getContentPane().add(btnSearch);
        
        JFormattedTextField formattedTextField = new JFormattedTextField();
        formattedTextField.setBounds(444, 20, 231, 457);
        frmMedicalRecords.getContentPane().add(formattedTextField);
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
