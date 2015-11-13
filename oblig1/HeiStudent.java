import java.util.Scanner;

public class HeiStudent
{  
  public static void main(String[] args)
    {         
      Scanner in = new Scanner(System.in);

      // print 
      System.out.println("Hei Student!");

      String navn = "Daniel";
      System.out.println("Hei" + " " + navn);

      //Enter "name" and print out "hello name" 
      System.out.print("Please enter your name: ");
      String name = in.next();
      System.out.println("Hello" + " " + name);
      
      //print the sum of two integers
      int a = 3;
      int b = 8;
      System.out.println(a + b);
      
      //Enter two integers in the terminal and print the sum
      System.out.print("Enter a integer: ");
      int c = in.nextInt();
      System.out.print("Enter a second integer: ");
      int d = in.nextInt();
      System.out.println(c + d);
    }
}
