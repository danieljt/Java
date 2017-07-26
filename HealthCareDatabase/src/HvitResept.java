/**
 * Klasse for opprettelse av en hvi resept
 * @author Daniel James Tarplett
 *
 */
public class HvitResept extends Resept{
	public HvitResept(Legemiddel legemiddel, Lege lege, int pasientid, int reit){
		super(legemiddel, lege, pasientid, reit);
	}
	
	/**
	 * Gir ut fargen paa resepten
	 */
	public String farge(){
		return "hvit";
	}
	
	/**
	 * Gir ut prisen paa resepten
	 */
	public double prisAaBetale(){
		return legemiddel.hentPris();
	}
}
