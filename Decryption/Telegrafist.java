import krypto.Kanal;

/**
 * Telegrafist er en klasse som kan finne og lese meldinger fra en kanal. Telegrafisten
 * Sender meldinger til sitt aktuelle bord for videre analyse av kryptografer
 * @author Daniel James Tarplett
 *
 */
public class Telegrafist extends Thread{
	public int meldingsnr;
	public int ID;
	public String inkommende;
	public Kanal kanal;
	public Bord bord;
	
	/**
	 * Konstruktor for telegrafisten. Det tas in en kanal som denne
	 * telegrafisten kan lytte til.
	 * @param kanal kanalen til telegrafisten
	 * @param monitor
	 */
	public Telegrafist(int ID, Kanal kanal, Bord bord){
		meldingsnr = 0;
		this.ID = ID;
		inkommende = null;
		this.kanal = kanal;
		this.bord = bord;
	}
	
	public void run(){
		// Les neste melding helt til det ikke er flere igjen. Undrveis
		// sendes meldingene til bordet. Nar traaden er ferdig oker den
		// bordets ferdigetraader parameter			
		inkommende = kanal.lytt();
		while(inkommende != null){
			Melding melding = new Melding(meldingsnr, inkommende, ID);
			bord.settInn(melding);
			
			// Oppdater for neste avlytting
			meldingsnr++;
			inkommende = kanal.lytt();
		}
		
		// Setter inn null naar traaden er ferdig
		bord.settInn(null);
	}
}
