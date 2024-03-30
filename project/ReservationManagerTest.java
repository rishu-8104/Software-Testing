import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ReservationManagerTest {

    private ReservationManager reservationManager;
    private NotificationService notificationService;

    @Before
    public void setUp() {
        notificationService = new NotificationService();
        reservationManager = new ReservationManager(notificationService);
    }

    @Test
    public void testReserveBookSuccess() {
        reservationManager.reserveBook("ISBN123", "Member001");
        assertTrue(reservationManager.isBookReserved("ISBN123"));
    }

    @Test
    public void testCancelReservation() {
        reservationManager.reserveBook("ISBN123", "Member001");
        reservationManager.cancelReservation("ISBN123");
        assertFalse(reservationManager.isBookReserved("ISBN123"));
    }

    @Test
    public void testCancelNonExistingReservation() {
        reservationManager.cancelReservation("ISBN123");
        assertFalse(reservationManager.isBookReserved("ISBN123"));
    }

    @Test
    public void testListReservationsEmpty() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        reservationManager.listReservations();
        assertTrue(outContent.toString().contains("No current reservations."));

        System.setOut(System.out); // Reset System.out
    }

    @Test
    public void testListReservationsNotEmpty() {
        reservationManager.reserveBook("ISBN123", "Member001");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        reservationManager.listReservations();
        assertTrue(outContent.toString().contains("Book ISBN: ISBN123, reserved by Member ID: Member001"));

        System.setOut(System.out); // Reset System.out
    }

    @Test
    public void testIsBookReservedTrue() {
        reservationManager.reserveBook("ISBN123", "Member001");
        assertTrue(reservationManager.isBookReserved("ISBN123"));
    }

    @Test
    public void testIsBookReservedFalse() {
        assertFalse(reservationManager.isBookReserved("ISBN123"));
    }

    @Test
    public void testCheckAndNotifyIfBookAvailable() {
        reservationManager.reserveBook("ISBN123", "Member001");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        reservationManager.checkAndNotifyIfBookAvailable("ISBN123");
        assertTrue(outContent.toString().contains("Notification sent to Member ID Member001"));

        System.setOut(System.out); // Reset System.out
        assertFalse(reservationManager.isBookReserved("ISBN123"));
    }

    @Test
    public void testCheckAndNotifyIfBookAvailableNotReserved() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        reservationManager.checkAndNotifyIfBookAvailable("ISBN123");
        assertFalse(outContent.toString().contains("Notification sent to Member ID"));

        System.setOut(System.out); // Reset System.out
        assertFalse(reservationManager.isBookReserved("ISBN123"));
    }

    @Test
    public void testReserveBookAlreadyReserved() {
        reservationManager.reserveBook("ISBN123", "Member001");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        reservationManager.reserveBook("ISBN123", "Member002");
        assertFalse(outContent.toString().contains("Book with ISBN ISBN123 reserved by member ID Member002"));
        assertTrue(outContent.toString().contains("Reservation failed: Book is already reserved"));

        System.setOut(System.out); // Reset System.out
    }

    @Test
    public void testCancelReservationSuccess() {
        reservationManager.reserveBook("ISBN123", "Member001");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        reservationManager.cancelReservation("ISBN123");
        assertFalse(reservationManager.isBookReserved("ISBN123"));
        assertTrue(outContent.toString().contains("Reservation cancelled for book ISBN ISBN123"));

        System.setOut(System.out); // Reset System.out
    }

    @Test
    public void testCancelReservationNotFound() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        reservationManager.cancelReservation("ISBN123");
        assertTrue(outContent.toString().contains("No reservation found for book ISBN ISBN123"));

        System.setOut(System.out); // Reset System.out
    }
    @Test
    public void testCheckAndNotifyIfBookAvailableWithReservation() {
        reservationManager.reserveBook("ISBN123", "Member001");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        reservationManager.checkAndNotifyIfBookAvailable("ISBN123");
        assertTrue(outContent.toString().contains("Notification sent to Member ID Member001 for book ISBN ISBN123"));
        assertFalse(reservationManager.isBookReserved("ISBN123"));

        System.setOut(System.out); // Reset System.out
    }

    @Test
    public void testCheckAndNotifyIfBookAvailableWithoutReservation() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        reservationManager.checkAndNotifyIfBookAvailable("ISBN123");
        assertFalse(outContent.toString().contains("Notification sent to"));
        assertFalse(reservationManager.isBookReserved("ISBN123"));

        System.setOut(System.out); // Reset System.out
    }

    @Test
    public void testIsBookReservedForReservedBook() {
        reservationManager.reserveBook("ISBN123", "Member001");
        assertTrue(reservationManager.isBookReserved("ISBN123"));
    }

    @Test
    public void testIsBookReservedForNonReservedBook() {
        assertFalse(reservationManager.isBookReserved("ISBN123"));
    }

    @Test
    public void testCancelReservationRemovesReservation() {
        reservationManager.reserveBook("ISBN123", "Member001");
        reservationManager.cancelReservation("ISBN123");
        assertFalse(reservationManager.isBookReserved("ISBN123"));
    }

}
