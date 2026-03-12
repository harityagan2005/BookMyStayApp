import java.util.*;

 class BookMyStayApp {
    public static void main(String[] args) {
        System.out.println("Booking History and Reporting\n");

        System.out.println("Booking History Report");

        // Initialize booking history
        BookingHistory history = new BookingHistory();

        // Confirmed reservations
        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Subha", "Double");
        Reservation r3 = new Reservation("Vanmathi", "Suite");

        // Store in history
        history.addReservation(r1);
        history.addReservation(r2);
        history.addReservation(r3);

        // Admin views report
        for (Reservation r : history.getReservations()) {
            System.out.println(
                    "Guest: " + r.getGuestName() +
                            ", Room Type: " + r.getRoomType()
            );
        }
    }
}