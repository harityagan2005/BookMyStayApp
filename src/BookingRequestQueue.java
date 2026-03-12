import java.util.LinkedList;
import java.util.Queue;

public class BookingRequestQueue {

    private Queue<Reservation> bookingQueue;

    public BookingRequestQueue() {
        bookingQueue = new LinkedList<>();
    }

    // Add booking request
    public void addRequest(Reservation reservation) {
        bookingQueue.add(reservation);
    }

    // Check if queue has pending requests
    public boolean hasPendingRequests() {
        return !bookingQueue.isEmpty();
    }

    // Get next request (FIFO)
    public Reservation getNextRequest() {
        return bookingQueue.poll();
    }
}