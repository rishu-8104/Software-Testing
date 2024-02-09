import java.util.Random;

/**
 * The DiceRoller class simulates rolling a dice.
 * It provides a method to generate a random number between 1 and 6, inclusive.
 *
 * @author Rishu Kumar <Rishu.kumar@tuni.fi>
 * @version 2024.0206 (last modified)
 * @since 17.0 (minimum Java version)
 */
public class DiceRoller {

    private Random random;

    /**
     * Constructs a DiceRoller object.
     */
    public DiceRoller() {
        random = new Random();
    }

    /**
     * Simulates rolling a dice and returns the result.
     *
     * @return A random number between 1 and 6, inclusive.
     */
    public int rollDice() {
        return random.nextInt(6) + 1;
    }

    /**
     * Main method to run the program.
     *
     * @param args Command line arguments. Not used.
     */
    public static void main(String[] args) {
        DiceRoller diceRoller = new DiceRoller();
        int value = diceRoller.rollDice();
        System.out.println("Dice value: " + value);
    }
}
