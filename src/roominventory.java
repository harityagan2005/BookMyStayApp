import java.util.HashMap;
import java.util.Map;

public class roominventory {

    private Map<String, Integer> availability;

    // Constructor to initialize inventory
    public roominventory() {
        availability = new HashMap<>();
    }

    // Register room type with available count
    public void registerRoomType(String roomType, int count) {
        availability.put(roomType, count);
    }

    // Get availability of a specific room type
    public int getAvailability(String roomType) {
        return availability.getOrDefault(roomType, 0);
    }

    // Update availability
    public void updateAvailability(String roomType, int newCount) {
        availability.put(roomType, newCount);
    }

    // Display inventory
    public void displayInventory() {
        for (Map.Entry<String, Integer> entry : availability.entrySet()) {
            System.out.println(entry.getKey() + " Available Rooms: " + entry.getValue());
        }
    }
}