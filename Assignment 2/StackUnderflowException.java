
/**
 * @author Frank Choukouali
 *
 */
@SuppressWarnings("serial")
public class StackUnderflowException extends Exception {
	public StackUnderflowException () {
		super("The password cannot contain more than two of the same character in sequence");
	}
}
