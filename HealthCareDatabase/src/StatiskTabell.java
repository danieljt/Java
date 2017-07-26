import java.util.*;

/**
 * Klasse for implementering av en tabell/liste som beholder av vilkarlige
 * objecter T.
 * @author Daniel James Tarplett
 *
 * @param <T> Objektene som skal lagres i listen
 */
public class StatiskTabell<T> implements Tabell<T>, Iterable<T>{
	T[] tabell; 
	int teller = 0;
	
	/**
	 * Konstruktor dersom en storrelse pa tabellen skal oppgis
	 * @param storrelse storrelsen til tabellen
	 */
	public StatiskTabell(int storrelse){
		tabell = (T[]) new Object[storrelse];
	}
	
	/**
	 * Konstruktor dersom en storrelse pa tabellen ikke er oppgitt.
	 * Setter storrelsen til tabellen til å vare 100
	 */
	public StatiskTabell(){
		tabell = (T[]) new Object[100];
	}
	
	/**
	 * Gir ut storrelsen pa tabellen
	 * @return storrelsen pa tabellen
	 */
	public int storrelse(){
		return tabell.length;
	}
	
	/**
	 * Sjekker om listen er tom
	 * @return true hvis listen er tom, false hvis den ikke er det
	 */
	public boolean erTom(){
		if(tabell[0] == null){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Setter inn et element i tabellen. Dersom tabellen er
	 * full kastes FullTabellUnntak
	 * @param T elementet som skal settes inn
	 * @throws FullTabellUnntak dersom tabellen er full
	 */
	public void settInn(T objekt){
		if(teller > tabell.length-1){
			throw new FullTabellUnntak(tabell.length);
		}
		else{
			tabell[teller] = objekt;
			teller++;
		}
	}
	
	/**
	 * Henter et objekt fra en plass. Dersom plassen ikke
	 * inneholder noe objekt kastes et unntak
	 * @param plass plassen vi skal hente objektet fra
	 * @throws UgyldigPlassUnntak dersom en plass inneholder null
	 */
	public T hentFraPlass(int plass){		
		if(plass > tabell.length-1 || plass < 0){
			throw new UgyldigPlassUnntak(plass, tabell.length);
		}
		else if(tabell[plass] == null){
			throw new UgyldigPlassUnntak(plass, tabell.length);
		}
		else{
			return tabell[plass];
		}
	}
	
	/**
	 * Gir ut iteratoren til tabellen
	 * @return iterator<T> iteratoren til tabellen
	 */
	public Iterator<T> iterator(){
		return new ListeIterator();
	}
	
	/**
	 * Privat klasse for opprettelse av listeiterator.
	 * @author Daniel James Tarplett
	 */
	private class ListeIterator implements Iterator<T>{
		int iteratorteller = 0;
		T naverende = null;
		
		// Sjekker at neste element eksisterer. Dette er gitt ved telleren
		public boolean hasNext(){
			return(iteratorteller < teller);
		}
		
		/**
		 * Iterer til neste element. 
		 */
		public T next(){			
			naverende = tabell[iteratorteller];
			iteratorteller++;
			return naverende;
		}
		
		public void remove(){
			
		}
	}
}
