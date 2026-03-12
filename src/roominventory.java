import java.util.HashMap;
import java.util.Map;

public class roominventory {

    private HashMap<String, Integer> availability;

    public roominventory() {
        availability = new HashMap<>();
    }

    public void registerRoomType(String roomType, int count) {
        availability.put(roomType, count);
    }

    public int getAvailability(String roomType) {
        return availability.getOrDefault(roomType, 0);
    }
}