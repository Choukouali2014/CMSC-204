import java.util.ArrayList;

/**
 * @author Frank Choukouali
 *
 * @param <T>
 */
public class NotationQueue<T> implements QueueInterface<T> {
	private int size, frontQueue, backQueue, capacity;
	private Object MyQueue[];

	/**
	 * default constructor - uses a default as the size of the queue
	 */
	public NotationQueue() {
		size = 50;
		this.capacity = 0;
		this.frontQueue = -1;
		this.backQueue = -1;
		MyQueue = new Object[50];
	}

	/**
	 * NotationQueue constructor takes an int as the size of the queue
	 * @param i 
	 */
	public NotationQueue(int i) {
		this.size = i;
		this.capacity = 0;
		this.frontQueue = -1;
		this.backQueue = -1;
		MyQueue = new Object[i];
	}

	/**
	 * Determines if Queue is empty
	 * 
	 * @return true if Queue is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		return this.frontQueue == -1 && this.backQueue == -1;
	}

	/**
	 * Determines of the Queue is full
	 * 
	 * @return true if Queue is full, false if not
	 */
	@Override
	public boolean isFull() {

		return (this.frontQueue == 0 && this.backQueue == this.size - 1);
	}

	/**
	 * Delete and return the element at the front of the Queue
	 * 
	 * @return the element at the front of the Queue
	 */
	@Override
	public T dequeue() throws QueueUnderflowException {

		if (isEmpty()) {
			throw new QueueUnderflowException();
		}
		@SuppressWarnings("unchecked")
		T front = (T) MyQueue[frontQueue];
		if (frontQueue >= backQueue) {
			frontQueue = -1;
			backQueue = -1;
		} else {
			
			frontQueue++;
			
		}
		capacity--;
		return front;
	}

	/**
	 * Number of elements in the Queue
	 * 
	 * @return the number of elements in the Queue
	 */
	@Override
	public int size() {
		return this.capacity;
	}

	/**
	 * Adds an element to the end of the Queue
	 * 
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful, false if not
	 */
	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		} else if (backQueue == -1) {
			frontQueue = backQueue = 0;
			this.MyQueue[backQueue] = e;
		} else if (backQueue + 1 < this.size) {
			this.MyQueue[++backQueue] = e;
		}
		capacity++;
		return true;
	}

	/**
	 * Returns the string representation of the elements in the Queue, the beginning
	 * of the string is the front of the queue
	 * 
	 * @return string representation of the Queue with elements
	 */

	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i <= backQueue; i++) {
			result += MyQueue[i];
		}
		return result;
	}

	/**
	 * Returns the string representation of the elements in the Queue, the beginning
	 * of the string is the front of the queue Place the delimiter between all
	 * elements of the Queue
	 * 
	 * @return string representation of the Queue with elements separated with the
	 *         delimiter
	 */
	@Override
	public String toString(String delimiter) {
		String result = "";
		for (int i = 0; i <= backQueue; i++) {
			result += MyQueue[i] + (i == backQueue ? "" : delimiter);
		}
		return result;

	}

	/**
	 * Fills the Queue with the elements of the ArrayList, First element in the
	 * ArrayList is the first element in the Queue
	 * 
	 * @param list elements to be added to the Queue
	 */
	@Override
	public void fill(ArrayList<T> list) {
		@SuppressWarnings("unchecked")
		ArrayList<T> copyArrayList = (ArrayList<T>)list.clone();
		capacity = 0;
		MyQueue = new Object[copyArrayList.size()];
		frontQueue =0;
		backQueue = -1;
		for (int i = 0; i < copyArrayList.size(); i++) {
			MyQueue[i] = copyArrayList.get(i);
			capacity++;backQueue++;
		}
		
	}

}
