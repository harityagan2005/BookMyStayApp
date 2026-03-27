import java.util.*;
class InventoryService {

    private Map<String, Integer> inventory = new HashMap<>();
    private Map<String, Integer> roomCounters = new HashMap<>();

    public InventoryService() {
        inventory.put("Single", 5);
        inventory.put("Double", 3);
        inventory.put("Suite", 2);

        roomCounters.put("Single", 0);
        roomCounters.put("Double", 0);
        roomCounters.put("Suite", 0);
    }

    public synchronized void allocateRoom(String guest, String roomType) {

        int available = inventory.get(roomType);

        if (available > 0) {

            int roomNumber = roomCounters.get(roomType) + 1;
            roomCounters.put(roomType, roomNumber);

            String roomId = roomType + "-" + roomNumber;

            inventory.put(roomType, available - 1);

            System.out.println("Booking confirmed for Guest: " +
                    guest + ", Room ID: " + roomId);
        }
    }

    public void printInventory() {
        System.out.println("\nRemaining Inventory:");
        System.out.println("Single: " + inventory.get("Single"));
        System.out.println("Double: " + inventory.get("Double"));
        System.out.println("Suite: " + inventory.get("Suite"));
    }
}

class BookingThread extends Thread {

    private InventoryService inventory;
    private String guest;
    private String roomType;

    public BookingThread(InventoryService inventory, String guest, String roomType) {
        this.inventory = inventory;
        this.guest = guest;
        this.roomType = roomType;
    }

    public void run() {
        inventory.allocateRoom(guest, roomType);
    }
}

public class BookMyStay_App {
    public static void main(String[] args) { System.out.println("Concurrent Booking Simulation");

        InventoryService inventory = new InventoryService();

        Thread t1 = new BookingThread(inventory, "Abhi", "Single");
        Thread t2 = new BookingThread(inventory, "Vanmathi", "Double");
        Thread t3 = new BookingThread(inventory, "Kural", "Suite");
        Thread t4 = new BookingThread(inventory, "Subha", "Single");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        inventory.printInventory();
    }
}