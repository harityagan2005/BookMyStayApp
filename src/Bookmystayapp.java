import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class BookMyStayApp {
    public static void main(String[] args) {
        System.out.println("Room Allocation Service\n");

        // Initialize booking queue
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        bookingQueue.addRequest(new Reservation("Abhi", "Single"));
        bookingQueue.addRequest(new Reservation("Subha", "Double"));
        bookingQueue.addRequest(new Reservation("Vanmathi", "Suite"));

        // Initialize inventory
        roominventory inventory = new roominventory();

        inventory.registerRoomType("Single", 5);
        inventory.registerRoomType("Double", 3);
        inventory.registerRoomType("Suite", 2);

        // Track allocated rooms
        HashMap<String, Set<String>> allocatedRooms = new HashMap<>();

        int roomCounter = 1;

        // Process queue
        while (bookingQueue.hasPendingRequests()) {

            Reservation request = bookingQueue.getNextRequest();

            String guest = request.getGuestName();
            String roomType = request.getRoomType();

            int available = inventory.getAvailability(roomType);

            if (available > 0) {

                // Generate room ID
                String roomId = roomType + "-" + roomCounter;

                roomCounter++;

                allocatedRooms.putIfAbsent(roomType, new HashSet<>());

                Set<String> assignedRooms = allocatedRooms.get(roomType);

                if (!assignedRooms.contains(roomId)) {

                    assignedRooms.add(roomId);

                    // Update inventory
                    inventory.registerRoomType(roomType, available - 1);

                    System.out.println(
                            "Reservation confirmed for Guest: "
                                    + guest +
                                    ", Room Type: "
                                    + roomType +
                                    ", Room ID: "
                                    + roomId
                    );
                }

            } else {

                System.out.println(
                        "No rooms available for Guest: "
                                + guest +
                                ", Room Type: "
                                + roomType
                );
            }
        }
    }
}