import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.SystemColor;

public class Login_Page {

    private JFrame frmLogin;
    private JTextField txtUsername;
    private JPasswordField passwordField;
    private JLabel lblMessage;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login_Page window = new Login_Page();
                    window.frmLogin.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Login_Page() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmLogin = new JFrame();
        frmLogin.setTitle("Login");
        frmLogin.getContentPane().setBackground(new Color(135,206,250));
        frmLogin.getContentPane().setForeground(SystemColor.activeCaption);
        frmLogin.setForeground(new Color(128, 0, 0));
        frmLogin.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 15));
        frmLogin.setBounds(100, 100, 624, 524);
        frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmLogin.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Hospital Management System");
        lblNewLabel.setFont(new Font("Monotype Corsiva", Font.PLAIN, 35));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(95, 51, 426, 55);
        frmLogin.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Username");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(94, 191, 96, 33);
        frmLogin.getContentPane().add(lblNewLabel_1);

        txtUsername = new JTextField();
        txtUsername.setToolTipText("Please enter your username");
        txtUsername.setColumns(10);
        txtUsername.setBounds(228, 191, 183, 30);
        frmLogin.getContentPane().add(txtUsername);
        
        // Set default username
        

        JLabel lblNewLabel_1_1 = new JLabel("Password");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1_1.setBounds(94, 277, 96, 33);
        frmLogin.getContentPane().add(lblNewLabel_1_1);

        JButton btnNewButton = new JButton("Login");
        btnNewButton.setBackground(new Color(240, 240, 240));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = new String(passwordField.getPassword()); // Retrieve password from password field
                if (username.equals("admin") && password.equals("1234")) { // Check if password is "1234"
                    lblMessage.setText("Correct username and password");
                    Receptionist_GUI receptionistGUI = new Receptionist_GUI();
                    receptionistGUI.getFrame().setVisible(true); // Make the receptionist GUI window visible
                    frmLogin.dispose(); // Close the login window
                } else {
                    lblMessage.setText("Incorrect username or password");
                }
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton.setBounds(253, 377, 128, 55);
        frmLogin.getContentPane().add(btnNewButton);
        
        passwordField = new JPasswordField();
        passwordField.setToolTipText("Please enter your password");
        passwordField.setBounds(228, 277, 183, 33);
        frmLogin.getContentPane().add(passwordField);
        
        lblMessage = new JLabel("");
        lblMessage.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblMessage.setBounds(200, 350, 250, 30);
        frmLogin.getContentPane().add(lblMessage);
    }
}
