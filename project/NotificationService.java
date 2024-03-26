package project;

import java.util.HashSet;
import java.util.Set;

public class NotificationService {
    private Set<Member> registeredMembers;

    // Constructor
    public NotificationService() {
        this.registeredMembers = new HashSet<>();
    }

    // Sends an overdue notice to a member
    public void sendOverdueNotice(Member member) {
        if (registeredMembers.contains(member)) {
            System.out.println("Overdue Notice: Dear " + member.getName() + ", you have overdue books. Please return them as soon as possible.");
        }
    }

    // Notifies a member that a book is now available
    public void sendBookAvailableNotice(Book book, Member member) {
        if (registeredMembers.contains(member)) {
            System.out.println("Book Available Notice: Dear " + member.getName() + ", '" + book.getTitle() + "' is now available for borrowing.");
        }
    }

    // Registers a member for notifications
    public void registerForMemberNotices(Member member) {
        registeredMembers.add(member);
        System.out.println("Notification Service: " + member.getName() + " has been registered for notifications.");
    }

    // Unregisters a member from notifications
    public void unregisterForMemberNotices(Member member) {
        registeredMembers.remove(member);
        System.out.println("Notification Service: " + member.getName() + " has been unregistered from notifications.");
    }

    // Sends a general notice to all registered members
    public void sendGeneralNotice(String message) {
        for (Member member : registeredMembers) {
            System.out.println("General Notice: Dear " + member.getName() + ", " + message);
        }
    }
}

