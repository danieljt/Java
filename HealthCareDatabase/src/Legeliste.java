/**
 * Klasse for opprettelse av en legeliste. Listen arver fra superklassen
 * OrdnetLenkeListe med lege som parameter
 * @author Daniel James Tarplett
 *
 */
public class Legeliste extends OrdnetLenkeListe<Lege>{
	
	/**
	 * soker gjennom listen etter lege ved hjelp av navnet
	 * @param navn navnet som skal sokes etter
	 * @return Lege objekt dersom legen fins, hvis ikke null.
	 */
	public Lege finnLege(String navn){
		Lege testLege = new Lege(navn);
		Node denne = hode;
		
		while(denne != null){
			if(denne.objekt.compareTo(testLege) == 0){
				return denne.objekt;
			}
		}
		return null;
	}
	
	/**
	 * Gir ut en array med navnet til alle legene i listen
	 * @return array med alle navnene i listen
	 */
	public String[] stringArrayMedNavn(){
		String[] legeliste = new String[antall];
		Node denne = hode;
		int teller = 0;
		while(denne != null){
			legeliste[teller] = denne.objekt.hentNavn();
			denne = denne.neste;
			teller++;
		}
		return legeliste;
	}
	
}
