
public class DynamicTable<T> extends StaticTable<T> {
	
	public DynamicTable(int size){
		super(size);
	}
	
	public DynamicTable(){
		super();
	}
	
	/**
	 * Method adds an object T to the table. If the table is full, a new table
	 * with double the size is created and overwrites the old one. The object is
	 * then added.
	 */
	public void add(T object){
		// Create new table of double length and add elements to new table
		if(counter > table.length-1){
			T[] newtable = (T[]) new Object[table.length*2];
			for(int i=0; i<table.length; i++){
				newtable[i] = table[i];
			}
			// Overwrite old table
			table = newtable;
		}
		
		// Add object to next space in the table
		table[counter] = object;
		counter++;
	}
}
