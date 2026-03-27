import java.util.*;
class Bookmystayapp {
    public static void main(String[] args) { System.out.println("Booking Cancellation and Inventory Rollback\n");

        // Inventory storage
        HashMap<String, Integer> inventory = new HashMap<>();

        inventory.put("Single", 4);
        inventory.put("Double", 3);
        inventory.put("Suite", 2);

        // Stack for rollback
        Stack<String> releasedRooms = new Stack<>();

        // Simulated confirmed reservation
        String reservationId = "Single-1";
        String roomType = "Single";

        System.out.println("Confirmed Reservation: " + reservationId);

        // Guest requests cancellation
        System.out.println("Cancelling reservation: " + reservationId);

        // Validation
        if (reservationId != null) {

            // Record released room
            releasedRooms.push(reservationId);

            // Restore inventory
            int available = inventory.get(roomType);
            inventory.put(roomType, available + 1);

            System.out.println("Reservation cancelled successfully.");
            System.out.println("Inventory restored for room type: " + roomType);

        } else {

            System.out.println("Cancellation failed. Reservation does not exist.");
        }

        // Show rollback stack
        System.out.println("\nReleased Room IDs (Rollback Stack):");

        while (!releasedRooms.isEmpty()) {
            System.out.println(releasedRooms.pop());
        }
    }
}