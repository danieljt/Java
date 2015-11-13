import java.util.Scanner;

public class SumTall
{
  public static void main(String[] args)
  {
    Scanner readnumber = new Scanner(System.in);
    // Gi menyen
    printmeny();
    
    // Gi tallet til if testen og tallet
    // som inneholder summen av alle gitte tall
    int tall = readnumber.nextInt();
    int sumert = tall;
    
    // Ta inn nye tall og legg dem til tallet
    // summert. Avslutt naar tallet 0 tastes inn.
    while (tall != 0)
      {
	System.out.print("Gi neste tall: ");
	tall = readnumber.nextInt();
	sumert += tall;
      }

    // Print summen i terminalen
    System.out.println("Summen av tallene er " + sumert);
  }

  /**
     Gir menyen til programmet
   */
  static void printmeny()
  {
    System.out.println("Dette programmet summerer alle tall ");
    System.out.println("som gis i terminalen. Programmet");
    System.out.println("avsluttes naar bruker taster \"0\".");
    System.out.print("Gi et tall: ");
  }
}
