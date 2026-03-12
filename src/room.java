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

    public String getType() {
        return type;
    }

    public void displayRoom(roominventory inventory) {

        int available = inventory.getAvailability(type);

        if (available > 0) {
            System.out.println(type + ":");
            System.out.println("Beds: " + beds);
            System.out.println("Size: " + size + " sqft");
            System.out.println("Price per night: " + price);
            System.out.println("Available: " + available);
            System.out.println();
        }
    }
}