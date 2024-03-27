/**
 * Manages the collection of members in the library system. This class handles adding and removing
 * members, and provides methods to search for members by ID or name. It allows for the management of
 * member records, ensuring that the library can keep track of all its members efficiently.
 *
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0319 (last modified)
 * @since 17.0 (minimum Java version)
 */
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberManager {
    private List<Member> members;

    /**
     * Constructs a new MemberManager instance. Initializes an empty list of members.
     */
    public MemberManager() {
        this.members = new ArrayList<>();
    }

    /**
     * Adds a member to the library's member list and prints a confirmation message.
     *
     * @param member The member to be added.
     */
    public void addMember(Member member) {
        members.add(member);
        System.out.println("Member added: " + member.getName() + " with ID " + member.getID());
    }

    /**
     * Removes a member from the library's member list based on the member ID and prints a confirmation message.
     *
     * @param memberId The ID of the member to be removed.
     */
    public void removeMember(String memberId) {
        members.removeIf(member -> member.getID().equals(memberId));
        System.out.println("Member with ID " + memberId + " removed from the library.");
    }

    /**
     * Finds a member by their ID.
     *
     * @param id The ID of the member to find.
     * @return The member with the specified ID, or null if no such member exists.
     */
    public Member findMemberByID(String id) {
        for (Member member : members) {
            if (member.getID().equals(id)) {
                return member;
            }
        }
        return null; // Consider improving this by possibly throwing a custom exception if a member is not found.
    }

    /**
     * Finds members by their name. The search is case-insensitive.
     *
     * @param name The name of the members to search for.
     * @return A list of members whose names match the search criteria.
     */
    public List<Member> findMembersByName(String name) {
        return members.stream()
                .filter(member -> member.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    /**
     * Lists all members currently registered in the library.
     *
     * @return A list containing all members.
     */
    public List<Member> listAllMembers() {
        return new ArrayList<>(members);
    }
}
