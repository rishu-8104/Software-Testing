/**
 * The ColumnNumbersDisplay class displays 10-based column numbers to the screen with a configurable length.
 * It provides a method to display the numbers.
 *
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0131 (last modified)
 * @since 17.0 (minimum Java version)
 */
public class ColumnNumbersDisplay {

    /**
     * Displays 10-based column numbers with a configurable length.
     *
     * @param length The length of the display.
     * @return The string containing the 10-based column numbers.
     */
    public String displayColumnNumbers(int length) {
        StringBuilder result = new StringBuilder();

        // Loop to construct the string of 10-based column numbers
        for (int i = 1; i <= length; i++) {
            result.append(i % 10); // Append the current number modulo 10 to get 10-based column numbers
        }

        return result.toString();
    }

    /**
     * Main method to run the program.
     *
     * @param args Command line arguments. Not used.
     */
    public static void main(String[] args) {
        ColumnNumbersDisplay columnNumbersDisplay = new ColumnNumbersDisplay();
        int length = 25; // Change this value to set the length of the display
        String numbers = columnNumbersDisplay.displayColumnNumbers(length);
        System.out.println(numbers);
    }
}
