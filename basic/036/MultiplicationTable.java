/**
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0131 (last modified)
 * @since 17.0 (minimum Java version)
 */
public class MultiplicationTable {
    private int size; // The size of the multiplication table

    /**
     * Constructs a MultiplicationTable object with the given size.
     *
     * @param size The size of the multiplication table.
     */
    public MultiplicationTable(int size) {
        this.size = size;
    }

    /**
     * Generates and returns the multiplication table as a string.
     *
     * @return The multiplication table as a string.
     */
    public String generateTable() {
        StringBuilder table = new StringBuilder();

        // Generate header row
        table.append("    |");
        for (int i = 1; i <= size; i++) {
            table.append(String.format("%4d", i));
        }
        table.append("\n-----------------------------------------\n");

        // Generate table rows
        for (int i = 1; i <= size; i++) {
            table.append(String.format("%3d |", i));
            for (int j = 1; j <= size; j++) {
                table.append(String.format("%4d", i * j));
            }
            table.append("\n");
        }

        return table.toString();
    }

    /**
     * Mains method to run the program.
     *
     * @param args Command line arguments. Not used.
     */
    public static void main(String[] args) {
        int size = 9; // Change this value to set the size of the multiplication table
        MultiplicationTable multiplicationTable = new MultiplicationTable(size);
        String table = multiplicationTable.generateTable();
        System.out.println(table);
    }
}
