import java.io.File;
import java.util.Scanner;

public class Labyrint {
	protected Rute[][] ruter;
	protected int kolonner;
	protected int rader;
	protected Koe<String> utveier;
	public boolean debug = true;
	
	private Labyrint(int rader, int kolonner, Rute[][] ruter){
		this.rader = rader;
		this.kolonner = kolonner;
		this.ruter = ruter;
		utveier = new Koe<String>();
	}
	
	/**
	 * Static factory metode for labyrint. Metoden leser labyrinten fra fil der filen
	 * inneholder "#" for vegger og "." for aapne pasasjer. Dersom en aapen passasje
	 * er paa veggen til en labyrint, sa blir dette en aapning til labyrinten 
	 * 
	 * @param filnavn filnavnet pa filen som leses med fil indikator
	 * @return nytt labyrint objekt
	 * @throws Exception Dersom lesing av fil mislykkes
	 */
	public static Labyrint lesFraFil(File fil) throws Exception{
		Scanner leser = new Scanner(fil);
		
		// Leser forste linje i filen
		String linje = leser.nextLine();
		String[] ord = linje.split(" ");
		
		// Sett rad, kolonne og rute arrayet
		int rad = Integer.parseInt(ord[0]);
		int kolonne = Integer.parseInt(ord[1]);
		Rute[][] ruter = new Rute[rad][kolonne];
		
		// Les filen linje for linje og sett i rutene i rute arrayet
		int linjenr = 0;
		while(leser.hasNextLine()){
			linje = leser.nextLine();
			for(int i=0;i<linje.length(); i++){
				String tegn = Character.toString(linje.charAt(i));

				// Les in sort rute
				if(tegn.equalsIgnoreCase("#")){
					ruter[linjenr][i] = new SortRute(linjenr, i);
				}
				
				// Les inn hvit rute. Sjekk om den hvite ruten er paa kanten av
				// labyrinten. Dersom dette er sant, lag en aapning
				else if(tegn.equalsIgnoreCase(".")){
					if(i == 0 || i == kolonne-1){
					    ruter[linjenr][i] = new Aapning(linjenr, i);
					}
					else if(linjenr == 0 || linjenr == rad-1){
					    ruter[linjenr][i] = new Aapning(linjenr, i);
					}
					else{
					    ruter[linjenr][i] = new HvitRute(linjenr, i);
					}
				}				
			}
			linjenr++;
		}
		leser.close();
		
		// Oppretter labyrinten
		Labyrint labyrint = new Labyrint(rad, kolonne, ruter);	
		
		// Oppretter referanser til labyrinten i rutene og 
		// referanser til naborutene
		for(int i=0; i < labyrint.rader; i++){
			for(int j=0; j < labyrint.kolonner; j++){
				ruter[i][j].labyrint = labyrint;
				
				// Sjekker nordlig naborute
				if(i-1 < 0){
					ruter[i][j].nord = null;					
				}
				else{
					ruter[i][j].nord = ruter[i-1][j];
				}
				
				// Sjekker sydlig naborute
				if(i+1 > rad-1){
					ruter[i][j].syd = null;
				}
				else{
					ruter[i][j].syd = ruter[i+1][j];
				}
				
				// Sjekker vestlig naborute
				if(j-1 < 0){
					ruter[i][j].vest = null;
				}
				else{
					ruter[i][j].vest = ruter[i][j-1];
				}
				
				// Sjekker ostlig naborute
				if(j+1 > kolonne-1){
					ruter[i][j].ost = null;
				}
				else{
					ruter[i][j].ost  = ruter[i][j+1];
				}
			}
		}
		
		return labyrint;
	}
	
	public Liste<String> finnUtveiFra(int rad, int kolonne){
	    utveier = new Koe<String>();
	    ruter[rad][kolonne].finnUtvei();
	    return utveier;
	}
	
	/**
	 * Skriver ut labyrinten i string format
	 */
	public String toString(){
		String labyrint = "";
		for(int i=0; i<rader; i++){
			for(int j=0; j<kolonner; j++){
				labyrint += ruter[i][j].tilTegn();
			}
			labyrint += "\n";
		}
		return labyrint;
	}
	
	public void settMinimalUtskrift(){
		debug = false;
	}
	
	/**
	 * Test metode som sjekker at lesFil metoden har lest inn riktig ved a printe
	 * ut alle vestlige naboruter til terminalen.
	 */
	public void testNaboer(){
		for(int i=0; i<rader;i++){
			for(int j=0; j<kolonner;j++){
				System.out.print(ruter[i][j].vest + " ");
			}
			System.out.println();
		}
	}
}
