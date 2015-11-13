import java.util.HashMap;

/**
  Class for holding the information on a person. Each person
  can owna set of dvds in a list. Assume that every person can
  only own one copy of a given dvd. The person can lend or 
  borrow as many dvds as he wants as long as they are not 
  already borrowed.
*/

public class Person
{
  // Declare the persons name, list of owned dvds, lended
  // dvds and borrowed dvds.
  private String navn;
  private HashMap<String, DVD> arkiv;
  private HashMap<String, DVD> utlant;
  private HashMap<String, DVD> lant;
  

  public Person(String name)
  {
    navn = name;
    arkiv = new HashMap<String, DVD>();
    utlant = new HashMap<String, DVD>();
    lant = new HashMap<String, DVD>();
  }

  /**
     Method for registering a purchase of the dvd.
     Method tests if this person still ownes the dvd,
     and if not, declares a new dvd linked to this
     person and ads to arkiv.
   */

  public void kjop(DVD film)
  {
    // Get the title of the film and test if the person
    // already owns it. If the person does, give error
    String tittel = film.tittel();
    DVD test = arkiv.get(tittel);
    if(test == null)
      {
	arkiv.put(tittel, film);
      }
    else
      {
	System.out.println(navn + " eier allerede en kopi av denne DVD-en!");
      }
  }

  /**
     Method for registering a lend from this person. The method
     ads the given dvd to the lending archive if the dvd is owned
     and in this persons inventory.
   */
  public void laanut(String tittel, Person laner)
  {
    // Check if this person owns a copy
    DVD testdvd = arkiv.get(tittel);
    if(testdvd == null)
      {
	System.out.println(navn + " eier ikke en kopi av denne DVD-en!");
      }
    else
      {
	// Check that the person has the dvd in stock
	Person testutlant = testdvd.utlaant();
	if(testutlant != null)
	  {
	    System.out.println(navn + " laaner allerede ut sin kopi av " + testdvd.tittel());
	  }
	else
	  {
	    // Check if the lender can borrow
	    Boolean check = laner.laan(testdvd, testdvd.eier());
	    if(check == true)
	      {
		// Put dvd to lending list and update the dvd
		utlant.put(tittel, testdvd);
		testdvd.flytt(laner);
	      }
	  }
      }
  }

  /**
     Method for borrowing a DVD from another person. The method
     checks that this person does not already own a copy, or that 
     this person is already borrowing from someone else. 
     returns true false if the person already has a copy, 
     and true if the person does not own a copy.
   */
  public Boolean laan(DVD film, Person utlaner)
  {
    // Get the title of the film
    String tittel = film.tittel();

    // check if this person already owns a copy
    DVD testdvd = arkiv.get(tittel);
    if(testdvd != null)
      {
	System.out.println(navn + " eier allerede en kopi av " + testdvd.tittel());
	return false;
      }
    else
      {
	// check if this person is already borrowing a copy
	DVD testdvd2 = lant.get(tittel);
	if(testdvd2 != null)
	  {
	    System.out.println(navn + " laaner allerede en kopi av " + testdvd2.tittel());
	    return false;
	  }
	else
	  {
	    // Put the dvd to the borrowing list
	    lant.put(tittel, film);
	    return true;
	  }
      }
  }

  /**
     Method for returning a dvd to it's owner. method checks
     if the current person is borrowing the dvd from someone, 
     and then removes this dvd from this persons borrowed list.
   */
  public void retur(String tittel)
  {
    // Check if the current DVD is being borrowed
    DVD film = lant.get(tittel);
    if(film == null)
      {
	System.out.println(navn + " laaner ikke en kopi av " + tittel);
      }
    else
      {
	// Check if owner can recieve the DVD
	Person eier = film.eier();
	eier.motta(film);

	// Update dvd position and loan list 
	film.flytt(null);
	lant.remove(tittel);
      }
  }

  /**
     Method for receiving a DVD back from someone, method checks
     if the current person is lending the DVD. If not
   */
  public void motta(DVD film)
  {
    DVD test = utlant.get(film.tittel());
    if(test == null)
      {
	System.out.println(navn + " har ikke laant ut en kopi av" + film.tittel());
      }
    else
      {
	utlant.remove(film.tittel());
      }
  }

  /**
     Method for printing this persons archives.
   */
  public void oversikt()
  {
    System.out.println("----------------------------------------");
    System.out.println("Person: " + navn);

    // Print owned dvds
    if(arkiv.isEmpty())
      {
	System.out.println(navn + " eier ingen DVD-er");
      }
    else
      {
	System.out.println("DVD-er " + navn + " eier:");
	for(String s : arkiv.keySet())
	  {
	    DVD film = arkiv.get(s);
	    System.out.println(film.tittel());
	  }
      }

    // Print loaned dvds
    if(utlant.isEmpty())
      {
	System.out.println(navn + " laaner ikke bort noen DVD-er");
      }
    else
      {
	System.out.println("DVD-er " + navn + " laaner bort:");
	for(String s : utlant.keySet())
	  {
	    DVD film = utlant.get(s);
	    Person navnpalaner = film.utlaant();
	    String laner = navnpalaner.navn();
	    System.out.println(film.tittel() + " laanes til " + laner);
	  }
      }

    // print borrowed dvds
    if(lant.isEmpty())
      {
	System.out.println(navn + " laaner ingen DVD-er.");
      }
    else
      {
	System.out.println("DVD-er " + navn + " laaner:");
	for(String s : lant.keySet())
	  {
	    DVD film = lant.get(s);
	    Person navnpautlaner = film.eier();
	    String utlaner = navnpautlaner.navn();
	    System.out.println(film.tittel() + " er laant fra " + utlaner);
	  }
      }
    System.out.println("----------------------------------------");
  }

  /**
     Method for printing this persons statistics
  */
  public void statistikk()
  {
    System.out.println("NAVN   : " + navn);
    System.out.println("EIER   : " + arkiv.size());
    System.out.println("LAANT  : " + lant.size());
    System.out.println("UTLAANT: " + utlant.size());
  }

  /**
     Return the persons name
   */
  public String navn()
  {
    return navn;
  }

  /**
   */
  public HashMap<String, DVD> arkiv()
  {
    return arkiv;
  }

  public HashMap<String, DVD> utlant()
  {
    return utlant;
  }
  public HashMap<String, DVD> lant()
  {
    return lant;
  }
}
