import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class Ordliste
{ 
  ArrayList<Ord> ordliste = new ArrayList<>();
  
  public void lesBok(String filename) throws Exception
  {
    // Read the file
    File file = new File(filename);
    Scanner reader = new Scanner(file);

    // Add the first word
    String firstline = reader.nextLine();
    ordliste.add(new Ord(firstline));

    // Loop over the rest of the file
    while(reader.hasNextLine())
      {
	String line = reader.nextLine();
	leggTilOrd(line);
      }
  }

  /**
     Method for adding a word to the dictionary. Each word
     is assigned it's own object. If the word is already present,
     it's counter is increased by one. 
   */
  private void leggTilOrd(String ord)
  {
    
    // Evaluate next word. Add to list if it is not
    // there already, else increase counter
    Ord nyttord = finnOrd(ord);
    if(nyttord == null)
      {
	ordliste.add(new Ord(ord));
      }   
    else
      {
	nyttord.oekAntall();
      }
  }
  /**
     Method for finding current words in the dictionary.
     If the word exists, method returns null. If the 
     word doesn't exist, method returns it's string value
   */
  public Ord finnOrd(String tekst)
  {
    Ord test = null;
    for(int i=0; i < ordliste.size(); i++)
      {
	// Check word number i with the text
	test = ordliste.get(i); 
	if(tekst.equalsIgnoreCase(test.toString()))
	  {
	    return test;
	  }	    
      }
    return null;
  }
  
  /**
     Method for calculating the number of 
     words in the dictionary.
   */
  public int antallOrd()
  {
    return ordliste.size();
  }

  /**
     Method for finding the number of times a word
     has been registered.
   */
  public int antallForekomster(String tekst)
  {
    Ord ord = finnOrd(tekst);
    int antall = ord.hentAntall();
    return antall;
  }

  /**
     Method for finding the most common word in the
     given text. If a word has the same amount of
     occurences, only the first word is returned
   */
  public Ord vanligste()
  {
    // Set the first element as the largest
    Ord max = ordliste.get(0);

    // Iterate list and check each element against
    // the largest
    for(int i=1; i < ordliste.size(); i++)
      {
	Ord denne = ordliste.get(i);
	  if(denne.hentAntall() > max.hentAntall())
	  {
	    max = denne;
	  } 
      }
    return max;
  }

  /**
     Method for finding the k most common words in the
     text. The number k is the integer value for the
     amount of words to be ranked. If two words
     have the same amount of occurences, only the first
     word is used.
   */
  public Ord[] alleVanligste(int antall)
  {
    // Create a temporary editable list
    ArrayList<Ord> mid = ordliste;
    Ord[] maxliste = new Ord[antall];
    
    // Set values to element i in list
    for(int i=0; i < antall; i++)
      {
	Ord max = mid.get(0);
	int k = 0;
	
	// Loop over all elements in temporary list
	for(int j=1; j < mid.size(); j++)
	  {
	    Ord denne = mid.get(j);
	    
	    // Check if current word has more encounters
	    // Set it to the largest if true
	    if(denne.hentAntall() > max.hentAntall())
	      {
		max = denne;
		k = j;
	      }
	  }
	// Update maxlist and remove from temporary
	maxliste[i] = max;
	mid.remove(k);
      }
    return maxliste;
  }
}