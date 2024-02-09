/**
 * @author      Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version     2024.0126 (last modified)
 * @since       17.0 (minimum Java version)
 */
public class HelloWorld {

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld(); // Instantiating the HelloWorld object
        helloWorld.printFormattedNameBox("Rishu Kumar");
    }

    /**
     * Exercise: 1.1
     * Write the Hello World program.
     *
     * @param name The name to be included in the box.
     */
    public void printFormattedNameBox(String name) {
        String formattedBox = getFormattedNameBox(name);
        System.out.println(formattedBox);
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
