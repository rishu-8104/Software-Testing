/**
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0131 (last modified)
 * @since 17.0 (minimum Java version)
 */
public class ArrayMaxValueFinder {

    /**
     * Finds the maximum value in the given integer array.
     *
     * @param array The array containing integers.
     * @param length The length of the array.
     * @return The maximum value in the array.
     */
    public int max(int[] array, int length) {
        int max = array[0];
        for (int i = 1; i < length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    /**
     * Mains method to run the program.
     *
     * @param args Command line arguments. Not used.
     */
    public static void main(String[] args) {
        int length = 3;
        int[] array = {3, 1, 2};
        ArrayMaxValueFinder finder = new ArrayMaxValueFinder();
        int max = finder.max(array, length);
        System.out.println("Maximum value of the array: " + max);
    }
}

