/**
 * Klasse for opprettelse av en fastlege. Fastlege arver fra 
 * superklassen Lege og implementerer grensesnittet Kommuneavtale
 * @author Daniel James Tarplett
 *
 */
public class Fastlege extends Lege implements Kommuneavtale{
	public int avtalenr;
	
	public Fastlege(String navn, int avtalenr){
		super(navn);
		this.avtalenr = avtalenr;
	}
	
	/**
	 * Hent avtalenummeret til fastlegen
	 * @return avtalenummeret
	 */
	public int hentAvtalenummer(){
		return avtalenr;
	}
}
