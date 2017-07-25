import java.util.concurrent.locks.*;
import java.util.ArrayList;

/**
 * Bord klassen er leveringsstedet for telegrafistene og kryptografene.
 * Her setter telegrafistene meldingene sine slik at kryptografene kan 
 * ta dem til videre analyse. Kryptografene setter meldingene paa 
 * bordet etter kryptering for de gis til operasjonslederen.
 * 
 * @author Daniel James Tarplett
 *
 */
public class Bord{
	public int antallTraader, cnt = 0;
	public ArrayList<Melding> meldinger;
	public Melding melding;
	private Lock laas;
	private Condition tom;
	
	public Bord(int antallTraader){
		this.antallTraader = antallTraader;
		meldinger = new ArrayList<Melding>();
		melding = null;
		laas = new ReentrantLock();
		tom = laas.newCondition();
	}
	
	/**
	 * Metoden setter inn meldinger paa bordet som kan hentes av neste ledd.
	 * Meldingene blir lagret i meldingslisten paa bordet.
	 * Metoden laaser bordet mens den leverer med lock funksjonaliteten.
	 * @param melding meldingen som tas imot i listen
	 */
	void settInn(Melding melding){	
		laas.lock();
		try{
			if(melding == null){
				cnt++;
				System.out.println("Traad er ferdig");
			}
			else{
				meldinger.add(melding);
				System.out.println("Satt inn melding med sekvensnummer" + "   " + melding.sekvensNummer);
				tom.signal();
			}	
		}
		finally{
			laas.unlock();
		}
	}

	/**
	 * Metoden sender ut meldingen til neste ledd. Metoden sjekker
	 * om det en melding er tilstede. Dersom dette ikke stemmer sa
	 * venter den til en ny melding kommer. Dersom alle meldingene 
	 * er ferdige returneres null.
	 * @return Melding melding
	 */
	Melding hentUt() throws InterruptedException{
		laas.lock();
		//System.out.println("Traad forsoker a hente en melding...");
		try{
			while(meldinger.isEmpty() == true){	
				if(antallTraader == cnt) return null;
				tom.await();
				//System.out.println("Traad ble satt paa vent");
			}
			//System.out.println("Traad vaaknet");
			return  meldinger.remove(0);
		}
		finally{
			laas.unlock();			
		}
		
	}
}
