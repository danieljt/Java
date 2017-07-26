/**
 * Klasse for opprettelse av en lege
 * @author Daniel James Tarplett
 *
 */
public class Lege implements Comparable<Lege>{
	protected int ID;
	protected String navn;
	protected Koe<Resept> reseptliste;
	
	/**
	 * Konstruktor for klassen lege 
	 * @param navn Navnet pa legen
	 */
	public Lege(String navn){
		this.navn = navn;
		reseptliste = new Koe<Resept>();
	}
	
	/**
	 * Tar legens navn og sammenligner med en annen leges navn.
	 * Gir tilbake en tallverdi som sier hvilken som er storst
	 */
	public int compareTo(Lege lege){
		return hentNavn().compareTo(lege.hentNavn());
	}
	
	/**
	 * Hent navnet til legen
	 * @return navnet
	 */
	public String hentNavn(){
		return navn;
	}
	
	/**
	 * Legger til resept i legens reseptliste
	 * @param resept ny resept
	 */
	public void leggTilResept(Resept resept){
		reseptliste.settInn(resept);
	}
	
	/**
	 * Hent reseptlisten til legen
	 * @return reseptlisten
	 */
	public Koe<Resept> hentReseptliste(){
		return reseptliste;
	}
	
	public String toString(){
		return navn;
	}
}
