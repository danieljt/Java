
public class Test {

	public static void main(String[] args) {
	    Tabell<Pasient> pasienter = new StatiskTabell<Pasient>(5);
	    Tabell<Legemiddel> legemidler = new StatiskTabell<Legemiddel>(5);
	    Tabell<Resept> resepter = new StatiskTabell<Resept>(10);
	    Legeliste leger = new Legeliste();
	    
	    // Lag leger
		Lege en = new Lege("Bjarne");
		Lege to = new Lege("Mons");
		Lege tr = new Lege("Eldmor");
		
		// Sett inn leger
		leger.settInn(en);
		leger.settInn(to);
		leger.settInn(tr);
		
		// Skriv ut leger
		for(Lege lege : leger){
			System.out.println(lege.toString());
		}
		System.out.println();
		
		// Lag pasienter
		Pasient tor = new Pasient("tor", 1, "Gata", 1234);
		Pasient gun = new Pasient("gun", 2, "Veien", 3245); 
		
		// Sett in pasienter
		pasienter.settInn(tor);
		pasienter.settInn(gun);
		
		// Skriv ut pasienter
		for(Pasient pasient : pasienter){
			System.out.println(pasient.toString());
		}
		System.out.println();
		
		// Lag legemidler
		Legemiddel oh = new Legemiddel("Oh", 123, 3);
		Legemiddel ah = new Legemiddel("Ah", 222, 6);
		
		// Sett inn legemidler
		legemidler.settInn(oh);
		legemidler.settInn(ah);
		
		// Skriv ut legemidler
		for(Legemiddel legemiddel : legemidler){
			System.out.println(legemiddel.toString());
		}
		System.out.println();
		
		// Lag resepter
		HvitResept farlig = new HvitResept(oh, en, 0, 3);
		HvitResept herlig = new HvitResept(oh, en, 0, 2);
		
		// Sett inn resepter
		resepter.settInn(farlig);
		resepter.settInn(herlig);
		
		// Sett inn resepter hos leger
		en.leggTilResept(farlig);
		en.leggTilResept(herlig);
		
		// Sett inn resepter hos pasienter
		tor.leggTilResept(farlig);
		tor.leggTilResept(herlig);
		
		// Skriv ut resepter
		for(Resept resept: resepter){
			System.out.println(resept);
		}
		System.out.println();
		for(Resept resept : en.reseptliste){
			System.out.println(resept.toString());
		}
		System.out.println();
		for(Resept resept : tor.hentReseptliste()){
			System.out.println(resept.toString());
		}
	}

}
