README

The Library Management System (LMS) is designed to efficiently manage library resources and member activities.

Classes such as Book, Catalog, FeeCalculator, LoanManager, Member, MemberManager, NotificationService, ReportingTool, ReservationManager, SearchEngine, and Main.java are included in the project.


To compile the application:

1. Navigate to the project directory containing the source code and test files.
2. Compile the source code and test files using the following command:

    javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar *.java

   This command compiles all Java files in the directory along with the necessary JAR files for JUnit.

To run the Main.java

    java Main

To run the tests:

1. After compiling the application, execute the test suite using the following command:

    java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar AllTestsSuite

   This command runs the test suite, which includes all test classes in the project.

2. After running the tests, review the test results to ensure all tests pass.

Note: Make sure to replace ":" with ";" in the classpath separator if you're using Windows.
