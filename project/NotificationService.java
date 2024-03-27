import java.util.HashSet;
import java.util.Set;

public class NotificationService {
    private Set<Member> subscribedMembers;

    public NotificationService() {
        this.subscribedMembers = new HashSet<>();
    }

    public void sendOverdueNotice(Member member) {
        if (subscribedMembers.contains(member)) {
            System.out.println("Overdue notice sent to " + member.getName());
        }
    }

    public void sendBookAvailableNotice(Book book) {
        subscribedMembers.forEach(member ->
            System.out.println("Notice to " + member.getName() + ": '" + book.getTitle() + "' by " + book.getAuthor() + " is now available."));
    }

    public void registerForMemberNotices(Member member) {
        subscribedMembers.add(member);
        System.out.println(member.getName() + " has been registered for notifications.");
    }

    public void unregisterForMemberNotices(Member member) {
        if (subscribedMembers.remove(member)) {
            System.out.println(member.getName() + " has been unregistered from notifications.");
        }
    }

    public void sendGeneralNotice(String message) {
        subscribedMembers.forEach(member ->
            System.out.println("General notice to " + member.getName() + ": " + message));
    }
}
