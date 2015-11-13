import java.util.Scanner;

public class Kalkulator
{
  public static void main(String[] args)
  {
    Scanner reader = new Scanner(System.in);

    // Ask user for two numbers
    System.out.print("Gi tall nr 1: ");
    int a = reader.nextInt();
    System.out.print("Gi tall nr 2: ");
    int b = reader.nextInt();

    // Calculate sum, difference, integer division and float division
    int addSvar = addisjon(a, b);
    int subSvar = subtraksjon(a, b);
    int helDivSvar = heltallsdivisjon(a, b);
    double divSvar = divisjon(a, b);

    System.out.println(addSvar);
    System.out.println(subSvar);
    System.out.println(helDivSvar);
    System.out.println(divSvar);
  }

  /**
     Method for adding two integers a and b and
     returning the result.
     @param a First integer
     @param b Second integer
     @returns a + b
   */
  static int addisjon(int a, int b)
  {
    return a + b;
  }

  /**
     Method for subtracting two numbers a nd b and 
     returning the result.
     @param a First integer
     @param b Second integer
     @returns a - b     
   */
  static int subtraksjon(int a, int b)
  {
    return a - b;
  }

  /**
     Method for calculating the integer division of two
     numbers and returning the result.
     @param a First integer
     @param b Second integer
     @returns a%b integer division
   */
  static int heltallsdivisjon(int a, int b)
  {
    return a/b;
  }

  /**
     Method for calculating the floating point division 
     of two numbers and returning the result
     @param a First integer
     @param b Second integer
     @returns a/b float division
   */
  static double divisjon(double a, double b)
  {
    return a/b;
  } 
} 
