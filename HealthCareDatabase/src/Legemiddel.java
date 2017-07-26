/**
 * Klasse for opprettelse av et legemiddel
 * @author Daniel James Tarplett
 *
 */
public class Legemiddel {
	public int ID;
	public String navn;
	public double pris;
	public double virkestoff;
	
	/**
	 * Konstruktor for legemiddelet
	 * @param navn navnet pa legemiddelet
	 * @param pris prisen pa legemiddelet
	 * @param virkestoff antall mg virkestoff i legemiddelet
	 */
	public Legemiddel(String navn, double pris, double virkestoff){
		this.navn = navn;
		this.pris = pris;
		this.virkestoff = virkestoff;
	}
	
	/**
	 * Hent ID-en til legemiddelet
	 * @return ID-en
	 */
	public int hentId(){
		return ID;
	}
	
	/**
	 * Hent navnet til legemiddelet
	 * @return navnet
	 */
	public String hentNavn(){
		return navn;
	}
	
	/**
	 * Hent prisen paa legemiddelet
	 * @return prisen
	 */
	public double hentPris(){
		return pris;
	}
	
	/**
	 * Henter virkestoffet i legemiddelet
	 * @return virkestoff
	 */
	public double hentVirkestoff(){
		return virkestoff;
	}
	
	/**
	 * Skriver ut streng verdi av legemiddelet
	 */
	public String toString(){
		return navn;
	}
}
