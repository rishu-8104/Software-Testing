import org.junit.Test;
import static org.junit.Assert.*;

public class FeeCalculatorTest {

    @Test
    public void testCalculateFeeWithPositiveDaysOverdue() {
        FeeCalculator feeCalculator = new FeeCalculator();

        System.out.println("................................................");
        System.out.println("Testing calculateFee() method with positive days overdue...");
        long daysOverdue = 5;
        double expectedFee = 5 * 0.5;

        double actualFee = feeCalculator.calculateFee(daysOverdue);

        assertEquals(expectedFee, actualFee, 0.001);
    }

    @Test
    public void testCalculateFeeWithZeroDaysOverdue() {
        FeeCalculator feeCalculator = new FeeCalculator();

        System.out.println("................................................");
        System.out.println("Testing calculateFee() method with zero days overdue...");
        long daysOverdue = 0;
        double expectedFee = 0;

        double actualFee = feeCalculator.calculateFee(daysOverdue);

        assertEquals(expectedFee, actualFee, 0.001);
    }

    @Test
    public void testCalculateFeeWithNegativeDaysOverdue() {
        FeeCalculator feeCalculator = new FeeCalculator();

        System.out.println("................................................");
        System.out.println("Testing calculateFee() method with negative days overdue...");
        long daysOverdue = -3;
        double expectedFee = 0;

        double actualFee = feeCalculator.calculateFee(daysOverdue);

        assertEquals(expectedFee, actualFee, 0.001);
    }

    @Test
    public void testHasOutstandingFeesWhenMemberHasFees() {
        FeeCalculator feeCalculator = new FeeCalculator();
        Member member = new Member("001", "John Doe");

        // Adding fees for the member
        feeCalculator.addFee(member, 10.0);

        System.out.println("................................................");
        System.out.println("Testing hasOutstandingFees() method when member has fees...");
        boolean hasFees = feeCalculator.hasOutstandingFees(member);

        assertTrue(hasFees);
    }

    @Test
    public void testHasOutstandingFeesWhenMemberHasNoFees() {
        FeeCalculator feeCalculator = new FeeCalculator();
        Member member = new Member("002", "Jane Smith");

        System.out.println("................................................");
        System.out.println("Testing hasOutstandingFees() method when member has no fees...");
        boolean hasFees = feeCalculator.hasOutstandingFees(member);

        assertFalse(hasFees);
    }

    @Test
    public void testHasOutstandingFeesForNonExistingMember() {
        FeeCalculator feeCalculator = new FeeCalculator();
        Member member = new Member("003", "Alice Johnson");

        System.out.println("................................................");
        System.out.println("Testing hasOutstandingFees() method for a non-existing member...");
        boolean hasFees = feeCalculator.hasOutstandingFees(member);

        assertFalse(hasFees);
    }

    @Test
    public void testPayFeesWhenAmountCoversAllFees() {
        FeeCalculator feeCalculator = new FeeCalculator();
        Member member = new Member("001", "John Doe");

        // Adding fees for the member
        feeCalculator.addFee(member, 10.0);

        System.out.println("................................................");
        System.out.println("Testing payFees() method when amount covers all fees...");
        feeCalculator.payFees(member, 10.0);

        double outstandingFees = feeCalculator.getOutstandingFees(member);
        assertEquals(0.0, outstandingFees, 0.001);
    }

    @Test
    public void testPayFeesWhenAmountIsLessThanOutstandingFees() {
        FeeCalculator feeCalculator = new FeeCalculator();
        Member member = new Member("002", "Jane Smith");

        // Adding fees for the member
        feeCalculator.addFee(member, 15.0);

        System.out.println("................................................");
        System.out.println("Testing payFees() method when amount is less than outstanding fees...");
        feeCalculator.payFees(member, 10.0);

        double outstandingFees = feeCalculator.getOutstandingFees(member);
        assertEquals(5.0, outstandingFees, 0.001);
    }

