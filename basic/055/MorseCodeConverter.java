import java.util.HashMap;
import java.util.Map;

/**
 * The MorseCodeConverter class converts a phone number string into Morse code for numbers.
 * It provides a method to perform this conversion.
 *
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0131 (last modified)
 * @since 17.0 (minimum Java version)
 */
public class MorseCodeConverter {
    private final Map<Character, String> morseCodeMap;

    /**
     * Constructs a MorseCodeConverter object and initializes the Morse code map for numbers.
     */
    public MorseCodeConverter() {
        morseCodeMap = new HashMap<>();
        morseCodeMap.put('0', "-----");
        morseCodeMap.put('1', ".----");
        morseCodeMap.put('2', "..---");
        morseCodeMap.put('3', "...--");
        morseCodeMap.put('4', "....-");
        morseCodeMap.put('5', ".....");
        morseCodeMap.put('6', "-....");
        morseCodeMap.put('7', "--...");
        morseCodeMap.put('8', "---..");
        morseCodeMap.put('9', "----.");
    }

    /**
     * Converts a phone number string into Morse code for numbers.
     *
     * @param phoneNumber The phone number string to convert.
     * @return            The Morse code representation of the phone number.
     */
    public String convertToMorseCode(String phoneNumber) {
        StringBuilder morseCode = new StringBuilder();
        for (char digit : phoneNumber.toCharArray()) {
            if (Character.isDigit(digit)) {
                morseCode.append(morseCodeMap.get(digit)).append(" ");
            }
        }
        return morseCode.toString().trim();
    }

    /**
     * Main method to run the program.
     *
     * @param args Command line arguments. Not used.
     */
    public static void main(String[] args) {
        String phoneNumber = "050123456";
        MorseCodeConverter converter = new MorseCodeConverter();
        String morseCode = converter.convertToMorseCode(phoneNumber);
        System.out.println("Morse code for " + phoneNumber + ": " + morseCode);
    }
}
