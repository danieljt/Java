/**
 * Interface defines the important functions for a Linked list 
 * @author Daniel James Tarplett
 *
 * @param <T> General object, T must be iterable
 */
public interface List<T> extends Iterable<T>{
	/**
	 * Method gets the size of the list
	 * @return size of the list
	 */
	public int size();
	
	/**
	 * Method returns true if the list is empty, false if not
	 * @return boolean
	 */
	public boolean isEmpty();
	
	/**
	 * Method adds an object to the list
	 * @param object to be put in the list
	 */
	public void add(T object);
	
	/**
	 * Method removes an object from the list
	 * @return object thatwas removed
	 */
	public T remove();
}
