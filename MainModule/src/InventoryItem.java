public class InventoryItem {
    private int itemId;
    private String name;
    private String description;
    private int quantity;
    private int supplierId;

    public InventoryItem(int itemId, String name, String description, int quantity, int supplierId) {
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.supplierId = supplierId;
    }

    public int getItemId() {
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

    public int getSupplierId() {
        return supplierId;
    }

    @Override
    public String toString() {
        return "Item ID: " + itemId + ", Name: " + name + ", Description: " + description + ", Quantity: " + quantity;
    }
}
