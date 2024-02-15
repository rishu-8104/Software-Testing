/**
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0131 (last modified)
 * @since 17.0 (minimum Java version)
 */
public class ArrayValueFinder {

    /**
     * Finds the first value in the specified range within the given integer array.
     *
     * @param array The array containing integers.
     * @param length The length of the array.
     * @param from The lower bound of the range.
     * @param to The upper bound of the range.
     * @param notFound The value to return if no value is found within the range.
     * @return The first value in the range, or the specified 'notFound' value if no value is found.
     */
    public int find(int[] array, int length, int from, int to, int notFound) {
        for (int i = 0; i < length; i++) {
            if (array[i] >= from && array[i] <= to) {
                return array[i];
            }
        }
        return notFound;
    }

    /**
     * Mains method to run the program.
     *
     * @param args Command line arguments. Not used.
     */
    public static void main(String[] args) {
        int length = 3;
        int[] array = {3, 1, 2};
        int from = 2;
        int to = 10;
        final int NOT_FOUND = -1;
        ArrayValueFinder finder = new ArrayValueFinder();
        int value = finder.find(array, length, from, to, NOT_FOUND);
        System.out.println("Value found in range [" + from + ", " + to + "]: " + value);
    }
}
