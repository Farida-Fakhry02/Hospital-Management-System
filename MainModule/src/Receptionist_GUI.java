import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Receptionist_GUI {

    private JFrame frame;

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

    public Receptionist_GUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 600, 454);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Welcome !");
        lblNewLabel.setFont(new Font("Monotype Corsiva", Font.PLAIN, 30));
        lblNewLabel.setBounds(236, 11, 128, 80);
        frame.getContentPane().add(lblNewLabel);
        
        JButton btnNewButton = new JButton("Doctor");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton.setBounds(28, 101, 143, 59);
        frame.getContentPane().add(btnNewButton);
        
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Doctorwindow doctorWindow = new Doctorwindow();
                doctorWindow.getFrame().setVisible(true);
            }
        });
    }

    public JFrame getFrame() {
        return frame;
    }
}
