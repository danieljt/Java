/**
 * Klasse for opprettelse av en pasient
 * @author Daniel James Tarplett
 *
 */
public class Pasient {
	private int ID;
	private long fodselsnr;
	private String navn;
	private String adresse;
	private int postnr;
	private Stabel<Resept> reseptliste;
	
	/**
	 * Konstruktor for pasient klassen 
	 * @param navn Navnet pa pasienten
	 * @param fodselsnr fodselsnummeret til pasienten
	 * @param adresse Adressen til pasienten
	 * @param postnr postnummeret til pasienten
	 */
	public Pasient(String navn, long fodselsnr, String adresse, int postnr){
		 this.fodselsnr = fodselsnr;
		 this.navn = navn;
		 this.adresse = adresse;
		 this.postnr = postnr;
		 reseptliste = new Stabel<Resept>();
	}
	
	/**
	 * Hent pasientens unike id
	 * @return ID
	 */
	public int hentId(){
		return ID;
	}
	
	/**
	 * Hent pasientens navn
	 * @return Navnet
	 */
	public String hentNavn(){
		return navn; 
	}
	
	/**
	 * Hent pasientens fodselsnummer
	 * @return fodselsnummeret
	 */
	public long hentFodselsnummer(){
		return fodselsnr;
	}
	
	/**
	 * Hent pasientens gateadresse
	 * @return adressen
	 */
	public String hentGateadresse(){
		return adresse;
	}
	
	/**
	 * Hent pasientens postnummer
	 * @return postnummeret
	 */
	public int hentPostnummer(){
		return postnr;
	}
	
	/**
	 * Legg til resept til pasientens reseptliste
	 * @param resept
	 */
	public void leggTilResept(Resept resept){
		reseptliste.settInn(resept);
	}
	
	/**
	 * Hent pasientens reseptliste
	 * @return reseptlista
	 */
	public Stabel<Resept> hentReseptliste(){
		return reseptliste;
	}
	
	public String toString(){
		return navn;
		
	}
}
