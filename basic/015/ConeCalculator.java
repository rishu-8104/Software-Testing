/**
 * @author      Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version     2024.0131 (last modified)
 * @since       17.0 (miminimum Java version)
 */
public class ConeCalculator {
/**
     * Exercise: 1.5
     * Write the cone calculator program.
     *
     * @param  args  Command line arguments. Not used.
     */
    public static void main(String[] args) {
        ConeCalculator calculator = new ConeCalculator();
        String result = calculator.calculateAndDisplayConeVolume(3, 4);
        System.out.println(result);
    }

    public String calculateAndDisplayConeVolume(double radius, double height) {
        double volume = calculateConeVolume(radius, height);
        return displayResults(radius, height, volume);
    }

    public double calculateConeVolume(double radius, double height) {
        return (Math.PI * radius * radius * height) / 3;
    }

    public String displayResults(double radius, double height, double volume) {
        return String.format("Radius (r): %.2f\nHeight (h): %.2f\nVolume    : %.2f", radius, height, volume);
    }
}


// End of file

