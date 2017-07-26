/**
 * Klassen oppretter en koe, eller en FIFO(First Inn First Out) liste.
 * Denne klassen er en subklasse av superklassen stabel.
 * 
 * @author Daniel James Tarplett
 *
 * @param <T>
 */
public class Koe<T> extends Stabel<T>{
	
	public Koe(){
		super();
	}
	
	/**
	* Setter inn et element i listen. Metoden gjor slik at
	* de forste elementene som legges inn kommer forst i lista.
	* Denne metoden overstyrer settInn metoden i stabel
	* @param element elementet som settes inn
	*/
	public void settInn(T element){
	    Node ny = new Node(element);
	    if(hale != null){
		hale.neste = ny;
		hale = ny;
	    }
	    
	    // Hvis listen er tom
	    else{
		hode = ny;
		hale = ny;
	    }
	    
	    antall++;
	}

}
