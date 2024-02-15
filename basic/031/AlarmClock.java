/**
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0131 (last modified)
 * @since 17.0 (minimum Java version)
 */
public class AlarmClock {

    /**
     * Emulates an alarm clock by counting backwards until reaching 1, then displaying "ALARM!".
     *
     * @param args Command line arguments. Not used.
     * @return
     */
    public static void main(String[] args) {
        int max = 10; // Change this value to set the maximum count

        // Loop to count backwards
        for (int i = max; i >= 1; i--) {
            if (i == 1) {
                System.out.println("ALARM!");
            } else {
                System.out.print(i + ", ");
            }
        }
    }
}
