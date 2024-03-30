import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;


public class NotificationServiceTest {

@Test
    public void testSendOverdueNoticeToSubscribedMember() {
        NotificationService notificationService = new NotificationService();
        Member subscribedMember = new Member("John Doe", "001");
        notificationService.registerForMemberNotices(subscribedMember);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        notificationService.sendOverdueNotice(subscribedMember);

        assertEquals("Overdue notice sent to John Doe\n", outContent.toString());
        System.setOut(System.out); // Reset to standard output
    }
    @Test
    public void testSendOverdueNoticeToUnsubscribedMember() {
        NotificationService notificationService = new NotificationService();
        Member unsubscribedMember = new Member("Jane Smith", "002");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        notificationService.sendOverdueNotice(unsubscribedMember);

        assertEquals("", outContent.toString());
        System.setOut(System.out); // Reset to standard output
    }

    @Test
    public void testSendOverdueNoticeToNonExistentMember() {
        NotificationService notificationService = new NotificationService();
        Member nonExistentMember = new Member("Alice Johnson", "003");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        notificationService.sendOverdueNotice(nonExistentMember);

        assertEquals("", outContent.toString());
        System.setOut(System.out); // Reset to standard output
    }

    @Test
    public void testSendBookAvailableNoticeToNoSubscribedMembers() {
        NotificationService notificationService = new NotificationService();
        Book book = new Book("Book Title", "Book Author", "1234567890");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        notificationService.sendBookAvailableNotice(book);

        assertEquals("", outContent.toString());
        System.setOut(System.out); // Reset to standard output
    }

    @Test
    public void testSendBookAvailableNoticeWithNoBook() {
        NotificationService notificationService = new NotificationService();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        notificationService.sendBookAvailableNotice(null);

        assertEquals("", outContent.toString());
        System.setOut(System.out); // Reset to standard output
    }

    @Test
    public void testRegisterForMemberNotices() {
        NotificationService notificationService = new NotificationService();
        Member member = new Member("John Doe", "001");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        notificationService.registerForMemberNotices(member);

        assertEquals("John Doe has been registered for notifications.\n", outContent.toString());
        System.setOut(System.out); // Reset to standard output
    }

    @Test
    public void testRegisterForMemberNoticesWithDifferentMember() {
        NotificationService notificationService = new NotificationService();
        Member member = new Member("Jane Smith", "002");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        notificationService.registerForMemberNotices(member);

        assertEquals("Jane Smith has been registered for notifications.\n", outContent.toString());
        System.setOut(System.out); // Reset to standard output
    }

    @Test
    public void testRegisterForMemberNoticesWithEmptyName() {
        NotificationService notificationService = new NotificationService();
        Member member = new Member("", "003");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        notificationService.registerForMemberNotices(member);

        assertEquals(" has been registered for notifications.\n", outContent.toString());
        System.setOut(System.out); // Reset to standard output
    }

    @Test
    public void testRegisterForMemberNoticesWithNullName() {
        NotificationService notificationService = new NotificationService();
        Member member = new Member(null, "004");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        notificationService.registerForMemberNotices(member);

        assertEquals("null has been registered for notifications.\n", outContent.toString());
        System.setOut(System.out); // Reset to standard output
    }
    @Test
    public void testUnregisterForMemberNotices() {
        NotificationService notificationService = new NotificationService();
        Member member = new Member("John Doe", "001");
        notificationService.registerForMemberNotices(member);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        notificationService.unregisterForMemberNotices(member);

        assertEquals("John Doe has been unregistered from notifications.\n", outContent.toString());
        System.setOut(System.out); // Reset to standard output
    }

    @Test
    public void testUnregisterForMemberNoticesWithDifferentMember() {
        NotificationService notificationService = new NotificationService();
        Member member = new Member("Jane Smith", "002");
        notificationService.registerForMemberNotices(member);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        notificationService.unregisterForMemberNotices(member);

        assertEquals("Jane Smith has been unregistered from notifications.\n", outContent.toString());
        System.setOut(System.out); // Reset to standard output
    }

    @Test
    public void testUnregisterForMemberNoticesWithEmptyName() {
        NotificationService notificationService = new NotificationService();
        Member member = new Member("", "003");
        notificationService.registerForMemberNotices(member);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        notificationService.unregisterForMemberNotices(member);

        assertEquals(" has been unregistered from notifications.\n", outContent.toString());
        System.setOut(System.out); // Reset to standard output
    }

    @Test
    public void testUnregisterForMemberNoticesWithNullName() {
        NotificationService notificationService = new NotificationService();
        Member member = new Member(null, "004");
        notificationService.registerForMemberNotices(member);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        notificationService.unregisterForMemberNotices(member);

        assertEquals("null has been unregistered from notifications.\n", outContent.toString());
        System.setOut(System.out); // Reset to standard output
    }
    @Test
    public void testSendGeneralNotice() {
        NotificationService notificationService = new NotificationService();
        Member member = new Member("John Doe", "001");
        notificationService.registerForMemberNotices(member);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        notificationService.sendGeneralNotice("This is a general notice.");

        assertEquals("General notice to John Doe: This is a general notice.\n", outContent.toString());
        System.setOut(System.out); // Reset to standard output
    }

    @Test
    public void testSendGeneralNoticeWithDifferentMessage() {
        NotificationService notificationService = new NotificationService();
        Member member = new Member("Jane Smith", "002");
        notificationService.registerForMemberNotices(member);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        notificationService.sendGeneralNotice("Another general notice.");

        assertEquals("General notice to Jane Smith: Another general notice.\n", outContent.toString());
        System.setOut(System.out); // Reset to standard output
    }

    @Test
    public void testSendGeneralNoticeWithEmptyMessage() {
        NotificationService notificationService = new NotificationService();
        Member member = new Member("Alice", "003");
        notificationService.registerForMemberNotices(member);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        notificationService.sendGeneralNotice("");

        assertEquals("General notice to Alice: \n", outContent.toString());
        System.setOut(System.out); // Reset to standard output
    }

    @Test
    public void testSendGeneralNoticeWithNullMessage() {
        NotificationService notificationService = new NotificationService();
        Member member = new Member("Bob", "004");
        notificationService.registerForMemberNotices(member);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        notificationService.sendGeneralNotice(null);

        assertEquals("General notice to Bob: null\n", outContent.toString());
        System.setOut(System.out); // Reset to standard output
    }

}
