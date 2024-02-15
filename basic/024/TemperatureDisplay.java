/**
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0131 (last modified)
 * @since 17.0 (minimum Java version)
 */
public class TemperatureDisplay {
    final int TORONTO = 0;
    final int MONTREAL = 1;
    final int VANCOUVER = 2;

    /**
     * Writes a program that solves the problem using logical operators.
     *
     * @param args Command line arguments. Not used.
     */
    public static void main(String[] args) {
        TemperatureDisplay temperatureDisplay = new TemperatureDisplay();

        final int city = temperatureDisplay.TORONTO; // Change this value to TORONTO, MONTREAL, or VANCOUVER as desired
        int temperature = -25; // Change this value to the current temperature

        String result = temperatureDisplay.determineWeather(city, temperature);
        System.out.println(result);
    }

    /**
     * Determines the weather condition based on city and temperature.
     *
     * @param city The city (TORONTO, MONTREAL, or VANCOUVER).
     * @param temperature The temperature in Celsius.
     * @return The weather condition based on the given city and temperature.
     */
    public String determineWeather(int city, int temperature) {
        if (city == MONTREAL && temperature < -20) {
            return "Freezing";
        } else if ((city == VANCOUVER || city == TORONTO) && temperature < -20) {
            return "Ice Freezing";
        } else if (city == MONTREAL && temperature >= -20) {
            return "Moderate Winter";
        } else if ((city == VANCOUVER || city == TORONTO) && temperature >= -20 && temperature <= -10) {
            return "Ice Cold";
        } else {
            return "Unknown weather condition";
        }
    }
}
