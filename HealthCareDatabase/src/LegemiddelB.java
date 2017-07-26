/**
 * Klasse for opprettelse av et vanedannende legemiddel
 * @author Daniel James Tarplett
 *
 */
public class LegemiddelB extends Legemiddel{
	public int styrke;
	
	public LegemiddelB(String navn, double pris, double virkestoff, int styrke){
		super(navn, pris, virkestoff);
		this.styrke = styrke;
	}
	
	/**
	 * Henter styrken til legemiddelet
	 * @return
	 */
	public int hentVanedannendeStyrke(){
		return styrke;
	}
}
