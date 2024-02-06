/**
 * The PrintProgram class demonstrates printing information.
 *
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0131 (last modified)
 * @since 17.0 (minimum Java version)
 */
import java.text.SimpleDateFormat;
import java.util.Date;

public class PrintProgram {
    /**
     * Exercise: 1.2
     * Write the Print program.
     *
     * @param args Command line arguments. Not used.
     */
    public static void main(String[] args) {
        PrintProgram printer = new PrintProgram();

        String currentDate = getCurrentDate();
        String firstName = "Rishu";
        String lastName = "Kumar";
        int height = 185;
        String output = printer.displayInformation(currentDate, firstName, lastName, height);
        System.out.println(output);
    }

    /**
     * Display the provided information.
     *
     * @param currentDate The current date.
     * @param firstName   The first name.
     * @param lastName    The last name.
     * @param height      The height.
     * @return A string representing the displayed information.
     */
    public String displayInformation(String currentDate, String firstName, String lastName, int height) {
        StringBuilder output = new StringBuilder();
        output.append("The date is ").append(currentDate).append("\n");
        output.append("Hello, I'm ").append(firstName).append(" ").append(lastName).append("\n");
        output.append("I'm ").append(height).append(" cm tall");
        return output.toString();
    }

    /**
     * Get the current date in the format "yyyy-MM-dd".
     *
     * @return The current date.
     */
    public static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(new Date());
    }
}
