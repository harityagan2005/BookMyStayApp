import java.util.ArrayList;
import java.util.List;

public class BookingHistory {

    private List<Reservation> history;

    public BookingHistory() {
        history = new ArrayList<>();
    }

    // Store confirmed reservation
    public void addReservation(Reservation reservation) {
        history.add(reservation);
    }

    // Retrieve stored reservations
    public List<Reservation> getReservations() {
        return history;
    }
}