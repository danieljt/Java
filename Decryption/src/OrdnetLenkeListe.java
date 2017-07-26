/**
 * Klassen implementerer en ordnet lenkeliste. Denne klassen er
 * en subklasse av superklassen Stabel, og er implementert slik at
 * det minste elementet i forhold til CompareTo metoden kommer
 * forst ut.
 * @author Daniel James Tarplett
 *
 * @param <T> objektene som er inneholdt i listen
 */
public class OrdnetLenkeListe<T extends Comparable<T>> extends Stabel<T>{
	
	// Etablerer tom liste med nodene arvet fra Stabel
	public OrdnetLenkeListe(){
		super();
	}
	
	/**
	 * Setter inn elementer i alfabetisk rekkefolge inn i lenkelista
	 * @param element objektet som settes inn
	 */
	@Override
	public void settInn(T element){
		Node ny = new Node(element);
		
		//1. ingenting
		if(hode == null)
	      {
		hode = ny;
		antall++;
		return;
	      }
		
		//2. har bare hode 
		if(element.compareTo(hode.objekt) < 0){
			ny.neste = hode;
		    hode = ny;
		    antall++;
		    return;
		}		
		
		// 3. rst
		Node denne = hode;
		//sålenge ikkkferdig, hvis  ny > denne.neset , gåtil neste
		//ikke = imellomm og ret
		while(denne.neste != null){
			if(element.compareTo(denne.neste.objekt) > 0) denne = denne.neste;
			else{
				ny.neste = denne.neste;
			    denne.neste = ny;
			    antall++;
			    return;
			}
		}
		denne.neste = ny;
		antall++;
		
		
		
	}
}
