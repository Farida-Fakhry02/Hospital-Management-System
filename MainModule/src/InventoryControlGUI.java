import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;

public class InventoryControlGUI extends JFrame {

    private JPanel contentPane;
    private JTextField tFItemID;
    private JTextField tfItemName;
    private JTextField tfQuantity;
    private JTextField tfSupplier;
    private JTextField tfDescription;
    private InventoryControl inventoryControl;
    private JTextArea textArea;
    private InventoryDataModel dataModel;

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

    public InventoryControlGUI() {
        setTitle("Inventory Control");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 648, 503);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(135,206,250));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbItemID = new JLabel("ItemID:");
        lbItemID.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lbItemID.setBounds(10, 23, 74, 33);
        contentPane.add(lbItemID);

        tFItemID = new JTextField();
        tFItemID.setBounds(102, 30, 218, 26);
        contentPane.add(tFItemID);
        tFItemID.setColumns(10);

        JLabel lbItemName = new JLabel("Item Name:");
        lbItemName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lbItemName.setBounds(10, 73, 82, 13);
        contentPane.add(lbItemName);

        tfItemName = new JTextField();
        tfItemName.setBounds(102, 70, 218, 26);
        contentPane.add(tfItemName);
        tfItemName.setColumns(10);

        JLabel lblQuantity = new JLabel("Quantity:");
        lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblQuantity.setBounds(10, 114, 74, 33);
        contentPane.add(lblQuantity);

        tfQuantity = new JTextField();
        tfQuantity.setColumns(10);
        tfQuantity.setBounds(102, 121, 218, 26);
        contentPane.add(tfQuantity);

        JLabel lblSupplier = new JLabel("Supplier ID:");
        lblSupplier.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblSupplier.setBounds(10, 163, 82, 33);
        contentPane.add(lblSupplier);

        tfSupplier = new JTextField();
        tfSupplier.setColumns(10);
        tfSupplier.setBounds(102, 168, 218, 26);
        contentPane.add(tfSupplier);

        JLabel lblDescription = new JLabel("Description:");
        lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblDescription.setBounds(10, 204, 82, 33);
        contentPane.add(lblDescription);
        
        tfDescription = new JTextField();
        tfDescription.setColumns(10);
        tfDescription.setBounds(102, 211, 218, 26);
        contentPane.add(tfDescription);

        JButton btnAdditem = new JButton("Add Item");
        btnAdditem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String itemId = tFItemID.getText();
                String itemName = tfItemName.getText();
                String quantityText = tfQuantity.getText();
                String supplierId = tfSupplier.getText();
                String description = tfDescription.getText();
                
                if (!isValidItemId(itemId)) {
                    showError("Invalid Item ID format. Please enter alphanumeric characters only.");
                    return;
                }
                
                int quantity;
                try {
                    quantity = Integer.parseInt(quantityText);
                } catch (NumberFormatException ex) {
                    showError("Invalid Quantity format. Please enter a valid integer value.");
                    return;
                }

                if (!isValidSupplierId(supplierId)) {
                    showError("Invalid Supplier ID format. Please enter alphanumeric characters only.");
                    return;
                }

                InventoryItem item = new InventoryItem(itemId, itemName, description, quantity, supplierId);
                inventoryControl.addItem(item);

                textArea.append("Item '" + itemName + "' added successfully.\n");

                clearInputFields();
            }
        });

        btnAdditem.setBounds(25, 271, 150, 21);
        contentPane.add(btnAdditem);

        JButton btnRemoveItem = new JButton("Remove Item");
        btnRemoveItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String itemId = tFItemID.getText();
                if (!isValidItemId(itemId)) {
                    showError("Invalid Item ID format. Please enter alphanumeric characters only.");
                    return;
                }
                
                boolean removed = inventoryControl.removeItem(itemId);
                displayRemoveItemMessage(itemId, removed);
                updateTextArea();
                clearInputFields();
            }
        });
        btnRemoveItem.setBounds(185, 272, 150, 19);
        contentPane.add(btnRemoveItem);

        JButton btnUpdate = new JButton("Update Quantity");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String itemId = tFItemID.getText();
                String quantityText = tfQuantity.getText();
                if (!isValidItemId(itemId)) {
                    showError("Invalid Item ID format. Please enter alphanumeric characters only.");
                    return;
                }
                int quantity;
                try {
                    quantity = Integer.parseInt(quantityText);
                } catch (NumberFormatException ex) {
                    showError("Invalid Quantity format. Please enter a valid integer value.");
                    return;
                }
                inventoryControl.updateItemQuantity(itemId, quantity);
                textArea.append("Quantity updated successfully.\n");
                updateTextArea();
            }
        });
        btnUpdate.setBounds(102, 405, 159, 19);
        contentPane.add(btnUpdate);

        JButton btnCheckAvailability = new JButton("Check Availability");
        btnCheckAvailability.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String itemId = tFItemID.getText();
                if (!isValidItemId(itemId)) {
                    showError("Invalid Item ID format. Please enter alphanumeric characters only.");
                    return;
                }
                String availability = inventoryControl.checkItemAvailability(itemId);
                textArea.append("Availability: " + availability + "\n");
            }
        });
        btnCheckAvailability.setBounds(25, 316, 150, 21);
        contentPane.add(btnCheckAvailability);

        JButton btnGenerate = new JButton("Generate Report");
        btnGenerate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inventoryControl.generateInventoryReport();
                textArea.append("Inventory report generated.\n");
            }
        });
        btnGenerate.setBounds(185, 316, 151, 21);
        contentPane.add(btnGenerate);

        JButton btnSearchItem = new JButton("Search Item");
        btnSearchItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String itemId = tFItemID.getText();
                if (!isValidItemId(itemId)) {
                    showError("Invalid Item ID format. Please enter alphanumeric characters only.");
                    return;
                }
                if (inventoryControl.searchItem(itemId)) {
                    textArea.append("Item found.\n");
                } else {
                    textArea.append("Item not found.\n");
                }
            }
        });
        btnSearchItem.setBounds(25, 360, 150, 21);
        contentPane.add(btnSearchItem);

        JButton btnSearchSupplier = new JButton("Search Supplier");
        btnSearchSupplier.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String supplierId = tfSupplier.getText();
                if (!isValidSupplierId(supplierId)) {
                    showError("Invalid Supplier ID format. Please enter alphanumeric characters only.");
                    return;
                }
                if (inventoryControl.searchSupplier(supplierId)) {
                    textArea.append("Supplier found.\n");
                } else {
                    textArea.append("Supplier not found.\n");
                }
            }
        });
        btnSearchSupplier.setBounds(185, 360, 150, 21);
        contentPane.add(btnSearchSupplier);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(361, 41, 247, 387);
        contentPane.add(scrollPane);
        
        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);
        textArea.setEditable(false);

        inventoryControl = new InventoryControl();
        dataModel = InventoryDataModel.getInstance();
        updateTextArea();
    }

    private boolean isValidItemId(String itemId) {
        return itemId.matches("[a-zA-Z0-9]+");
    }

    private boolean isValidSupplierId(String supplierId) {
        return supplierId.matches("[a-zA-Z0-9]+");
    }

    private void clearInputFields() {
        tFItemID.setText("");
        tfItemName.setText("");
        tfQuantity.setText("");
        tfSupplier.setText("");
        tfDescription.setText("");
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void updateTextArea() {
        textArea.setText("");
        ArrayList<InventoryItem> items = dataModel.getInventoryItems();
        for (InventoryItem item : items) {
            textArea.append(item.toString() + "\n");
        }
    }

    private void displayRemoveItemMessage(String itemId, boolean removed) {
        if (removed) {
            textArea.append("Item with ID '" + itemId + "' successfully removed.\n");
        } else {
            textArea.append("Item with ID '" + itemId + "' not found or could not be removed.\n");
        }
    }
}
