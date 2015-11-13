 public class Oppgave51
{
  public static void main(String[] args)
  {
    // Define new car
    Bil bil = new Bil();

    // Check the car
    int km1 = bil.hentKilometerstand();
    double maks1 = bil.hentMaksDistanse();
    System.out.println();
    System.out.println("Kilometerstand: "+km1);
    System.out.println("Maks kjorelengde: " +maks1);
    System.out.println();

    // Take a few trips and check
    bil.kjorTur(20);
    bil.kjorTur(70);
    int km2 = bil.hentKilometerstand();
    double maks2 = bil.hentMaksDistanse();
    System.out.println();
    System.out.println("Kilometerstand: "+km2);
    System.out.println("Maks kjorelengde: " +maks2);
    System.out.println();

    // Take a long trip that is too long
    bil.kjorTur(1000);
    int km3 = bil.hentKilometerstand();
    double maks3 = bil.hentMaksDistanse();
    System.out.println();
    System.out.println("Kilometerstand: "+km3);
    System.out.println("Maks kjorelengde: " +maks3);
    System.out.println();
 
    // Refuel the car and check
    bil.fyllTank(5);
    int km4 = bil.hentKilometerstand();
    double maks4 = bil.hentMaksDistanse();
    System.out.println();
    System.out.println("Kilometerstand: "+km4);
    System.out.println("Maks kjorelengde: " +maks4);
    System.out.println();
  }
}
