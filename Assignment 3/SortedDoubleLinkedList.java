import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {

	private Comparator<T> comparate;
	public SortedDoubleLinkedList(Comparator<T> comparator) {
		this.comparate = comparator;
	}
	public SortedDoubleLinkedList<T> add(T data){
		
		Node addNode = new Node(null,data,null);
		
		if (size == 0) {
			front=end =addNode;
		} else if (comparate.compare(front.data, data) > 0) {
			front.prev = addNode;
			addNode.next = front;
			front = addNode;
		} else if (comparate.compare(end.data, data) < 0) {
			end.next = addNode;
			addNode.prev = end;
			end = addNode;
		} else {
			Node pointer = front;
			while (pointer != null && pointer.next !=null ) {
				if (comparate.compare(pointer.data, data) <= 0) {
					Node temp = pointer.next;
					pointer.next.prev = pointer.next = addNode;
					addNode.next = temp;
					addNode.prev = pointer;
				}
				//Pointer moves to next node
				pointer = pointer.next;
			}
		}
		
        size++;
        return this;
		
	}
	public BasicDoubleLinkedList<T> addToEnd(T data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException("");
	}
	
	public BasicDoubleLinkedList<T> addToFront(T data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException("");
	}
	
	public ListIterator<T> iterator(){
		return super.iterator();
	}
	
	public SortedDoubleLinkedList<T> remove(T data, Comparator<T> comparator){
		return (SortedDoubleLinkedList<T>) super.remove(data, comparator);
	}
}
