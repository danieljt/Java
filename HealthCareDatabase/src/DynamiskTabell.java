
public class DynamiskTabell<T> extends StatiskTabell<T>{
	
	public DynamiskTabell(int storrelse){
		super(storrelse);
	}
	
	public DynamiskTabell(){
		super();
	}
	
	/**
	 * Metode som setter inn et nytt objekt inn i tabellen. Metoden 
	 * overskriver metoden i statisk tabell ved at den dobler storelsen
	 * til tabellen dersom den blir full
	 * @param objekt objektet som settes inn i tabellen
	 */
	public void settInn(T objekt){
		
		// Lag ny tabell og kopier alle verdiene til denne tabellen
		// Overskriv sa den gamle tabellen med den nye
		if(teller > tabell.length-1){
			T[] nytabell = (T[]) new Object[tabell.length*2];
			for(int i=0; i<tabell.length; i++){
				nytabell[i] = tabell[i];
			}
			for(int i=0; i < nytabell.length; i++){
				System.out.println(nytabell[i]);
			}
			tabell = nytabell;
		}
		
		tabell[teller] = objekt;
		teller++;
	}
}
