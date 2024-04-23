import java.util.ArrayList;

public class InventoryDataModel {
    private static InventoryDataModel instance;
    private ArrayList<InventoryItem> inventoryItems;

    private InventoryDataModel() {
        inventoryItems = new ArrayList<>();
        
        // Add some default inventory items
       
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
