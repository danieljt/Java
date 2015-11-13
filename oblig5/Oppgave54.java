public class Oppgave54
{
  public static void main(String[] args)
  {
    // define new employee list
    Isbod boden = new Isbod();

    // register 11 employes and check that 
    // an error message is produced
    boden.ansett("Joakim Gunnar");
    boden.ansett("Vibekke Tramp");
    boden.ansett("Kjell Turid");
    boden.ansett("Arne Turid");
    boden.ansett("Ha Ha");
    boden.ansett("Marianne Banne");
    boden.ansett("Oddgunn Turid");
    boden.ansett("Tine Pine");
    boden.ansett("Annette Sprette");
    boden.ansett("Ivar Turid");
    boden.ansett("Petter Pikk");
 
    // Print employees 
    boden.printAlleAnsatte();

    // Fire the last employee
    boden.giSistemannSparken();

    // Check that the fired employee is
    // removed from array
    boden.printAlleAnsatte();
  }
}
