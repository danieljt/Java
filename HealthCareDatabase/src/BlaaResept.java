/**
 * Klasse for opprettelse av en blaa resept
 * @author Daniel James Tarplett
 *
 */
public class BlaaResept extends Resept{
	public BlaaResept(Legemiddel legemiddel, Lege lege, int pasientid, int reit){
		super(legemiddel, lege, pasientid, reit);
	}
	
	/**
	 * Gir ut fargen paa resepten
	 */
	public String farge(){
		return "blaa";
	}
	
	/**
	 * Gir ut prisen paa resepten
	 */
	public double prisAaBetale(){
		return legemiddel.hentPris()*0.25;
	}
}
