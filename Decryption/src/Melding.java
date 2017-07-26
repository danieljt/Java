
/**
 * Klasse for opprettelse av en melding
 * @author Daniel James Tarplett
 *
 */
public class Melding implements Comparable<Melding>{
	public int sekvensNummer;
	public String melding;
	public int ID;
	
	public Melding(int sekvensNummer, String melding, int ID){
		this.sekvensNummer = sekvensNummer;
		this.melding = melding;
		this.ID = ID;
	}
	
	/**
	 * Metoden sammenligner denne meldingen med en annen melding
	 * for aa se hvilken som har storst/minst sekvensnummer
	 * @return 0 om de er like, 1 hvis denne er storre og -1 hvis den er mindre
	 */
	@Override
	public int compareTo(Melding melding){
		if(sekvensNummer > melding.sekvensNummer){
			return 1;
		}
		else if(sekvensNummer < melding.sekvensNummer){
			return -1;
		}
		else{
			return 0;
		}
	}
}
