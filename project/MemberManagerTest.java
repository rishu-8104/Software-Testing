import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class MemberManagerTest {

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullMember() {
        MemberManager manager = new MemberManager();
        manager.addMember(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveMemberWithNullID() {
        MemberManager manager = new MemberManager();
        manager.removeMember(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveMemberWithEmptyID() {
        MemberManager manager = new MemberManager();
        manager.removeMember("");
    }
    @Test
    public void testAddMember() {
        MemberManager manager = new MemberManager();
        Member member = new Member("John Doe", "001");

        manager.addMember(member);
        assertEquals("Member should be added", 1, manager.listAllMembers().size());
        assertTrue("Member should be present in the list", manager.listAllMembers().contains(member));
        System.out.println("Test Passed: Member added successfully");
    }

    @Test
    public void testAddMultipleMembers() {
        MemberManager manager = new MemberManager();
        Member member1 = new Member("John Doe", "001");
        Member member2 = new Member("Jane Smith", "002");

        manager.addMember(member1);
        manager.addMember(member2);

        assertEquals("Two members should be added", 2, manager.listAllMembers().size());
        assertTrue("First member should be present in the list", manager.listAllMembers().contains(member1));
        assertTrue("Second member should be present in the list", manager.listAllMembers().contains(member2));
        System.out.println("Test Passed: Multiple members added successfully");
    }

    @Test
    public void testAddDuplicateMember() {
        MemberManager manager = new MemberManager();
        Member member = new Member("John Doe", "001");

        manager.addMember(member);
        manager.addMember(member); // Adding the same member again

        assertEquals("Only one member should be added", 1, manager.listAllMembers().size());
        System.out.println("Test Passed: Duplicate member not added");
    }
    @Test
    public void testRemoveExistingMember() {
        MemberManager manager = new MemberManager();
        Member member = new Member("John Doe", "001");
        manager.addMember(member);

        manager.removeMember("001");

        assertNull("Member should be removed", manager.findMemberByID("001"));
        System.out.println("Test Passed: Existing member removed successfully");
    }

    @Test
    public void testRemoveNonExistingMember() {
        MemberManager manager = new MemberManager();
        Member member = new Member("John Doe", "001");
        manager.addMember(member);

        manager.removeMember("002");

        assertNotNull("Existing member should not be removed", manager.findMemberByID("001"));
        System.out.println("Test Passed: Non-existing member not removed");
    }

    @Test
    public void testRemoveMultipleMembers() {
        MemberManager manager = new MemberManager();
        Member member1 = new Member("John Doe", "001");
        Member member2 = new Member("Jane Smith", "002");
        manager.addMember(member1);
        manager.addMember(member2);

        manager.removeMember("001");

        assertNull("Removed member should not be found", manager.findMemberByID("001"));
        assertNotNull("Non-removed member should be found", manager.findMemberByID("002"));
        System.out.println("Test Passed: Multiple members removed successfully");
    }
    @Test
    public void testFindExistingMemberByID() {
        MemberManager manager = new MemberManager();
        Member member = new Member("John Doe", "001");
        manager.addMember(member);

        Member foundMember = manager.findMemberByID("001");

        assertNotNull("Member should be found", foundMember);
        assertEquals("Found member's ID should match", "001", foundMember.getID());
        System.out.println("Test Passed: Existing member found by ID");
    }

    @Test
    public void testFindNonExistingMemberByID() {
        MemberManager manager = new MemberManager();
        Member member = new Member("John Doe", "001");
        manager.addMember(member);

        Member foundMember = manager.findMemberByID("002");

        assertNull("Non-existing member should not be found", foundMember);
        System.out.println("Test Passed: Non-existing member not found by ID");
    }

    @Test
    public void testFindMemberByIDInEmptyList() {
        MemberManager manager = new MemberManager();

        Member foundMember = manager.findMemberByID("001");

        assertNull("Member should not be found in empty list", foundMember);
        System.out.println("Test Passed: Member not found in empty list");
    }
    @Test
    public void testFindExistingMembersByName() {
        MemberManager manager = new MemberManager();
        Member member1 = new Member("John Doe", "001");
        Member member2 = new Member("John Doe", "002");
        Member member3 = new Member("Jane Smith", "003");
        manager.addMember(member1);
        manager.addMember(member2);
        manager.addMember(member3);

        List<Member> foundMembers = manager.findMembersByName("John Doe");

        assertNotNull("Members should be found", foundMembers);
        assertEquals("Number of found members should be correct", 2, foundMembers.size());
        assertTrue("Found members should contain member1", foundMembers.contains(member1));
        assertTrue("Found members should contain member2", foundMembers.contains(member2));
        System.out.println("Test Passed: Existing members found by name");
    }

    @Test
    public void testFindNonExistingMembersByName() {
        MemberManager manager = new MemberManager();
        Member member1 = new Member("John Doe", "001");
        manager.addMember(member1);

        List<Member> foundMembers = manager.findMembersByName("Jane Smith");

        assertNotNull("No members should be found", foundMembers);
        assertTrue("Found members list should be empty", foundMembers.isEmpty());
        System.out.println("Test Passed: Non-existing members not found by name");
    }

    @Test
    public void testFindMembersByNameInEmptyList() {
        MemberManager manager = new MemberManager();

        List<Member> foundMembers = manager.findMembersByName("John Doe");

        assertNotNull("No members should be found", foundMembers);
        assertTrue("Found members list should be empty", foundMembers.isEmpty());
        System.out.println("Test Passed: Members not found by name in empty list");
    }
    @Test
    public void testListAllMembersWithExistingMembers() {
        MemberManager manager = new MemberManager();
        Member member1 = new Member("John Doe", "001");
        Member member2 = new Member("Jane Smith", "002");
        manager.addMember(member1);
        manager.addMember(member2);

        List<Member> allMembers = manager.listAllMembers();

        assertNotNull("List of members should not be null", allMembers);
        assertEquals("Number of members should be correct", 2, allMembers.size());
        assertTrue("All members should contain member1", allMembers.contains(member1));
        assertTrue("All members should contain member2", allMembers.contains(member2));
        System.out.println("Test Passed: All existing members listed");
    }

    @Test
    public void testListAllMembersWithNoMembers() {
        MemberManager manager = new MemberManager();

        List<Member> allMembers = manager.listAllMembers();

        assertNotNull("List of members should not be null", allMembers);
        assertTrue("List of members should be empty", allMembers.isEmpty());
        System.out.println("Test Passed: No members listed in an empty manager");
    }

    @Test
    public void testListAllMembersAfterRemovingMembers() {
        MemberManager manager = new MemberManager();
        Member member1 = new Member("John Doe", "001");
        Member member2 = new Member("Jane Smith", "002");
        manager.addMember(member1);
        manager.addMember(member2);
        manager.removeMember("001");

        List<Member> allMembers = manager.listAllMembers();

        assertNotNull("List of members should not be null", allMembers);
        assertEquals("Number of members should be correct", 1, allMembers.size());
        assertFalse("All members should not contain removed member", allMembers.contains(member1));
        assertTrue("All members should contain remaining member", allMembers.contains(member2));
        System.out.println("Test Passed: All members listed after removing some members");
    }

}
