package CustomExceptions;
/**
 * @author Aidin Ghassemloi
 * Custom exception class. Will be thrown when hero tries to equip wrong armour.
 */
public class InvalidArmourException extends Exception {
    public InvalidArmourException(String message) {
        super(message);
    }
}

