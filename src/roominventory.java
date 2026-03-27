import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class roominventory {

    private int singleRoomAvailability = 5;

    // Add this method to fix the "cannot find symbol" error
    public int getAvailability(String roomType) {
        if (roomType.equalsIgnoreCase("Single")) {
            return singleRoomAvailability;
        }
        // Return 0 or throw an exception if the room type isn't recognized
        return 0;
    }
}