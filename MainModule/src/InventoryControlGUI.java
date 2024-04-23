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
        lbItemID.setBounds(10, 23, 74, 33);
        lbItemID.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(lbItemID);

        tFItemID = new JTextField();
        tFItemID.setBounds(102, 30, 218, 26);
        contentPane.add(tFItemID);
        tFItemID.setColumns(10);

        JLabel lbItemName = new JLabel("Item Name:");
        lbItemName.setBounds(10, 73, 82, 13);
        lbItemName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(lbItemName);

        tfItemName = new JTextField();
        tfItemName.setBounds(102, 70, 218, 26);
        contentPane.add(tfItemName);
        tfItemName.setColumns(10);

        JLabel lblQuantity = new JLabel("Quantity:");
        lblQuantity.setBounds(10, 114, 74, 33);
        lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(lblQuantity);

        tfQuantity = new JTextField();
        tfQuantity.setBounds(102, 121, 218, 26);
        tfQuantity.setColumns(10);
        contentPane.add(tfQuantity);

        JLabel lblSupplier = new JLabel("Supplier ID:");
        lblSupplier.setBounds(10, 163, 82, 33);
        lblSupplier.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(lblSupplier);

        tfSupplier = new JTextField();
        tfSupplier.setBounds(102, 168, 218, 26);
        tfSupplier.setColumns(10);
        contentPane.add(tfSupplier);

        JLabel lblDescription = new JLabel("Description:");
        lblDescription.setBounds(10, 204, 82, 33);
        lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(lblDescription);
        
        tfDescription = new JTextField();
        tfDescription.setBounds(102, 211, 218, 26);
        tfDescription.setColumns(10);
        contentPane.add(tfDescription);

        JButton btnAdditem = new JButton("Add Item");
        btnAdditem.setBounds(10, 271, 150, 34);
        btnAdditem.setFont(new Font("Tahoma", Font.PLAIN, 15));
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

                // Update the list of inventory items in the data model
                InventoryDataModel.getInstance().getInventoryItems().add(item);

                //clearInputFields();
            }
        });
        contentPane.add(btnAdditem);

        JButton btnRemoveItem = new JButton("Remove Item");
        btnRemoveItem.setBounds(170, 272, 150, 33);
        btnRemoveItem.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnRemoveItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String itemId = tFItemID.getText();
                if (!isValidItemId(itemId)) {
                    showError("Invalid Item ID format. Please enter alphanumeric characters only.");
                    return;
                }

                // Remove the item from the inventory control
                boolean removed = inventoryControl.removeItem(itemId);

                // Remove the item from the list in the data model
                ArrayList<InventoryItem> inventoryItems = InventoryDataModel.getInstance().getInventoryItems();
                InventoryItem itemToRemove = null;
                for (InventoryItem item : inventoryItems) {
                    if (item.getItemId().equals(itemId)) {
                        itemToRemove = item;
                        break;
                    }
                }
                if (itemToRemove != null) {
                    inventoryItems.remove(itemToRemove);
                }

                displayRemoveItemMessage(itemId, removed);
                updateTextArea();
                clearInputFields();
            }
        });
        contentPane.add(btnRemoveItem);

        JButton btnUpdate = new JButton("Update Quantity");
        btnUpdate.setBounds(10, 361, 150, 33);
        btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
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
        contentPane.add(btnUpdate);

        JButton btnCheckAvailability = new JButton("Check Availability");
        btnCheckAvailability.setBounds(10, 316, 150, 34);
        btnCheckAvailability.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnCheckAvailability.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String itemId = tFItemID.getText();
                if (!isValidItemId(itemId)) {
                    showError("Invalid Item ID format. Please enter alphanumeric characters only.");
                    return;
                }

                // Check if the item ID is found in the list
                boolean itemAvailable = false;
                ArrayList<InventoryItem> inventoryItems = InventoryDataModel.getInstance().getInventoryItems();
                for (InventoryItem item : inventoryItems) {
                    if (item.getItemId().equals(itemId)) {
                        itemAvailable = true;
                        break;
                    }
                }

                // Print the availability message
                if (itemAvailable) {
                    textArea.append("Item is available.\n");
                } else {
                    textArea.append("Item is not available.\n");
                }
            }
        });
        contentPane.add(btnCheckAvailability);

        JButton btnGenerate = new JButton("Generate Report");
        btnGenerate.setBounds(170, 316, 151, 34);
        btnGenerate.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnGenerate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<InventoryItem> items = dataModel.getInventoryItems();
                if (items.isEmpty()) {
                    textArea.append("No items in the inventory.\n");
                } else {
                    textArea.append("Inventory Report:\n");
                    for (InventoryItem item : items) {
                        textArea.append(item.toString() + "\n");
                    }
                }
            }
        });
        contentPane.add(btnGenerate);

        JButton btnSearchSupplier = new JButton("Search Supplier");
        btnSearchSupplier.setBounds(170, 360, 150, 34);
        btnSearchSupplier.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnSearchSupplier.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String supplierId = tfSupplier.getText();
                if (!isValidSupplierId(supplierId)) {
                    showError("Invalid Supplier ID format. Please enter alphanumeric characters only.");
                    return;
                }

                // Check if the supplier ID exists in the list
                boolean supplierExists = false;
                ArrayList<InventoryItem> inventoryItems = InventoryDataModel.getInstance().getInventoryItems();
                for (InventoryItem item : inventoryItems) {
                    if (item.getSupplierId().equals(supplierId)) {
                        supplierExists = true;
                        break;
                    }
                }

                // Print the result
                if (supplierExists) {
                    textArea.append("Supplier exists.\n");
                } else {
                    textArea.append("Supplier does not exist.\n");
                }
            }
        });

        contentPane.add(btnSearchSupplier);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(361, 41, 247, 387);
        contentPane.add(scrollPane);
        
        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);
        textArea.setEditable(false);
        
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Close the current inventory control window
                dispose();

                // Open the receptionist window
                Receptionist_GUI receptionistWindow = new Receptionist_GUI();
                receptionistWindow.getFrame().setVisible(true);
            }
        });

        btnBack.setBounds(97, 405, 150, 33);
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(btnBack);

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
