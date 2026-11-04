package week7lab.Exceptions;

/**
 *
 * @author Kaan
 */
public class ItemNotFoundException extends Exception {

    /**
     * Creates a new instance of <code>ItemNotFoundException</code> without
     * detail message.
     */
    public ItemNotFoundException() {
    }

    /**
     * Constructs an instance of <code>ItemNotFoundException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ItemNotFoundException(String msg) {
        super(msg);
    }
}
