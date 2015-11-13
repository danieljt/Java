import java.util.Arrays;

public class Isbod
{
  private int antall;
  private String[] ansatte; 

  public Isbod()
  {
    // Set initial employees to zero
    antall = 0;
    // Array of employees, set max number to 10
    ansatte = new String[10];
  }

  public void ansett(String navn)
  {
    // Check if number of employees exceeds max value
    // Print error message if this is true, else 
    // register the new employee.
    if(antall + 1 > ansatte.length)
      {
	System.out.println("-------------------------");
	System.out.println("VARSEL");
	System.out.println("-------------------------");
	System.out.println("Du kan ikke ansette flere");
	System.out.println();
      }
    else
      {
	ansatte[antall] = navn;
	antall = antall + 1;
      }
  }
  public void giSistemannSparken()
  {
    // Fire the last employee and remove from array. 
    antall = antall - 1;
    System.out.println("--------------------------");
    System.out.println("VARSEL OM NY OPPSIGELSE");
    System.out.println("--------------------------");
    System.out.println(ansatte[antall]+" er blitt sparket.");
    System.out.println();
    ansatte[antall] = null;
  }
  public void printAlleAnsatte()
  {
    // Print all current employees to terminal
    System.out.println("-------------------------");
    System.out.println("LISTE OVER ANSATTE");
    System.out.println("-------------------------");
    for(int i=0; i < antall; i++)
      {	
	System.out.println(ansatte[i]);
      }
    System.out.println();
  }
}
