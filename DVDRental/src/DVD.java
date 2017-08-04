/**
   Class for holding information about a DVD and its owner.
   Also holds information about who is borrowing the DVD
 */

public class DVD{
  private String title;
  private Person owner;
  private Person borrower;

  public DVD(String title, Person owner){
    // Set the title, the owner and set the
    // borrowed status to null when initialized
    this.title = title;
    this.owner = owner;
    this.borrower = null;
  }

  /**
    Method for returning the title of the
    dvd in string format
  */

  public String title(){
    return title;
  } 

  /**
     Method for returning the owner of the dvd
     in string format
  */
  public Person owner(){
    return owner;
  }
 
  /**
     Method for returning the borrowed status of the
     dvd. Returns the current person borrowing it. Returns
     null if it is not borrowed 
   */
  public Person borrowed(){
    return borrower;
  }

  /**
     Method registering the loaner of the dvd, returns null
     if the dvd is still with it's owner
   */
  public void move(Person name){
    borrower = name;
  }
}
