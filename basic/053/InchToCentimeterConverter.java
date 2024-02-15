/**
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0131 (last modified)
 * @since 17.0 (minimum Java version)
 */
public class InchToCentimeterConverter {
    private double[] inches;
    private double[] centimeters;

    /**
     * Constructs an InchToCentimeterConverter object with the given inch values.
     *
     * @param inches The array of inch values.
     */
    public InchToCentimeterConverter(double[] inches) {
        this.inches = inches;
        this.centimeters = new double[inches.length];
        convertToCentimeters();
    }

    /**
     * Converts the inch values to centimeters.
     */
    private void convertToCentimeters() {
        for (int i = 0; i < inches.length; i++) {
            centimeters[i] = inches[i] * 2.54;
        }
    }

    /**
     * Displays the conversions from inches to centimeters.
     */
    public void displayConversions() {
        for (int i = 0; i < inches.length; i++) {
            System.out.printf("%.1f in = %.2f cm%n", inches[i], centimeters[i]);
        }
    }

    /**
     * Mains method to run the program.
     *
     * @param args Command line arguments. Not used.
     * @return
     */
    public static void main(String[] args) {
        double[] inches = {1, 2, 3};
        InchToCentimeterConverter converter = new InchToCentimeterConverter(inches);
        converter.displayConversions();
    }
}
