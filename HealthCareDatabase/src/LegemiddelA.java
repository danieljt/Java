/**
 * Klasse for opprettelse av et narkotiskt legemiddel
 * @author Daniel James Tarplett
 *
 */
public class LegemiddelA extends Legemiddel{
	public int styrke;
	
	public LegemiddelA(String navn, double pris, double virkestoff, int styrke){
		super(navn, pris, virkestoff);
		this.styrke = styrke;
	}
	
	/**
	 * Hent narkotisk styrke i legemiddelet
	 * @return narkotisk styrke
	 */
	public int hentNarkotiskStyrke(){
		return styrke;
	}
}
