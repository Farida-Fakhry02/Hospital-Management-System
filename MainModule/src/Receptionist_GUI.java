import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class Receptionist_GUI {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Receptionist_GUI window = new Receptionist_GUI();
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
    public Receptionist_GUI() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 600, 454);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Welcome !");
        lblNewLabel.setFont(new Font("Monotype Corsiva", Font.PLAIN, 30));
        lblNewLabel.setBounds(236, 11, 128, 80);
        frame.getContentPane().add(lblNewLabel);
    }
    
    // Method to get the frame
    public JFrame getFrame() {
        return frame;
    }
}
