import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class InventoryControlGUI extends JFrame {

    private JPanel contentPane;
    private JTextField tFItemID;
    private JTextField tfItemName;
    private JTextField tfQuantity;
    private JTextField tfSupplier;
    private JLabel lblMessage; // New label for displaying messages
    private InventoryControl inventoryControl;
    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InventoryControlGUI frame = new InventoryControlGUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public InventoryControlGUI() {
        setTitle("Inventory Control");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 552, 499);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbItemID = new JLabel("ItemID:");
        lbItemID.setBounds(10, 23, 74, 33);
        contentPane.add(lbItemID);

        tFItemID = new JTextField();
        tFItemID.setBounds(102, 30, 218, 19);
        contentPane.add(tFItemID);
        tFItemID.setColumns(10);

        JLabel lbItemName = new JLabel("Item Name:");
        lbItemName.setBounds(10, 73, 74, 13);
        contentPane.add(lbItemName);

        tfItemName = new JTextField();
        tfItemName.setBounds(102, 70, 218, 19);
        contentPane.add(tfItemName);
        tfItemName.setColumns(10);

        JLabel lblQuantity = new JLabel("Quantity:");
        lblQuantity.setBounds(10, 114, 74, 33);
        contentPane.add(lblQuantity);

        tfQuantity = new JTextField();
        tfQuantity.setColumns(10);
        tfQuantity.setBounds(102, 121, 218, 19);
        contentPane.add(tfQuantity);

        JLabel lblSupplier = new JLabel("Supplier:");
        lblSupplier.setBounds(10, 161, 74, 33);
        contentPane.add(lblSupplier);

        tfSupplier = new JTextField();
        tfSupplier.setColumns(10);
        tfSupplier.setBounds(102, 168, 218, 19);
        contentPane.add(tfSupplier);

        JButton btnAdditem = new JButton("Add Item");
        btnAdditem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String itemId = tFItemID.getText();
                    String itemName = tfItemName.getText();
                    int quantity = Integer.parseInt(tfQuantity.getText());
                    String supplierId = tfSupplier.getText();

                    InventoryItem item = new InventoryItem(itemId, itemName, quantity, supplierId);
                    inventoryControl.addItem(item);
                    lblMessage.setText("Item added successfully.");
                } catch (NumberFormatException ex) {
                    lblMessage.setText("Invalid input. Please check your input fields.");
                    ex.printStackTrace();
                }
            }
        });
        btnAdditem.setBounds(25, 227, 105, 21);
        contentPane.add(btnAdditem);

        JButton btnRemoveItem = new JButton("Remove Item");
        btnRemoveItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String itemId = tFItemID.getText();
                    inventoryControl.removeItem(itemId);
                    lblMessage.setText("Item removed successfully.");
                } catch (NumberFormatException ex) {
                    lblMessage.setText("Invalid input. Please check your input fields.");
                    ex.printStackTrace();
                }
            }
        });
        btnRemoveItem.setBounds(185, 228, 135, 19);
        contentPane.add(btnRemoveItem);

        JButton btnUpdate = new JButton("Update Quantity");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String itemId = tFItemID.getText();
                    int quantity = Integer.parseInt(tfQuantity.getText());
                    inventoryControl.updateItemQuantity(itemId, quantity);
                    lblMessage.setText("Quantity updated successfully.");
                } catch (NumberFormatException ex) {
                    lblMessage.setText("Invalid input. Please check your input fields.");
                    ex.printStackTrace();
                }
            }
        });
        btnUpdate.setBounds(351, 228, 159, 19);
        contentPane.add(btnUpdate);

        JButton btnCheckAvailability = new JButton("Check Availability");
        btnCheckAvailability.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String itemId = tFItemID.getText();
                    String availability = inventoryControl.checkItemAvailability(itemId);
                    lblMessage.setText("Availability: " + availability);
                } catch (NumberFormatException ex) {
                    lblMessage.setText("Invalid input. Please check your input fields.");
                    ex.printStackTrace();
                }
            }
        });
        btnCheckAvailability.setBounds(10, 285, 150, 21);
        contentPane.add(btnCheckAvailability);

        JButton btnGenerate = new JButton("Generate Report");
        btnGenerate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inventoryControl.generateInventoryReport();
                lblMessage.setText("Inventory report generated.");
            }
        });
        btnGenerate.setBounds(185, 285, 151, 21);
        contentPane.add(btnGenerate);

        JButton btnPlaceOrder = new JButton("Place Order");
        btnPlaceOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String itemId = tFItemID.getText();
                    int quantity = Integer.parseInt(tfQuantity.getText());
                    inventoryControl.placeOrder(itemId, quantity);
                    lblMessage.setText("Order placed successfully.");
                } catch (NumberFormatException ex) {
                    lblMessage.setText("Invalid input. Please check your input fields.");
                    ex.printStackTrace();
                }
            }
        });
        btnPlaceOrder.setBounds(375, 286, 135, 19);
        contentPane.add(btnPlaceOrder);

        lblMessage = new JLabel("");
        lblMessage.setBounds(10, 330, 500, 20); // Adjust size and position as needed
        contentPane.add(lblMessage);

        inventoryControl = new InventoryControl();
    }
}
