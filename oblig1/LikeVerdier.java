import java.util.Scanner;

public class LikeVerdier
{
  public static void main(String[] args)
    {
      Scanner in = new Scanner(System.in);
      
      // Read input from terminal
      System.out.print("Please enter a integer: ");
      int c = in.nextInt();
      System.out.print("Please enter a second integer: ");
      int d = in.nextInt();
      
      // Pre defined integers
      //int c = 2;
      //int d = 3;
      
      // Test ic c and d have the same values
      // Output result to terminal
      if (c == d)
      {
	System.out.printf("%d og %d er like \n", c, d);
      }
      else
      {
	System.out.printf("%d og %d er ikke like \n", c, d);
      }
    }
}
