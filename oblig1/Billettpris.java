import java.util.Scanner;

public class Billettpris
{
  public static void main(String[] args)
    {
      Scanner in = new Scanner(System.in);

      // Read age fromm terminal
      System.out.print("Vennligs oppgi alder: ");
      int alder = in.nextInt();
      int Billettpris;
	
      // Calculate the ticket price with respect to age
      if (alder < 18)
      {
	Billettpris = 25;
      }
      else if (alder >= 67)
      {
	Billettpris = 25;
      }
      else
      {
	Billettpris = 50;
      }
      System.out.printf("Billetprisen blir %s kr \n", Billettpris);
    }
}
	
