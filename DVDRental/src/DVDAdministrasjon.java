import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class DVDAdministrasjon
{
  public static void main(String[] args) throws Exception 
  {
    HashMap<String, Person> navneliste = new HashMap<>();
    lesarkiv(navneliste);
    meny(navneliste);
    skrivarkiv(navneliste);

  }

  /**
     Method for displaying the interactive menu session. The method gives 
     a number of choices to the user and applies the information
     to the archive
   */
  static void meny(HashMap<String, Person> navneliste)
  {
        Scanner input = new Scanner(System.in);



    // Define the choice variable
    int choice;

    // Make the choice, update the classes.
    do
      {
	// Display menu
	System.out.println("------------------------------");
	System.out.println("MENY FOR DVD ADMINISTRASJON");
	System.out.println("------------------------------");
	System.out.println();
	System.out.println("VENNLIGST VELG EN HANDLING:");
	System.out.println();
	System.out.println("1: Registrer ny person");
	System.out.println("2: Kjop film");
	System.out.println("3: Laan film");
	System.out.println("4: Vis");
	System.out.println("5: Oversikt over kunder");
	System.out.println("6: Retur av film");
	System.out.println("7: Avslutt programmet");
	System.out.println("------------------------------");
	System.out.println();

	// Test that the input is integer
	while(true)
	  {
	    System.out.print("Tast inn ditt valg: ");
	    try
	      {		
		choice = Integer.parseInt(input.nextLine());
		break;
	      }
	    catch(NumberFormatException ignore)
	      {
		System.out.println("Ugyldig input!");
		System.out.println("Input ma vere et heltall");
	      }
	  }
	
	// Add person
	if(choice == 1)
	  {
	    // Give the name of the person
	    System.out.print("Navn paa den som skal registreres: ");
	    String navn = input.nextLine();
	    Person registrert = navneliste.get(navn);

	    // Check if person is registered, add if not
	    if(registrert == null)
	      {
	        navneliste.put(navn, new Person(navn));
	      }
	    else
	      {
		System.out.println(registrert.navn() + " er allerede registrert i databasen");
	      }
	    System.out.println();
	  }

	// Register a purchase
	else if(choice == 2)
	  {
	    // Read the name and check if person is registered
	    System.out.print("Gi navnet paa den som har kjop DVD-en: ");
	    String navn = input.nextLine();
	    Person kjoper = navneliste.get(navn);
	    if(kjoper == null)
	      {
		System.out.println(navn + " er ikke registrert i databasen!");
	      }
	    else
	      {
		// Buy the DVD if the person doesn't have it
		System.out.print("Gi tittelen paa DVD-en som er kjopt: ");
		String tittel = input.nextLine();
		DVD kjopt = new DVD(tittel, kjoper);
		kjoper.kjop(kjopt);
	      }
	    System.out.println();
	  }

	else if(choice == 3)
	  {
	    // Read the name of the lendier
	    System.out.print("Gi navnet paa den som vil laane DVD-en: ");
	    String navn1 = input.nextLine();
	    Person laaner = navneliste.get(navn1);

	    // Check if lender exists
	    if(laaner == null)
	      {
		System.out.println(navn1 + " er ikke registret i databasen!");
	      }
	    else
	      {
		// Read the name of the person lending
		System.out.print("Gi navnet paa den som skal laane ut DVD-en: ");
		String navn2 = input.nextLine();
		Person utlaaner = navneliste.get(navn2);

		// Check if the person lending exists
		if(utlaaner == null)
		  {
		    System.out.println(navn2 + " er ikke registret i databasen!");
		  }
		else if(utlaaner == laaner)
		  {
		    System.out.println(navn1 + " kan ikke laane en DVD til seg selv!");
		  }
		else
		  {
		    // Attempt to finnish the loan
		    System.out.print("Gi tittelen på DVD-en: ");
		    String tittel = input.nextLine();
		    utlaaner.laanut(tittel, laaner);
		  }
	      }
	    System.out.println();
	  }

	else if(choice == 4)
	  {
	    // read the name
	    System.out.print("Gi navnet på personen du vil se(* for alle): ");
	    String visperson = input.nextLine();
	    
	    // Print all persons overviews
	    if(visperson.equals("*"))
	      {
		for(String s : navneliste.keySet())
		  {
		    Person denne = navneliste.get(s);
		    denne.oversikt();
		  }
	      }
	    else
	      {
		// Check if person exists
		Person denne = navneliste.get(visperson);
		if(denne == null)
		  {
		    System.out.println(visperson + " er ikke registret i databasen!");
		  }
		else
		  {
		    // print persons overview
		    denne.oversikt();
		  }
	      }
	    System.out.println();
	  }
	
	// Print all persons statistics
	else if(choice == 5)
	  {
	    for(String s : navneliste.keySet())
	      {
		Person denne = navneliste.get(s);
		denne.statistikk();
		System.out.println();
	      }
	    System.out.println();
	  }

	else if(choice == 6)
	  {
	    System.out.println("Gi navn paa den som skal levere tilbake en DVD: ");
	    String navn1 = input.nextLine();
	    Person laaner = navneliste.get(navn1);
	    if(laaner == null)
	      {
		System.out.println(navn1 + " er ikke registret i databasen!");
	      }
	    else
	      {
		System.out.println("Gi tittlene paa DVD-en: ");
		String tittel = input.nextLine();
		laaner.retur(tittel);
	      }
	    System.out.println();
	  }
	else if(choice == 7)
	  {
	    System.out.println("AVSLUTTER PROGRAMMET");
	  }
      }while(choice != 7);
  }

  /**
     Method for reading the archive file, the method stores the names
     in the HashMap navneliste and ads data about each persons loaned
     DVD-s.
     
   */
  static void lesarkiv(HashMap<String, Person> navneliste) throws Exception
  {
    String filename = "dvdarkiv.txt";
    File file = new File(filename);
    Scanner reader = new Scanner(file);
    
    // Read the file line by line and add names
    // to the archive. Stop when '-' is reached
    while(reader.hasNextLine())
      {
	String navn = reader.nextLine();
	if(navn.startsWith("-"))
	  {
	    break;
	  }
	else
	  {
	    navneliste.put(navn, new Person(navn));
	  }	
      }
    
    // Add DVDs to persons
    String init = reader.nextLine();
    Person current = navneliste.get(init);

    while(reader.hasNextLine())
      {
	String line = reader.nextLine();

	// If line is "-", update the current person
	if(line.equals("-"))
	  {
	    current = navneliste.get(reader.nextLine());
	  }

	// If line starts with "*", update loan and borrowing lists
	else if(line.startsWith("*"))
	  {
	    // get title and create new DVD
	    String tittel = line.substring(1, line.length());
	    DVD denne = new DVD(tittel, current);
	    current.kjop(denne);

	    // Get the lender and register the loan	    
	    Person laner = navneliste.get(reader.nextLine());
	    current.laanut(tittel, laner);
	  }

	// Add DVD to current person
	else
	  {
	    DVD denne = new DVD(line, current);
	    current.kjop(denne);
	  }
      }
    reader.close();
  }

  /**
     Method for writing changes done in the archive to the archive file
   */
  static void skrivarkiv(HashMap<String, Person> navneliste) throws Exception
  {
    PrintWriter out = new PrintWriter("dvdarkiv.txt");

    // Write all names to file
    for(String s : navneliste.keySet())
      {
	Person denne = navneliste.get(s);
	out.println(denne.navn());
      }

    // Write owned DVD-s to file
    for(String s : navneliste.keySet())
      {
	Person person = navneliste.get(s);
	out.println("-");
	out.println(s);

	// Write owned DVD-s to file
	HashMap<String, DVD> arkiv = person.arkiv();
	for(String eid : arkiv.keySet())
	  {
	    DVD dvd = arkiv.get(eid);
	    Person utlaaner = dvd.utlaant();
	    if(utlaaner == null)
	      {
		out.println(dvd.tittel());
	      }
	  } 

	// Write dvds that are lended out with name of lender
	HashMap<String, DVD> leidut = person.utlant();
	for(String ut : leidut.keySet())
	  {
	    DVD dvd = leidut.get(ut);
	    Person utlaaner = dvd.utlaant();
	    if(utlaaner != null)
	      {
		out.println("*" + dvd.tittel());
		out.println(utlaaner.navn());
	      }
	  }
      }
    out.close();
  }
}
