import java.util.Scanner;
/*
Enkelt program for aa demonstrere metoder for aa haantere
data. Programmet tar 2 tall og beregner summen, differansen
og produktet mellom dem
 */

public class EnkelKalkulator
{
  public static void main(String[] args)
    {
      Scanner reader = new Scanner(System.in);
      System.out.print("Skriv det foarste tallet: ");
      int a = reader.nextInt();
      System.out.print("Skriv det neste tallet: ");
      int b = reader.nextInt();

      addere(a, b);
      subtrahere(a, b);
      multiplisere(a, b);
    }
  /**
     Beregner summen av to heltall a og b.
     @param a Det foarste tallet.
     @param b Det andre tallet.
     @return Printer resultatet i terminalen
   */
  public static void addere(int a, int b)
    {
      int sum;
      sum = a + b;
      System.out.println("Summen er " + sum);
    }
  /**
     Beregner differansen mellom tallet a og b.
     @param a Det foarste tallet.
     @param b Det andre tallet.
     @return Printer resultatet i terminalen
   */
  public static void subtrahere(int a, int b)
    {
      int sum;
      sum = a - b;
      System.out.println("Summen er " + sum);
    }
  /**
     Beregner produktet av to heltall a og b.
     @param a Det foarste tallet.
     @param b Det andre tallet.
     @return Printer resultatet i terminalen
   */
  public static void multiplisere(int a, int b)
    {
      int product;
      product = a*b;
      System.out.printf("Produktet er " + product);
    }
}
