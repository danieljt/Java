/**
 * Class defines an alphabetical list where objects are listed
 * from smallest to largest via the compareTo method.
 * 
 * @author Daniel James Tarplett
 *
 * @param <T> Object to be added. Must extend comparable<T>
 */
public class AlphabeticalList<T extends Comparable<T>> extends Stack<T> {
	public AlphabeticalList(){
		super();
	}
	
	/**
	 * Adds an element to the list
	 * @param T objectadded 
	 */
	public void add(T object){
		Node newNode = new Node(object);
		
		// If the list is empty 
		if(head == null){
			head = newNode;
			size++;
			return;
		}
		
		// If object has lower value than the head
		if(object.compareTo(head.object) < 0){
			newNode.nextNode = head;
			head = newNode;
			size++;
			return;
			
		}
		
		// All other outcomes. Use currentNode as dummy for
		// iterating the list
		Node currentNode = head;
		while(currentNode.nextNode != null){
			
			// If object is larger than the next node
			if(object.compareTo(currentNode.nextNode.object) > 0){
				currentNode = currentNode.nextNode;
			}
			
			
			else{
				newNode.nextNode = currentNode.nextNode;
			    currentNode.nextNode = newNode;
			    size++;
			    return;
			}
			
		}
		// Object is larger than all elements in list.
		// Add to the end of the list.
		currentNode.nextNode = newNode;
		size++;	
	}
}
