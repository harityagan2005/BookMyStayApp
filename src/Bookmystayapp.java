import java.util.*;

 class BookMyStayApp { public static void validateBooking(String guestName, String roomType, roominventory inventory)
        throws InvalidBookingException {

    if (guestName == null || guestName.isEmpty()) {
        throw new InvalidBookingException("Guest name cannot be empty.");
    }

    int available = inventory.getAvailability(roomType);

    if (available == 0) {
        throw new InvalidBookingException("Invalid or unavailable room type: " + roomType);
    }

    if (available < 0) {
        throw new InvalidBookingException("Inventory state invalid for room type: " + roomType);
    }
}

    public static void main(String[] args) { System.out.println("Booking Validation and Error Handling\n");

        roominventory inventory = new roominventory();

        inventory.registerRoomType("Single", 5);
        inventory.registerRoomType("Double", 3);
        inventory.registerRoomType("Suite", 2);

        try {

            String guestName = "Abhi";
            String roomType = "Single";

            validateBooking(guestName, roomType, inventory);

            System.out.println("Booking request is valid for Guest: " +
                    guestName + ", Room Type: " + roomType);

        } catch (InvalidBookingException e) {

            System.out.println("Booking failed: " + e.getMessage());
        }

        // Example invalid case
        try {

            String guestName = "Subha";
            String roomType = "Deluxe"; // invalid room type

            validateBooking(guestName, roomType, inventory);

            System.out.println("Booking request is valid for Guest: " +
                    guestName + ", Room Type: " + roomType);

        } catch (InvalidBookingException e) {

            System.out.println("Booking failed: " + e.getMessage());
        }
    }
}