import java.util.Scanner;
/*
Program for running a simple math test. Insert values in the terminal,
then try to guess the sum and the product
 */

public class MinOppgave1
{
  public static void main(String[] args)
    {
      Scanner in = new Scanner(System.in);

      // Read integers from terminal
      System.out.print("Gi et heltall: ");
      int a = in.nextInt();
      System.out.print("Gi et nytt heltall: ");
      int b = in.nextInt();
      System.out.print("Gi et siste tall: ");
      int c = in.nextInt();

      // Guess the sum
      System.out.print("Skriv summen av tallene: ");
      int thesum = in.nextInt();

      // Check if the sum is correct, print result to terminal
      if (thesum == a + b + c)
      {
	System.out.println("Riktig!!!");
      }
      else
      {
	System.out.println("Feil!!!");
      }
      
      // Guess the product
      System.out.print("Skriv produktet av tallene: ");
      int theproduct = in.nextInt();

      // Check if the product is correct, print result to terminal
      if (theproduct == a*b*c)
      {
	System.out.println("Riktig!!!");
      }
      else
      {
	System.out.println("Feil!!!");
      }
    }
}