    @Test
    public void testPayFeesWhenAmountIsGreaterThanOutstandingFees() {
        FeeCalculator feeCalculator = new FeeCalculator();
        Member member = new Member("003", "Alice Johnson");

        // Adding fees for the member
        feeCalculator.addFee(member, 5.0);

        System.out.println("................................................");
        System.out.println("Testing payFees() method when amount is greater than outstanding fees...");
        feeCalculator.payFees(member, 10.0);

        double outstandingFees = feeCalculator.getOutstandingFees(member);
        assertEquals(0.0, outstandingFees, 0.001);
    }
    @Test
    public void testGetOutstandingFeesWhenMemberHasFees() {
        FeeCalculator feeCalculator = new FeeCalculator();
        Member member = new Member("001", "John Doe");

        // Adding fees for the member
        feeCalculator.addFee(member, 10.0);

        System.out.println("................................................");
        System.out.println("Testing getOutstandingFees() method when member has fees...");
        double outstandingFees = feeCalculator.getOutstandingFees(member);

        assertEquals(10.0, outstandingFees, 0.001);
    }

    @Test
    public void testGetOutstandingFeesWhenMemberHasNoFees() {
        FeeCalculator feeCalculator = new FeeCalculator();
        Member member = new Member("002", "Jane Smith");

        System.out.println("................................................");
        System.out.println("Testing getOutstandingFees() method when member has no fees...");
        double outstandingFees = feeCalculator.getOutstandingFees(member);

        assertEquals(0.0, outstandingFees, 0.001);
    }

    @Test
    public void testGetOutstandingFeesForNonExistingMember() {
        FeeCalculator feeCalculator = new FeeCalculator();
        Member member = new Member("003", "Alice Johnson");

        System.out.println("................................................");
        System.out.println("Testing getOutstandingFees() method for a non-existing member...");
        double outstandingFees = feeCalculator.getOutstandingFees(member);

        assertEquals(0.0, outstandingFees, 0.001);
    }

    @Test
    public void testClearMemberFeesWhenMemberHasFees() {
        FeeCalculator feeCalculator = new FeeCalculator();
        Member member = new Member("001", "John Doe");

        // Adding fees for the member
        feeCalculator.addFee(member, 10.0);

        System.out.println("................................................");
        System.out.println("Testing clearMemberFees() method when member has fees...");
        feeCalculator.clearMemberFees(member);

        double outstandingFees = feeCalculator.getOutstandingFees(member);
        assertEquals(0.0, outstandingFees, 0.001);
    }

    @Test
    public void testClearMemberFeesWhenMemberHasNoFees() {
        FeeCalculator feeCalculator = new FeeCalculator();
        Member member = new Member("002", "Jane Smith");

        System.out.println("................................................");
        System.out.println("Testing clearMemberFees() method when member has no fees...");
        feeCalculator.clearMemberFees(member);

        double outstandingFees = feeCalculator.getOutstandingFees(member);
        assertEquals(0.0, outstandingFees, 0.001);
    }

    @Test
    public void testClearMemberFeesForNonExistingMember() {
        FeeCalculator feeCalculator = new FeeCalculator();
        Member member = new Member("003", "Alice Johnson");

        System.out.println("................................................");
        System.out.println("Testing clearMemberFees() method for a non-existing member...");
        feeCalculator.clearMemberFees(member);

        double outstandingFees = feeCalculator.getOutstandingFees(member);
        assertEquals(0.0, outstandingFees, 0.001);
    }
    @Test
    public void testAddFeeForMemberWithExistingFees() {
        FeeCalculator feeCalculator = new FeeCalculator();
        Member member = new Member("001", "John Doe");

        // Adding initial fee
        feeCalculator.addFee(member, 10.0);

        System.out.println("................................................");
        System.out.println("Testing addFee() method for a member with existing fees...");
        feeCalculator.addFee(member, 5.0);

        double outstandingFees = feeCalculator.getOutstandingFees(member);
        assertEquals(15.0, outstandingFees, 0.001);
    }

    @Test
    public void testAddFeeForMemberWithNoExistingFees() {
        FeeCalculator feeCalculator = new FeeCalculator();
        Member member = new Member("002", "Jane Smith");

        System.out.println("................................................");
        System.out.println("Testing addFee() method for a member with no existing fees...");
        feeCalculator.addFee(member, 10.0);

        double outstandingFees = feeCalculator.getOutstandingFees(member);
        assertEquals(10.0, outstandingFees, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddFeeWithNegativeAmount() {
        FeeCalculator feeCalculator = new FeeCalculator();
        Member member = new Member("003", "Alice Johnson");

        System.out.println("................................................");
        System.out.println("Testing addFee() method with negative amount...");

        // Adding negative fee, which should throw an IllegalArgumentException
        feeCalculator.addFee(member, -5.0);
    }
    
}
