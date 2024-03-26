package project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MemberManager {
    private Map<String, Member> members;

    // Constructor
    public MemberManager() {
        this.members = new HashMap<>();
    }

    // Adds a new member to the library
    public void addMember(Member member) {
        if (!members.containsKey(member.getID())) {
            members.put(member.getID(), member);
            System.out.println("Member " + member.getName() + " added successfully.");
        } else {
            System.out.println("Member with ID " + member.getID() + " already exists.");
        }
    }

    // Removes a member from the library
    public void removeMember(String memberId) {
        if (members.containsKey(memberId)) {
            members.remove(memberId);
            System.out.println("Member with ID " + memberId + " removed successfully.");
        } else {
            System.out.println("Member with ID " + memberId + " does not exist.");
        }
    }

    // Finds a member by ID
    public Member findMemberByID(String id) {
        return members.get(id); // Returns null if the member is not found
    }

    // Finds members by name
    public List<Member> findMembersByName(String name) {
        return members.values().stream()
                .filter(member -> member.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    // Lists all members of the library
    public List<Member> listAllMembers() {
        return new ArrayList<>(members.values());
    }
}

