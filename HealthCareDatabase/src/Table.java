/**
 * The interface defines important functions for a table
 * @author Daniel James Tarplett
 *
 * @param <T> Objects contained in the list
 */
public interface Table<T> extends Iterable<T> {
	
	/**
	 * Gets the size of the table
	 * @return size of the table
	 */
	public int size();
	
	/**
	 * Method returns true if the list is empty, false if it is not
	 * @return boolean
	 */
	public boolean isEmpty();
	
	/**
	 * Method adds an object to the table
	 * @param object
	 */
	public void add(T object);
	
	/**
	 * Method gets an object from the table, returns null if
	 * there are no objects 
	 * @param index The index of the table
	 * @return The object
	 */
	public T get(int index);
	

}

