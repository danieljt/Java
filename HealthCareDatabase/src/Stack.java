import java.util.Iterator;

/**
 * The Stack class implements a linked list as a stack, giving the
 * the Last in, first out principle. The class defines nodes holding
 * objects defined in an internal private class Node.
 * 
 * @author Daniel James Tarplett
 *
 * @param <T> General object held in the class
 */
public class Stack<T> implements List<T> {
	
	protected Node head;
	protected Node tail;
	protected int size;
	
	public Stack(){
		head = null;
		tail = null;
		size = 0;
	}
	
	public int size(){
		return size;
	}
	
	/**
	 * Method checks if the list is empty. Returns true
	 * if it is, false if it is not
	 * @return boolean
	 */
	public boolean isEmpty(){
		if(head == null){
			return true;
		}
		return false;
	}
	
	/**
	 * Adds an object to the list. The object is added in front of the
	 * head, and the list then updates the newnode as the head. In the 
	 * first insert, the tail is gets the first object so a definition
	 * of the last object is made.
	 */
	public void add(T object){
		Node newNode = new Node(object);
		newNode.nextNode = head;
		head = newNode;
		
		// If the first object is added, add a tail value as well
		if(tail == null){
			tail = newNode;
		}
		size++;
	}
	
	/**
	 * Method removes the last object that was added to the list
	 * @return Last object that was added to the list 
	 */
	public T remove(){
		Node out = head;
		
		// No objects in list
		if(head == null){
			return null;
		}
		
		// Only one object left. Both head and
		// tail are set to null
		if(head.nextNode == null){
			out = head;
			head = null;
			tail = null;
			size--;
			return out.object;
		}
		// All other 
		head = head.nextNode;
		size--;
		return out.object;
	}
	
	/**
	 * Returns the iterator for the list
	 * @return Iterator<T>
	 */
	public Iterator<T> iterator(){
		return new ListIterator();
	}
	
	protected class Node{
		T object;
		Node nextNode;
		
		Node(T object){
			this.object = object;
			nextNode = null;
		}
	}
	
	/**
	 * Private internal class for providing the list iterator
	 * interface.
	 * @author Daniel James Tarplett
	 *
	 */
	private class ListIterator implements Iterator<T>{
		int counter = 0;
		Node nextNode = head;
		
		/**
		 * Checks if the list has a new element after
		 * the current one
		 * @return true if a new element exists, false if not
		 */
		public boolean hasNext(){
			return (counter < size);
		}
		
		/**
		 * Iterates to the next element
		 */
		public T next(){
			T nextObject = nextNode.object;
			counter++;
			nextNode = nextNode.nextNode;
			return nextObject;
		}
		
		public void remove(){
			
		}
	}
}
