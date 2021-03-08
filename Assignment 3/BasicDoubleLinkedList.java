import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> implements Iterable<T>{
	
	public Node front,end;
	public int size;
	public BasicDoubleLinkedList() {
		this.size=0;
	}
	
	
	public BasicDoubleLinkedList<T> addToEnd(T data){
		Node AddingNode = new Node(end,data,null);
		
		if(front==null)
			front = AddingNode;
		else if(end != null) 
			end.next =AddingNode; 
			
		end = AddingNode;
		size++;
		return this;	
	}
	
	
	public BasicDoubleLinkedList<T> addToFront(T data){	
		
		Node AddingNode = new Node(null,data,front);
		
		if(end == null) {
			end =AddingNode; 
		}
		else if(front != null)
			front.prev = AddingNode;
		
		front = AddingNode;
		size++;
		/*
		if(front==null|| end ==null) {
			front = new Node(null,data,front);
			end = new Node(null,data,front); 
		}
		else {
			Node AddingNode = new Node(null,data,front);
			front.prev = AddingNode;
			front = AddingNode;
		}
		size++;
		return null;*/
		return this;
	}
	
	public T getFirst() {
		return front.data;
	}
	
	public T getLast() {
		return end.data;	
	}
	
	public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException{
		LinkedListIterator listIterator = new LinkedListIterator();
		return listIterator;
	}
	
	public BasicDoubleLinkedList<T>remove(T targetData, Comparator<T> comparator) {
		Node deleteNode = front;
		while(deleteNode != null) {
			if(comparator.compare(targetData, deleteNode.data)==0) {
				if(deleteNode == end)
					end = end.prev;
				else if(deleteNode == front)
					front = front.next;
				else
					deleteNode.prev.next = deleteNode.next;
				
			}
			deleteNode = deleteNode.next;
		}
		size--;
		return this;
		
	}
	
	public T retrieveFirstElement() {
		
		
		Node deleteNode = front;
		if(front == null|| front.next == null) {
			front = null;
			size--;
			return null;
		}
		front = front.next;
		front.prev = null;
		size--;
		return(T)deleteNode.data;
		
			
	}
	public T retrieveLastElement() { 
		
		
		
		Node deleteNode = end;
		if(end.next == null && end.prev != null) {
			end = deleteNode.prev;
			end.next= null;
			size--;
			return (T) deleteNode.data;
		}
		
		/*else if(end ==null || (end.next == null && front.prev == null)) {
			end =null;
			size--;
			return null;
		}*/
		
		
		
		
		
		
		return null;
		
	}
	public ArrayList<T> toArrayList(){
		ArrayList<T> listValues = new ArrayList<T>();
		ListIterator<T> iterator = new LinkedListIterator();
		while(iterator.hasNext()) {
			listValues.add(iterator.next());
		}
		return listValues;
		
	}
	public int getSize() {
		return size;
	}
	
	
	/*
	 * Inner Node
	 */
		
	public class Node {
		public T data;
		public Node prev;
		public Node next;
		
		public Node(T data) {
			this.data = data;
		}
		
		public Node( Node prev,T data,Node next) {
			this.data = data;
			this.next = next;
			this.prev=prev;
		}
	}
	
	/*
	 * Inner class Iterator
	 */
	
	private class LinkedListIterator implements ListIterator<T>{
		Node iterator = new Node(null,null, front);
		@Override
		public void add(T arg0) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
			
		}

		@Override
		public boolean hasNext() {
			return iterator.next != null;
		}

		@Override
		public boolean hasPrevious() {
			return iterator.prev != null;
		}

		@Override
		public T next() {
			if(!hasNext())
				throw new NoSuchElementException();
				
			iterator.prev = iterator.next;
			iterator.next = iterator.prev.next;
			return iterator.prev.data;
		}

		@Override
		public int nextIndex()  throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
			
		}

		@Override
		public T previous() {
			if(!hasPrevious())
				throw new NoSuchElementException();
			iterator.next = iterator.prev;
			iterator.prev = iterator.next.prev;
			return iterator.next.data;
		}

		@Override
		public int previousIndex()  throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
			
		}
		@Override
		public void remove()  throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
			
		}

		@Override
		public void set(T arg0)  throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
			
		}
		
	}
	
	
}
