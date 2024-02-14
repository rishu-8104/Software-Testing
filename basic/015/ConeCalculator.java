/**
 * The ConeCalculator class calculates and displays the volume of a cone.
 * It provides methods to calculate the volume of a cone and display the results.
 *
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0131 (last modified)
 * @since 17.0 (minimum Java version)
 */
public class ConeCalculator {

    /**
     * Exercise: 1.5 Write the cone calculator program.
     *
     * Calculates the volume of a cone given its radius and height.
     *
     * @param radius The radius of the cone.
     * @param height The height of the cone.
     * @return The volume of the cone.
     */
    public double calculateConeVolume(double radius, double height) {
        return (Math.PI * radius * radius * height) / 3;
    }

    /**
     * Calculates the volume of a cone and displays the results.
     *
     * @param radius The radius of the cone.
     * @param height The height of the cone.
     * @return A string representing the cone volume calculation results.
     */
    public String calculateAndDisplayConeVolume(double radius, double height) {
        double volume = calculateConeVolume(radius, height);
        return displayResults(radius, height, volume);
    }

    /**
     * Formats and displays the cone volume calculation results.
     *
     * @param radius The radius of the cone.
     * @param height The height of the cone.
     * @param volume The volume of the cone.
     * @return A string representing the formatted cone volume calculation results.
     */
    public String displayResults(double radius, double height, double volume) {
        return String.format("Radius (r): %.2f\nHeight (h): %.2f\nVolume    : %.2f", radius, height, volume);
    }

    /**
     * Main method to demonstrate the use of the calculateAndDisplayConeVolume method.
     *
     * @param args Command line arguments. Not used.
     */
    public static void main(String[] args) {
        ConeCalculator calculator = new ConeCalculator();
        String result = calculator.calculateAndDisplayConeVolume(3, 4);
        System.out.println(result);
    }
}
