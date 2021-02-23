import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Frank Choukouali
 *
 * @param <T>
 */
public class NotationStack<T> implements StackInterface<T> {
	private Object MyStack[];
	private int top;
	private int size;

	/**
	 * default constructor - uses default as the size of the stack
	 */
	public NotationStack() {
		this.size = 1546;
		MyStack = new Object[1546];
		top = -1;
	}

	/**
	 * @param length NotationQueue constructor takes in an int as the size of the
	 *               stack
	 */
	public NotationStack(int length) {
		this.size = length;
		MyStack = new Object[length];
		top = -1;
	}

	/**
	 * Determines if Stack is empty
	 * 
	 * @return true if Stack is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	/**
	 * Determines if Stack is full
	 * 
	 * @return true if Stack is full, false if not
	 */
	@Override
	public boolean isFull() {

		return top == size - 1;
	}

	/**
	 * Deletes and returns the element at the top of the Stack
	 * 
	 * @return the element at the top of the Stack
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T pop() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException();
		}
		return (T) MyStack[top--];
	}

	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * @return the element at the top of the Stack
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T top() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException();
		}
		return (T) MyStack[top];
	}

	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	@Override
	public int size() {
		return top + 1;
	}

	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 */
	@Override
	public boolean push(T e) throws StackOverflowException {
		if (isFull()) {
			throw new StackOverflowException();
		}

		MyStack[++top] = e;
		return true;
	}

	/**
	 * Returns the elements of the Stack in a string from bottom to top, the
	 * beginning of the String is the bottom of the stack
	 * 
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i <= top; i++) {
			result += MyStack[i];
		}
		return result;
	}

	/**
	 * Returns the string representation of the elements in the Stack, the beginning
	 * of the string is the bottom of the stack Place the delimiter between all
	 * elements of the Stack
	 * 
	 * @return string representation of the Stack from bottom to top with elements
	 *         separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		String result = "";
		for (int i = 0; i <= top; i++) {
			result += MyStack[i] + (i == top ? "" : delimiter);
		}
		return result;

	}

	/**
	 * Fills the Stack with the elements of the ArrayList, First element in the
	 * ArrayList is the first bottom element of the Stack
	 * 
	 * @param list elements to be added to the Stack from bottom to top
	 */

	@Override
	public void fill(ArrayList<T> list) {
		@SuppressWarnings("unchecked")
		ArrayList<T> copyArrayList = (ArrayList<T>) list.clone();
		MyStack = new Object[copyArrayList.size()];
		top = -1;
		for (int i = 0; i < copyArrayList.size(); i++) {
			MyStack[i] = copyArrayList.get(i);
			top++;
		}
	}

}
