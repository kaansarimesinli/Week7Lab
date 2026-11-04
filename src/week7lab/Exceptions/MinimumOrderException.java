package week7lab.Exceptions;

/**
 *
 * @author Kaan
 */
public class MinimumOrderException extends Exception {

    /**
     * Creates a new instance of <code>MinimumOrderException</code> without
     * detail message.
     */
    public MinimumOrderException() {
    }

    /**
     * Constructs an instance of <code>MinimumOrderException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public MinimumOrderException(String msg) {
        super(msg);
    }
}
