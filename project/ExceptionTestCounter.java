import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionTestCounter {

    public static void main(String[] args) {
        // Directory containing test files
        File directory = new File(".");

        // Counter for exception tests
        int exceptionTestCount = 0;

        if (directory.exists() && directory.isDirectory()) {
            // List of specific test files to be checked
            String[] specificTestFiles = {"BookTest.java","CatalogTest.java", "FeeCalculatorTest.java",
            "LoanManagerTest.java", "MemberManagerTest.java","MemberTest.java", "NotificationServiceTest.java",
            "ReportingToolTest.java", "ReservationManagerTest.java", "SearchEngineTest.java"};

            // Iterate through each specific test file
            for (String testFile : specificTestFiles) {
                File file = new File(testFile);
                if (file.exists() && file.isFile()) {
                    // If the test file exists and is a file
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            // Check if the line contains an expected exception annotation
                            if (line.contains("@Test(expected")) {
                                // If found, increment the exception test count
                                exceptionTestCount++;
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        System.out.println("Total number of exception tests: " + exceptionTestCount);
    }
}
