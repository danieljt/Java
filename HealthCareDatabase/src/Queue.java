/**
 * Class defines a queue, or a "first in first out" linkedlist. The
 * class inherits from it's superclass stack, and only overrides
 * the add method
 * @author Daniel James Tarplett
 *
 * @param <T> General object held by the list
 */
public class Queue<T> extends Stack<T> {
	public Queue(){
		super();
	}
	
	/**
	 * Adds an object to the list. The object is
	 * added behind the tail.
	 * 
	 * @param T Object added
	 */
	public void add(T object){
		Node newNode = new Node(object);
		
		if(tail != null){
			tail.nextNode = newNode;
			tail = newNode;
		}
		else{
			head = newNode;
			tail = newNode;
		}		
		size++;
		
	}
}
