import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Login_Page {

	private JFrame frame;
	private JTextField txtRffgd;
	private JTextField txtEnterYourPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Page window = new Login_Page();
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
	public Login_Page() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.setBounds(100, 100, 624, 524);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hospital management system");
		lblNewLabel.setFont(new Font("Monotype Corsiva", Font.PLAIN, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(95, 51, 426, 55);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(94, 191, 96, 33);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtRffgd = new JTextField();
		txtRffgd.setToolTipText("Please enter the username");
		txtRffgd.setBounds(228, 191, 183, 30);
		frame.getContentPane().add(txtRffgd);
		txtRffgd.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(94, 277, 96, 33);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		txtEnterYourPassword = new JTextField();
		txtEnterYourPassword.setToolTipText("Please enter the password");
		txtEnterYourPassword.setColumns(10);
		txtEnterYourPassword.setBounds(228, 277, 183, 30);
		frame.getContentPane().add(txtEnterYourPassword);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(253, 377, 128, 55);
		frame.getContentPane().add(btnNewButton);
	}
}
