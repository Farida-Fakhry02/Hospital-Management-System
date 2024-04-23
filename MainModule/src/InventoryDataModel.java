import java.util.ArrayList;

public class InventoryDataModel {
    private static InventoryDataModel instance;
    private ArrayList<InventoryItem> inventoryItems;

    private InventoryDataModel() {
        inventoryItems = new ArrayList<>();
        
        // Add some default inventory items
        inventoryItems.add(new InventoryItem("ITEM001", "Product 1", "Description 1", 10, "SUP001"));
        inventoryItems.add(new InventoryItem("ITEM002", "Product 2", "Description 2", 20, "SUP002"));
        // Add more inventory items as needed
    }

    public static InventoryDataModel getInstance() {
        if (instance == null) {
            instance = new InventoryDataModel();
        }
        return instance;
    }

    public ArrayList<InventoryItem> getInventoryItems() {
        return inventoryItems;
    }
}
