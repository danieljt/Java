/**
   Class for holding information about a DVD and its owner.
   Also holds information about who is borrowing the DVD
 */

public class DVD
{
  private String tittel;
  private Person eier;
  private Person laner;

  public DVD(String title, Person owner)
  {
    // Set the title, the owner and set the
    // borrowed status to null when initialized
    tittel = title;
    eier = owner;
    laner = null;
  }

  /**
    Method for returning the title of the
    dvd in string format
  */

  public String tittel()
  {
    return tittel;
  } 

  /**
     Method for returning the owner of the dvd
     in string format
  */
  public Person eier()
  {
    return eier;
  }
 
  /**
     Method for returning the borrowed status of the
     dvd. Returns the current person borrowing it. Returns
     null if it is not borrowed 
   */
  public Person utlaant()
  {
    return laner;
  }

  /**
     Method registering the loaner of the dvd, returns null
     if the dvd is still with it's owner
   */
  public void flytt(Person navn)
  {
    laner = navn;
  }
}
