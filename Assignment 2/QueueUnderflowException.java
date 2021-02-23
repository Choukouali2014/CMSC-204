
/**
 * @author Frank Choukouali
 */
@SuppressWarnings("serial")
public class QueueUnderflowException extends Exception {
	public QueueUnderflowException () {
		super("This should have caused an QueueUnderflowException");
	}
}
