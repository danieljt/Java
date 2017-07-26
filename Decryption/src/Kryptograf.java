import krypto.Kryptografi;

/**
 * Klassen oppretter en kryptograf som dekrypterer meldinger
 * for de leveres til operasjonslederene. kryptografer
 * er produsenter og konsumenter siden de baade tar til seg
 * meldinger fra monitoren og sender meldinger til 
 * neste monitor. 
 * 
 * @author Daniel James Tarplett
 *
 */
public class Kryptograf extends Thread{
	public Bord telegrafistBord;
	public Bord kryptografBord;
	public Melding melding;
	
	public Kryptograf(Bord telegrafistBord, Bord kryptografBord){
		this.telegrafistBord = telegrafistBord;
		this.kryptografBord = kryptografBord;	
	}
	
	@Override
	public void run(){ 
		// Hent meldingene fra telegrafistbordet og dekrypter dem. Send
		// dem saa videre til neste bord. Avsluttes naar en melding naar
		// det tas i mot null.
		try{
			melding = telegrafistBord.hentUt();
			while(melding != null){
				System.out.println("Traad dekrypterer melding");
				melding.melding = Kryptografi.dekrypter(melding.melding);
				System.out.println("Traad dekrypterte en melding med sekvensnummer " + melding.sekvensNummer);
				kryptografBord.settInn(melding);
				melding = telegrafistBord.hentUt();
			}
			kryptografBord.settInn(null);
		}
		catch(InterruptedException e){}
	}
}
