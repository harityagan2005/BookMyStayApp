class BookMyStayApp {
    public static void main(String[] args) {
        System.out.println("Hotel Room Inventory Status\n");


        roominventory inventory = new roominventory();


        inventory.registerRoomType("Single Room", 5);
        inventory.registerRoomType("Double Room", 3);
        inventory.registerRoomType("Suite Room", 2);

        // Create room objects
        room single = new room("Single Room", 1, 250, 1500.0);
        room dbl = new room("Double Room", 2, 400, 2500.0);
        room suite = new room("Suite Room", 3, 750, 5000.0);

        // Display room information
        single.displayRoom(inventory);
        dbl.displayRoom(inventory);
        suite.displayRoom(inventory);
    }
}