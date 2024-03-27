/**
 * Manages the reservation of books within the library system. This class tracks reservations
 * by mapping book ISBNs to member IDs, ensuring that books can be reserved and that reservations
 * can be managed effectively. It integrates with the NotificationService to notify members when
 * reserved books become available.
 *
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0318 (last modified)
 * @since 17.0 (minimum Java version)
 */
import java.util.HashMap;
import java.util.Map;
public class ReservationManager {

    private Map<String, String> bookReservations; // Maps book ISBN to member ID
    private NotificationService notificationService;

    /**
     * Constructs a new ReservationManager instance with a reference to a NotificationService.
     *
     * @param notificationService The notification service to use for sending book availability notices.
     */
    public ReservationManager(NotificationService notificationService) {
        this.bookReservations = new HashMap<>();
        this.notificationService = notificationService;
    }

    /**
     * Reserves a book for a member, given the book's ISBN and the member's ID.
     *
     * @param isbn The ISBN of the book to reserve.
     * @param memberId The ID of the member reserving the book.
     */
    public void reserveBook(String isbn, String memberId) {
        if (!bookReservations.containsKey(isbn)) {
            bookReservations.put(isbn, memberId);
            System.out.println("Book with ISBN " + isbn + " reserved by member ID " + memberId);
        } else {
            System.out.println("Reservation failed: Book is already reserved.");
        }
    }

    /**
     * Cancels a reservation for a book, given the book's ISBN.
     *
     * @param isbn The ISBN of the book for which to cancel the reservation.
     */
    public void cancelReservation(String isbn) {
        if (bookReservations.containsKey(isbn)) {
            bookReservations.remove(isbn);
            System.out.println("Reservation cancelled for book ISBN " + isbn);
        } else {
            System.out.println("No reservation found for book ISBN " + isbn);
        }
    }

    /**
     * Lists all current book reservations.
     */
    public void listReservations() {
        if (bookReservations.isEmpty()) {
            System.out.println("No current reservations.");
        } else {
            bookReservations.forEach((isbn, memberId) ->
                System.out.println("Book ISBN: " + isbn + ", reserved by Member ID: " + memberId));
        }
    }

    /**
     * Checks if a book is currently reserved.
     *
     * @param isbn The ISBN of the book to check.
     * @return True if the book is reserved, false otherwise.
     */
    public boolean isBookReserved(String isbn) {
        return bookReservations.containsKey(isbn);
    }

    /**
     * Checks if a reserved book is available and notifies the member who reserved it.
     * It also removes the reservation after sending the notification.
     *
     * @param isbn The ISBN of the book to check availability for.
     */
    public void checkAndNotifyIfBookAvailable(String isbn) {
        if (bookReservations.containsKey(isbn)) {
            String memberId = bookReservations.get(isbn);
            notificationService.sendBookAvailableNotice(new Book("Book Title Placeholder", "Author Placeholder", isbn)); // Placeholder for actual book details
            bookReservations.remove(isbn);
            System.out.println("Notification sent to Member ID " + memberId + " for book ISBN " + isbn);
        }
    }
}
