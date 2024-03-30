import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    BookTest.class,
    CatalogTest.class,
    FeeCalculatorTest.class,
    LoanManagerTest.class,
    MemberTest.class,
    MemberManagerTest.class,
    NotificationServiceTest.class,
    ReportingToolTest.class,
    ReservationManagerTest.class,
    SearchEngineTest.class
})
public class AllTestsSuite {
    // Main method to serve as entry point for the test suite execution
    public static void main(String[] args) {
        // Run the JUnit test suite
        org.junit.runner.JUnitCore.main("AllTestsSuite");
    }
}
