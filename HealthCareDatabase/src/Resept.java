/**
 * Klasse for opprettelse av en resept. Klassen er abstrakt ettersom en 
 * resept ma vare hvit eller blaa
 * @author Daniel James Tarplett
 *
 */
public abstract class Resept{
	public int ID;
	public Legemiddel legemiddel;
	public Lege lege;
	public int pasientid;
	public int reit;
	
	/**
	 * konstruktor for klassen resept
	 * @param legemiddel Legemiddelet som det er resept pa
	 * @param lege Legen som skriver ut
	 * @param pasientid den unike ID-en til pasienten
	 * @param reit antall ganger resepten kan brukes ved utskrift
	 */
	public Resept(Legemiddel legemiddel, Lege lege, int pasientid, int reit){
		this.legemiddel = legemiddel;
		this.lege = lege;
		this.pasientid = pasientid;
		this.reit = reit;
	}
	
	/**
	 * Hent ID-en til resepten
	 * @return ID-en
	 */
	public int hentId(){
		return ID;
	}
	
	/**
	 * Hent legemiddelet i resepten
	 * @return legemiddelet
	 */
	public Legemiddel hentLegemiddel(){
		return legemiddel;
	}
	
	/**
	 * Hent legen som har skrevet ut resepten
	 * @return legen
	 */
	public Lege hentLege(){
		return lege;
	}
	
	/**
	 * Hent pasientID-en
	 * @return pasient ID-en
	 */
	public int hentPasientId(){
		return pasientid;
	}
	
	/**
	 * Hent antall ganger resepten kan brukes
	 * @return antall ganger resepten kan brukes
	 */
	public int hentReit(){
		return reit;
	}
	
	/**
	 * Bruk resepten
	 * @return true hvis resepten kan brukes, false hvis ikke
	 */
	public boolean bruk(){
		if(reit > 0){
			reit--;
			return true;
		}
		return false;
	}
	
	/**
	 * Skriver ut resepten i string format
	 */
	public String toString(){
		return legemiddel.toString() + " " + pasientid + " " + lege.toString() + " " + reit;
	}
	/**
	 * Gir fargen til resepten
	 * @return
	 */
	abstract public String farge();
	
	/**
	 * Gir prisen pa resepten
	 * @return prisen
	 */
	abstract public double prisAaBetale(); 
}
