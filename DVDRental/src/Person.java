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
  private String name;
  private HashMap<String, DVD> archive;
  private HashMap<String, DVD> lended;
  private HashMap<String, DVD> borrowed;
  

  public Person(String name){
    this.name = name;
    this.archive = new HashMap<String, DVD>();
    this.lended = new HashMap<String, DVD>();
    this.borrowed = new HashMap<String, DVD>();
  }

  /**
     Method for registering a purchase of the dvd.
     Method tests if this person still ownes the dvd,
     and if not, declares a new dvd linked to this
     person and ads to arkiv.
   */

  public void buy(DVD film){
	  
    // Get the title of the film and test if the person
    // already owns it. If the person does, give error
    String title = film.title();
    DVD test = archive.get(title);
    
    if(test == null){
    	archive.put(title, film);
    }
    
    else{
    	System.out.println(name + " already owns a copy of this DVD!");
    }
  }

  /**
     Method for registering a lend from this person. The method
     ads the given dvd to the lending archive if the dvd is owned
     and in this persons inventory.
   */
  public void lend(String title, Person borrower){
    // Check if this person owns a copy
    DVD testDVD = archive.get(title);
    if(testDVD == null){
    	System.out.println(name + " does not own a copy of this DVD!");
    }
    else{
    	// Check that the person has the DVD in stock
    	Person testBorrowed = testDVD.borrowed();
    	if(testBorrowed != null){
    		System.out.println(name + " has already lended the copy of " + testDVD.title());
    	}
    	else{
    		// Check if the lender can borrow
    		Boolean check = borrower.borrow(testDVD, testDVD.owner());
    		if(check == true){
    			// Put DVD to lending list and update the dvd
    			borrowed.put(title, testDVD);
    			testDVD.move(borrower);
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
  public Boolean borrow(DVD film, Person lender){
    // Get the title of the film
    String title = film.title();

    // check if this person already owns a copy
    DVD testDVD = archive.get(title);
    if(testDVD != null){
    	System.out.println(name + " already owns a copy of " + testDVD.title());
    	return false;
    }
    else{
    	// check if this person is already borrowing a copy
    	DVD testdvd2 = lended.get(title);
    	if(testdvd2 != null){
    		System.out.println(name + " is already lending a copy of " + testdvd2.title());
    		return false;
    	}
    	else{
    		// Put the DVD to the borrowing list
    		lended.put(title, film);
    		return true;
    	}
    }
  }

  /**
     Method for returning a dvd to it's owner. method checks
     if the current person is borrowing the dvd from someone, 
     and then removes this dvd from this persons borrowed list.
   */
  public void giveBack(String title)
  {
    // Check if the current DVD is being borrowed
    DVD film = borrowed.get(title);
    if(film == null){
    	System.out.println(name + " is not borrowing a copy of " + title);
    }
    
    else{
    	// Check if owner can recieve the DVD
    	Person eier = film.owner();
    	eier.recieve(film);

    	// Update dvd position and loan list 
    	film.move(null);
    	borrowed.remove(title);
    }
  }

  /**
     Method for receiving a DVD back from someone, method checks
     if the current person is lending the DVD. If not
   */
  public void recieve(DVD film){
	  DVD test = lended.get(film.title());
	  if(test == null){
		  System.out.println(name + " is not lending out a copy of" + film.title());
	  }
	  else{
		  lended.remove(film.title());
      }
  }

  /**
     Method for printing this persons archives.
   */
  public void overview(){
	  System.out.println("----------------------------------------");
	  System.out.println("Person: " + name);

	  // Print owned dvds
	  if(archive.isEmpty()){
		  System.out.println(name + " does not own any DVD's");
      }
    else{
    	System.out.println("DVD's that " + name + " owns:");
    	for(String s : archive.keySet()){
    		DVD film = archive.get(s);
    		System.out.println(film.title());
    	}
    }

    // Print loaned dvds
    if(lended.isEmpty()){
    	System.out.println(name + " is not lending out any DVD's");
    }
    else{
    	System.out.println("DVD's that " + name + " is lending out:");
    	for(String s : lended.keySet()){
    		DVD film = lended.get(s);
    		Person navnpalaner = film.borrowed();
    		String laner = navnpalaner.name();
    		System.out.println(film.title() + " has been lended to " + laner);
    	}
    }

    // print borrowed DVD's
    if(borrowed.isEmpty()){
    	System.out.println(name + " is not borrowing any DVD's.");
    }
    else{
    	System.out.println("DVD's " + name + " is borrowing:");
    	for(String s : borrowed.keySet()){
    		DVD film = borrowed.get(s);
    		Person nameOfLender = film.owner();
    		String utlaner = nameOfLender.name();
    		System.out.println(film.title() + " is borrowed from " + utlaner);
    	}
    }
    System.out.println("----------------------------------------");
  }

  /**
     Method for printing this persons statistics
  */
  public void statistics(){
    System.out.println("NAME   : " + name);
    System.out.println("OWNED  : " + archive.size());
    System.out.println("LAANT  : " + borrowed.size());
    System.out.println("UTLAANT: " + lended.size());
  }

  /**
     Return the persons name
   */
  public String name(){
    return name;
  }

  /**
   */
  public HashMap<String, DVD> archive(){
    return archive;
  }

  public HashMap<String, DVD> lended(){
    return lended;
  }
  
  public HashMap<String, DVD> borrowed(){
    return borrowed;
  }
}
