package CustomExceptions;
/**
 * @author Aidin Ghassemloi
 * Custom exception class. Will be thrown when hero tries to equip wrong weapon.
 */
public class InvalidWeaponException extends Exception {
    public InvalidWeaponException(String message) {
        super(message);
    }
}
