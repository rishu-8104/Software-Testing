/**
 * The TemperatureReport class stores temperature values in an array and generates a report.
 * It calculates the minimum, maximum, and average temperatures.
 *
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0131 (last modified)
 * @since 17.0 (minimum Java version)
 */
public class TemperatureReport {
    private double[] temperatures;

    /**
     * Constructs a TemperatureReport object with the given temperature values.
     *
     * @param temperatures The array of temperature values.
     */
    public TemperatureReport(double[] temperatures) {
        this.temperatures = temperatures;
    }

    /**
     * Generates and returns a report containing the minimum, maximum, and average temperatures.
     *
     * @return A report string containing the minimum, maximum, and average temperatures.
     */
    public String generateReport() {
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        double sum = 0;

        // Calculate min, max, and sum
        for (double temp : temperatures) {
            if (temp < min) {
                min = temp;
            }
            if (temp > max) {
                max = temp;
            }
            sum += temp;
        }

        // Calculate average
        double avg = sum / temperatures.length;

        // Generate report
        StringBuilder report = new StringBuilder();
        report.append("Temperatures:\n");
        report.append("Min: ").append(min).append("\n");
        report.append("Max: ").append(max).append("\n");
        report.append("Avg: ").append(avg).append("\n");

        return report.toString();
    }

    /**
     * Main method to run the program.
     *
     * @param args Command line arguments. Not used.
     */
    public static void main(String[] args) {
        double[] temperatures = {12.5, 15.2, 14.7, 18.9, 21.5, 20.3, 16.8, 19.7, 22.1, 17.6};
        TemperatureReport report = new TemperatureReport(temperatures);
        String result = report.generateReport();
        System.out.println(result);
    }
}
