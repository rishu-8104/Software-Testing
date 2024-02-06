/**
 * The ArrowPatternDrawer class draws the specified arrow pattern to the screen based on the defined size and character.
 *
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0206 (last modified: 2024.0206)
 * @since 17.0 (minimum Java version)
 */
public class ArrowPatternDrawer {
    /**
     * Exercise: 3.5
     * Write a program to display the specified arrow pattern to the screen based on the defined size and character.
     *
     * @param args Command line arguments. Not used.
     */
    public static void main(String[] args) {
        int size = 5; // Change this value to set the size of the arrow
        char character = '*'; // Change this character to customize the displayed character

        // Loop to iterate through each row
        for (int i = 0; i < size; i++) {
            // Loop to iterate through each column
            for (int j = 0; j < size; j++) {
                // Print spaces for the first half of the arrow
                if (j < i) {
                    System.out.print("  ");
                } else {
                    // Print the specified character for the second half of the arrow
                    System.out.print(character + " ");
                }
            }
            System.out.println(); // Move to the next line after each row
        }
    }
}
