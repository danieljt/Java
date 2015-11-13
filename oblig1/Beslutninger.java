import java.util.Scanner;

public class Beslutninger
{
  public static void main(String[] args)
    {
      //Read name from terminal
      Scanner in = new Scanner(System.in);
      System.out.print("Please enter your age: ");
      double alder = in.nextInt();

      //double alder = 13;
      
      // Check the age and print to terminal if the person is of age or not
      if (alder < 18)
      {
	System.out.println("Du er ikke myndig");
      }
      else
      {
	System.out.println("Du er myndig");
      }

    }
}
