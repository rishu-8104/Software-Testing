import java.util.ArrayList;
import java.util.List;

/**
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0131 (last modified)
 * @since 17.0 (minimum Java version)
 */
public class ArraySearch {
    
    /**
     * Searches for values within the specified range in the array.
     *
     * @param array The array of integer values.
     * @param min   The minimum value of the range.
     * @param max   The maximum value of the range.
     * @return      A list of values found within the range.
     */
    public List<Integer> searchInRange(int[] array, int min, int max) {
        List<Integer> resultList = new ArrayList<>();
        for (int value : array) {
            if (value >= min && value <= max) {
                resultList.add(value);
            }
        }
        return resultList;
    }

    /**
     * Mains method to run the program.
     *
     * @param args Command line arguments. Not used.
     */
    public static void main(String[] args) {
        int[] array = {-3, -2, -1, 0, 1, 2, 3};
        int min = -1;
        int max = 2;

        ArraySearch arraySearch = new ArraySearch();
        List<Integer> resultList = arraySearch.searchInRange(array, min, max);

        System.out.print("Program displays: ");
        for (int i = 0; i < resultList.size(); i++) {
            System.out.print(resultList.get(i));
            if (i < resultList.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
