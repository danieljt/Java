import java.util.Scanner;

public class Metoder
{
  public static void main(String[] args)
    {
      // Run the name and residence method 3 times
      lesnavn();
      lesnavn();
      lesnavn();
    }

  public static void lesnavn()
    {
      // Define scanner for input, then insert name and 
      // place of residence. Dump result to terminal 
      Scanner reader = new Scanner(System.in);
      System.out.print("Skriv inn navn: ");
      String navn = reader.next();
      System.out.print("Skriv inn bosted ");      
      String bosted = reader.next();
      System.out.println("Hei" + navn, "Du er fra" + bosted);
    }
}
