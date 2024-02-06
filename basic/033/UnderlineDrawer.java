/**
 * The UnderlineDrawer class draws an underline below a given string.
 *
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0206 (last modified: 2024.0206)
 * @since 17.0 (minimum Java version)
 */
public class UnderlineDrawer {
    /**
     * Exercise: 3.3
     * Write a program to draw an underline below a string.
     *
     * @param args Command line arguments. Not used.
     */
    public static void main(String[] args) {
        String str = "This is a test"; // Change this string to draw underline below it
        int length = str.length();

        // Print the original string
        System.out.println(str);

        // Print the underline
        for (int i = 0; i < length; i++) {
            System.out.print("-");
        }
        System.out.println(); // Move to the next line
    }
}
