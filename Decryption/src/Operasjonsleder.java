import krypto.Kanal;
import java.io.PrintWriter;
import java.io.File;

/**
 * Klassen oppretter en operasjonsleder. Operasjonslederen har som 
 * oppgave aa ta imot og sortere krypterte meldinger i stigende rekkefolge
 * saa skrive dem ut til hver sin fil.
 * @author Daniel James Tarplett
 *
 */
public class Operasjonsleder extends Thread{
	public Bord bord;
	public Kanal[] kanaler;
	public Melding melding;
	public OrdnetLenkeListe<Melding> liste;
	public PrintWriter[] printer;
	
	public Operasjonsleder(Bord bord, Kanal[] kanaler){
		this.bord = bord;
		this.kanaler = kanaler;
		liste = new OrdnetLenkeListe<Melding>();
		printer = new PrintWriter[kanaler.length];
	}
	
	@Override
	public void run(){
		try{
			melding = bord.hentUt();
			while(melding != null){
				
				liste.settInn(melding);
				System.out.println("Operasjonsleder hentet en melding med sekvensnummer" + "  " + melding.sekvensNummer);
				melding = bord.hentUt();
			}
			try{
				skrivTilFil();
			}
			catch(Exception e){}
		}		
		catch(InterruptedException e){}
	}
	
	/**
	 * Skriver meldinger til filer
	 */
	public void skrivTilFil() throws Exception{
		
		// Oppretter skriverene
		for(int i=0; i<kanaler.length; i++){
			printer[i] = new PrintWriter(new File("kanal" + i + ".txt"), "utf-8");
		}
		
		// Skriver tekstene til filene
		for(Melding melding : liste){
			printer[melding.ID].println(melding.melding);
			printer[melding.ID].println();
			printer[melding.ID].println();
		}
		
		// Avslutt printWritere
		for(PrintWriter p : printer){
			p.close();
		}
	}
}
