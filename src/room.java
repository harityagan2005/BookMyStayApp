public class room {

    private String type;
    private int beds;
    private int size;
    private double price;

    public room(String type, int beds, int size, double price) {
        this.type = type;
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    public void displayRoom(roominventory inventory) {

        System.out.println(type + ":");
        System.out.println("Beds: " + beds);
        System.out.println("Size: " + size + " sqft");
        System.out.println("Price per night: " + price);
        System.out.println("Available Rooms: " + inventory.getAvailability(type));
        System.out.println();
    }
}