import krypto.*;

/**
 * Hovedprogrammet oppretter en operasonssentral som utforer dekryptering
 * av meldinger. Det opprettes telegrafister som lytter til kanaler og legger
 * meldingene paa et bord. Kryptografene henter saa meldingene og dekrypterer dem
 * for de leveres til et nytt bord. Her samler operasjonlederene dem og organiserer 
 * dem for han skriver dem til fil
 * 
 * @author Daniel James Tarplett
 *
 */
public class Main {
	
	public static void main(String[] args) throws InterruptedException{
		
		// Bestem antall telegrafister og kryptografer 
		int antallTelegrafister = 2;
		int antallKryptografer = 12;
		
		// Opprett operasjonssentralen og kanalene
		Operasjonssentral ops = new Operasjonssentral(antallTelegrafister);
		Kanal[] kanaler = ops.hentKanalArray();
		
		// Opprett bordene
		Bord telegrafistBord = new Bord(antallTelegrafister);
		Bord kryptografBord = new Bord(antallKryptografer);		
		Telegrafist[] telegrafister = new Telegrafist[antallTelegrafister];
		Kryptograf[] kryptografer = new Kryptograf[antallKryptografer];
		
		// Sett i gang telegrafister
		for(int i=0; i<antallTelegrafister; i++){
			telegrafister[i] = new Telegrafist(i, kanaler[i], telegrafistBord);
			telegrafister[i].start();
		}
		
		// Sett i gang kryptografene		
		for(int i=0;i<antallKryptografer; i++){
			kryptografer[i] = new Kryptograf(telegrafistBord, kryptografBord);
			kryptografer[i].start();
		}
		
		// Sett i gang operasjonslederen
		Operasjonsleder operasjonsleder = new Operasjonsleder(kryptografBord, kanaler);
		operasjonsleder.start();
		
		// Vent til operasjonslederen er ferdig for programmet fortsetter
		operasjonsleder.join();
		
		//kryptografBord.skrivUt();
		System.out.println("Programmet er ferdig");
	}
}
