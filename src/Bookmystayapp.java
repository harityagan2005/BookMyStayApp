class BookMyStayApp {
    public static void main(String[] args) {
        System.out.println("Welcome to the Hotel Booking Management System");
        System.out.println("System initialized successfully.");
        System.out.println("Welcome to the Hotel Booking Management System v2.1");
        System.out.println("Initializing room types...\n");
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();
        int singleAvailability = 10;
        int doubleAvailability = 7;
        int suiteAvailability = 3;
        System.out.println("---- Single Room ----");
        single.displayRoomDetails();
        System.out.println("Available: " + singleAvailability + "\n");
        System.out.println("---- Double Room ----");
        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + doubleAvailability + "\n");
        System.out.println("---- Suite Room ----");
        suite.displayRoomDetails();
        System.out.println("Available: " + suiteAvailability);
    }
}
abstract class Room {
    protected String roomType;
    protected int numberOfBeds;
    protected int size;
    protected double price;
    public Room(String roomType, int numberOfBeds, int size, double price) {
        this.roomType = roomType;
        this.numberOfBeds = numberOfBeds;
        this.size = size;
        this.price = price;
    }
    public void displayRoomDetails() {
        System.out.println("Room Type: " + roomType);
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Size: " + size + " sqm");
        System.out.println("Price per night: $" + price);
    }
}
class SingleRoom extends Room {
    public SingleRoom() {
        super("Single Room", 1, 20, 100.0);
    }
}
class DoubleRoom extends Room {
    public DoubleRoom() {
        super("Double Room", 2, 35, 180.0);
    }
}
class SuiteRoom extends Room {
    public SuiteRoom() {
        super("Suite Room", 3, 60, 350.0);
    }
}