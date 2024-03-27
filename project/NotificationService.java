/**
 * Manages notifications for library members. This class allows for the registration and
 * unregistration of members to receive various notices, including overdue notices, book
 * availability notices, and general notices. It supports the delivery of these notices
 * to all subscribed members, ensuring they are informed of relevant events and updates
 * within the library system.
 *
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0319 (last modified)
 * @since 17.0 (minimum Java version)
 */

import java.util.HashSet;
import java.util.Set;

public class NotificationService {
    private Set<Member> subscribedMembers;

    /**
     * Constructs a new NotificationService instance. Initializes an empty set of subscribed members.
     */
    public NotificationService() {
        this.subscribedMembers = new HashSet<>();
    }

    /**
     * Sends an overdue notice to a specific member if they are subscribed to notifications.
     *
     * @param member The member to send the overdue notice to.
     */
    public void sendOverdueNotice(Member member) {
        if (subscribedMembers.contains(member)) {
            System.out.println("Overdue notice sent to " + member.getName());
        }
    }

    /**
     * Sends a notice about a book's availability to all subscribed members.
     *
     * @param book The book that has become available.
     */
    public void sendBookAvailableNotice(Book book) {
        subscribedMembers.forEach(member ->
            System.out.println("Notice to " + member.getName() + ": '" + book.getTitle() + "' by " + book.getAuthor() + " is now available."));
    }

    /**
     * Registers a member to receive notifications.
     *
     * @param member The member to register for notifications.
     */
    public void registerForMemberNotices(Member member) {
        subscribedMembers.add(member);
        System.out.println(member.getName() + " has been registered for notifications.");
    }

    /**
     * Unregisters a member from receiving notifications.
     *
     * @param member The member to unregister from notifications.
     */
    public void unregisterForMemberNotices(Member member) {
        if (subscribedMembers.remove(member)) {
            System.out.println(member.getName() + " has been unregistered from notifications.");
        }
    }

    /**
     * Sends a general notice to all subscribed members.
     *
     * @param message The message to be included in the general notice.
     */
    public void sendGeneralNotice(String message) {
        subscribedMembers.forEach(member ->
            System.out.println("General notice to " + member.getName() + ": " + message));
    }
}
