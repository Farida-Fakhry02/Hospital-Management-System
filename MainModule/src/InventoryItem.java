
public class InventoryItem {
    private String itemId;
    private String name;
    private String description;
    private int quantity;
    private String supplierId;

    public InventoryItem(String itemId, String name, String description, int quantity, String supplierId) {
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.supplierId = supplierId;
    }

    public InventoryItem(String itemId, String name, int quantity, String supplierId) {
        this.itemId = itemId;
        this.name = name;
        this.quantity = quantity;
        this.supplierId = supplierId;
    }

    public String getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSupplierId() {
        return supplierId;
    }

    @Override
    public String toString() {
        return "Item ID: " + itemId + ", Name: " + name + ", Description: " + description + ", Quantity: " + quantity;
    }
    
    public void printDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Name: " + name);
        System.out.println("Description: " + description);
        System.out.println("Quantity: " + quantity);
        System.out.println("Supplier ID: " + supplierId);
    }
}
