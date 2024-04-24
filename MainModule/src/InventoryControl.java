
import java.util.HashMap;
import java.util.Map;


public class InventoryControl {
    private Map<String, InventoryItem> inventory;
    private Map<String, Supplier> suppliers;

    public InventoryControl() {
        this.inventory = new HashMap<>();
        this.suppliers = new HashMap<>();
    }

    // Method to add an item to inventory
    public void addItem(InventoryItem item) {
        inventory.put(item.getItemId(), item);
    }

    // Method to remove an item from inventory
    public boolean removeItem(String itemId) {
        if (inventory.containsKey(itemId)) {
            inventory.remove(itemId);
            return true; // Return true if item is removed successfully
        }
        return false; // Return false if item is not found
    }


    // Method to update quantity of an item in inventory
    public void updateItemQuantity(String itemId, int quantity) {
        if (inventory.containsKey(itemId)) {
            InventoryItem item = inventory.get(itemId);
            item.setQuantity(quantity);
            inventory.put(itemId, item);
        } else {
            throw new IllegalArgumentException("Item with ID " + itemId + " does not exist in inventory.");
        }
    }


    // Method to check availability of an item in inventory
    public String checkItemAvailability(String itemId) {
        if (inventory.containsKey(itemId) && inventory.get(itemId).getQuantity() > 0) {
            return "Available";
        } else {
            return "Unavailable";
        }
    }

    // Method to retrieve item information from inventory
    public InventoryItem getItem(String itemId) {
        return inventory.getOrDefault(itemId, null);
    }

    // Method to generate report on current inventory levels
    public void generateInventoryReport() {
        System.out.println("Inventory Report:");
        for (InventoryItem item : inventory.values()) {
            System.out.println(item);
        }
    }

    // Method to add a supplier
    public void addSupplier(Supplier supplier) {
        suppliers.put(supplier.getSupplierId(), supplier);
    }

    // Method to retrieve supplier information
    public Supplier getSupplier(String supplierId) {
        return suppliers.getOrDefault(supplierId, null);
    }

    // Method to place order for items
    public void placeOrder(String itemId, int quantity) {
        if (inventory.containsKey(itemId)) {
            InventoryItem item = inventory.get(itemId);
            if (suppliers.containsKey(item.getSupplierId())) {

                Supplier supplier = suppliers.get(item.getSupplierId());
                System.out.println("Placing order for " + quantity + " units of " + item.getName() + " with supplier " + supplier.getName());
            } else {
                System.out.println("No supplier found for item with ID " + itemId);
            }
        } else {
            System.out.println("Item with ID " + itemId + " does not exist in inventory.");
        }
    }
    
    public boolean searchSupplier(String supplierId) {
        Supplier supplier = suppliers.get(supplierId);
        if (supplier != null) {
            System.out.println("Supplier found:");
            supplier.printDetails();
            return true;
        } else {
            System.out.println("Supplier with ID " + supplierId + " not found.");
            return false;
        }
    }


    // Method to search for an item by name
    public boolean searchItem(String itemId) {
        InventoryItem item = inventory.get(itemId);
        if (item != null) {
            System.out.println("Item found:");
            item.printDetails();
            return true;
        } else {
            System.out.println("Item with ID " + itemId + " not found.");
            return false;
        }
    }
}
