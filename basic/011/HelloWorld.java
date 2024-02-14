/**
 * Represents a simple program to print a formatted box containing a name.
 *
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0126 (last modified)
 * @since 17.0 (minimum Java version)
 */
public class HelloWorld {

    /**
     * Executes the program.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        String formattedBox = helloWorld.printFormattedNameBox("Rishu Kumar");
        System.out.println(formattedBox); // Print the formatted box
    }

    /**
     * Exercise: 1.1 Write the Hello World program.
     *
     * Prints a formatted box containing the provided name.
     *
     * @param name The name to be included in the box.
     * @return A string representing the formatted name box.
     */
    public String printFormattedNameBox(String name) {
        return getFormattedNameBox(name);
    }

    /**
     * Generates a formatted box containing the provided name.
     *
     * @param name The name to be included in the box.
     * @return A string representing the formatted name box.
     */
    private String getFormattedNameBox(String name) {
        int length = name.length() + 16; // Considering padding and asterisks

        String border = "*".repeat(length);

        return String.format("%s\n* Hello, I am %s *\n%s\n", border, name, border);
    }
}
