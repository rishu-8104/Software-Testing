import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberManager {
    private List<Member> members;

    public MemberManager() {
        this.members = new ArrayList<>();
    }

    public void addMember(Member member) {
        members.add(member);
        System.out.println("Member added: " + member.getName() + " with ID " + member.getID());
    }

    public void removeMember(String memberId) {
        members.removeIf(member -> member.getID().equals(memberId));
        System.out.println("Member with ID " + memberId + " removed from the library.");
    }

    public Member findMemberByID(String id) {
        for (Member member : members) {
            if (member.getID().equals(id)) {
                return member;
            }
        }
        return null; // Consider handling this case properly
    }

    public List<Member> findMembersByName(String name) {
        return members.stream()
                .filter(member -> member.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public List<Member> listAllMembers() {
        return new ArrayList<>(members);
    }
}
