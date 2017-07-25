public abstract class Rute {
	public int rad;
	public int kolonne;
	public Rute nord;
	public Rute syd;
	public Rute ost;
	public Rute vest;
	public Labyrint labyrint;
	boolean pvei;

	public Rute(int rad, int kolonne){  
	    this.rad = rad;
	    this.kolonne = kolonne;
	}

	public abstract char tilTegn();

	public void finnUtvei() {
		gaa("");
	}

	public void gaa(String veiHittil) {
		
		
		if(labyrint.debug == true){
			System.out.println(toString());
		}

		// Sjekker om denne ruten er en aapning. Hvis dette stemmer
		// saa gaar vi tilbake til forrige rute
		if (erAapning() == true) {
		    veiHittil += this.toString();
			this.labyrint.utveier.settInn(veiHittil);
		}
		veiHittil +=  this.toString() + " --> ";
		pvei = true;

		// Vi gaar til alle naboruter bortsett fra den vi kom fra
		if (nord instanceof HvitRute && !nord.pvei) {
			nord.gaa(veiHittil);
		}

		if (syd instanceof HvitRute && !syd.pvei) {
			syd.gaa(veiHittil);
		}
		
		if (ost instanceof HvitRute && !ost.pvei) {
			ost.gaa(veiHittil);
		}
		
		if (vest instanceof HvitRute && !vest.pvei) {
			vest.gaa(veiHittil);
		}
			
		pvei = false;
		return;
	}
		
	/**
	 * Sjekker om denne ruten er en aapning
	 * @return true hvis aapning, ellers false
	 */
	public boolean erAapning() {
		if (this instanceof Aapning) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Gir rutens koordinater 
	 * @return rutens koordinater i string format
	 */
	public String toString() {
		return "(" + (rad+1) + " , " + (kolonne+1) + ")";
	}
}
