import java.util.Iterator;

/**
 * Class defines a static table of a given length. Once the length
 * is specified, it cannot be changed. If no length is specified,
 * the table will get a length of 100.
 * @author Daniel James Tarplett
 *
 * @param <T>
 */
public class StaticTable<T> implements Table<T>, Iterable<T>{
	public T[] table;
	int counter = 0;
	
	public StaticTable(int size){
		table = (T[]) new Object[size];
	}
	
	public StaticTable(){
		table = (T[]) new Object[100];
	}
	
	/**
	 * Returns the size of the table
	 * @return size
	 */
	public int size(){
		return table.length;
	}
	
	/**
	 * Checks if the list is empty. Returns true if the list
	 * is empty, false if it is not.
	 * @return true if empty, false if not
	 */
	public boolean isEmpty(){
		if(table[0] == null){
			return true;
		}
		return false;
	}
	
	/**
	 * Adds an object to the next space in the list. If the 
	 * list is full, an exception is thrown
	 * @param T object added to list
	 * @throws FullTableException if table is full
	 */
	public void add(T object){
		if(counter > table.length-1){
			throw new FullTableException(table.length);
		}
		else{
			table[counter] = object;
			counter++;
		}
	}
	
	/**
	 * Gets an object from the list. if the index is invalid, or the 
	 * space in the table has no object, an exception is thrown.
	 * @param index index of the object in list
	 * @return object in the specified place in the list
	 * @throws IllegalSpaceException if index is out of bounds or no object is found
	 */
	public T get(int index){
		if(index > table.length-1 || index < 0){
			throw new IllegalSpaceException(index, table.length);
		}
		else if(table[index] == null){
			throw new IllegalSpaceException(index, table.length);
		}
		else{
			return table[index];
		}
	}
	
	/*'
	 * (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	public Iterator<T> iterator(){
		return new ListIterator();
	}
	
	/**
	 * Private class for creating an iterator class for the table
	 * @author Daniel James Tarplett
	 *
	 */
	private class ListIterator implements Iterator<T>{
		int listCounter = 0;
		T currentObject = null;
		
		/**
		 * Checks if the list has another element than the current one
		 * @return true if list has a next element, false if not 
		 */
		public boolean hasNext(){
			return(listCounter < counter);
		}
		
		/**
		 * Iterates to the next element 
		 */
		public T next(){			
			currentObject = table[listCounter];
			listCounter++;
			return currentObject;
		}
		
		public void remove(){
			
		}
	}
}
