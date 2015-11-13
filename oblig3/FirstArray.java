import java.util.Scanner;

public class FirstArray
{
  public static void main(String[] args)
  {
    // Declare arrays of size 4 and 5
    int intmax = 4;
    int strmax = 5;
    
    // Run methods for int and str operations
    int[] intarray = oppgabc(intmax);      
    String[] namearray = oppgd(strmax);
    
    // Loop over arrays and print values
    int i = 0;
    int j = 0;
    while (i <= intmax-1)
      {
	System.out.println(intarray[i]);
	i += 1;
      }
    
    while (j <= strmax-1)
      {
	System.out.println(namearray[j]);
	j += 1;
      }
  }
  
  /**
     Method for creating an array of size max and
     giving the array the values 0, 1, 2, ...
     Method sets the first and last element to 1337.
     @param max Maximum length of array.
     @return array The array.
   */
  public static int[] oppgabc(int max)
  {
    int counter = 0;
    int[] newarray = new int[max];

    while (counter <= max-1)
      {
	newarray[counter] = counter;
	System.out.println(newarray[counter]);
	counter += 1;	
      }
    newarray[0] = 1337;
    newarray[max-1] = 1337;
    return newarray;
  }

  /**
     Method for taking strings as input from the terminal, 
     and adding them to an array.
     @param strmax Maximum size of the array.
     @return namearray Arraywith strings.
   */
  public static String[] oppgd(int strmax)
  {
    Scanner reader = new Scanner(System.in);
    String[] namearray = new String[strmax];
    int i = 0;
    while (i < strmax)
      {
	System.out.print("Enter a name: ");
	String name = reader.nextLine();
	namearray[i] = name;
	i += 1;
      }
    return namearray;
  }
} 
