
/**
 * @author Frank Choukouali
 *
 */
@SuppressWarnings("serial")
public class StackOverflowException extends Exception {
	public StackOverflowException() {
		super("This should have caused an StackOverflowException");
	}
}
