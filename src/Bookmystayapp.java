class BookMyStayApp {
    public static void main(String[] args) {
        System.out.println("Room Search\n");

        roominventory inventory = new roominventory();

        inventory.registerRoomType("Single Room", 5);
        inventory.registerRoomType("Double Room", 3);
        inventory.registerRoomType("Suite Room", 2);

        room single = new room("Single Room", 1, 250, 1500.0);
        room dbl = new room("Double Room", 2, 400, 2500.0);
        room suite = new room("Suite Room", 3, 750, 5000.0);

        room[] rooms = {single, dbl, suite};

        for (room r : rooms) {

            int available = inventory.getAvailability(r.getType());

            if (available > 0) {
                r.displayRoom(inventory);
            }
        }
    }
}