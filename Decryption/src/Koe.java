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
		ny.neste = null;
		hale = ny;
	    }
	    
	    // Hvis listen er tom
	    else{
		hale = ny;
		hode = ny;
		ny.neste = null;
	    }
	    
	    antall++;
	}
	
	/**
	 * Returnerer og fjerner forste element i lista. Er listen tom 
	 * returnerer metoden null
	 */
	public T fjern(){
		// Listen er tom
		if(erTom() == true){
			return null;
		}
		
		Node forste = hode;
		hode = hode.neste;
		antall--;
		return forste.objekt;
	}

}
