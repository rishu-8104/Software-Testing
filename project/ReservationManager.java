import java.util.HashMap;
import java.util.Map;


public class ReservationManager {
    private Map<String, String> bookReservations; // Maps book ISBN to member ID
    private NotificationService notificationService;

    public ReservationManager(NotificationService notificationService) {
        this.bookReservations = new HashMap<>();
        this.notificationService = notificationService;
    }

    public void reserveBook(String isbn, String memberId) {
        if (!bookReservations.containsKey(isbn)) {
            bookReservations.put(isbn, memberId);
            System.out.println("Book with ISBN " + isbn + " reserved by member ID " + memberId);
        } else {
            System.out.println("Reservation failed: Book is already reserved.");
        }
    }

    public void cancelReservation(String isbn) {
        if (bookReservations.containsKey(isbn)) {
            bookReservations.remove(isbn);
            System.out.println("Reservation cancelled for book ISBN " + isbn);
        } else {
            System.out.println("No reservation found for book ISBN " + isbn);
        }
    }

    public void listReservations() {
        if (bookReservations.isEmpty()) {
            System.out.println("No current reservations.");
        } else {
            bookReservations.forEach((isbn, memberId) ->
                System.out.println("Book ISBN: " + isbn + ", reserved by Member ID: " + memberId));
        }
    }

    public boolean isBookReserved(String isbn) {
        return bookReservations.containsKey(isbn);
    }

    public void checkAndNotifyIfBookAvailable(String isbn) {
        if (bookReservations.containsKey(isbn)) {
            String memberId = bookReservations.get(isbn);
            notificationService.sendBookAvailableNotice(new Book("Book Title Placeholder", "Author Placeholder", isbn)); // Assuming you have access to book details
            bookReservations.remove(isbn);
            System.out.println("Notification sent to Member ID " + memberId + " for book ISBN " + isbn);
        }
    }
}
