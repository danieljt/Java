import java.util.Scanner;
import java.util.Arrays;
import java.io.File;

public class Innlesing
{
  public static void main(String[] args) throws Exception
  {
    // Read file
    String filename = "winnie.txt";
    File inputfile = new File(filename);
    Scanner reader = new Scanner(inputfile);
    
    // Ask user for a text to search for
    Scanner inputtext = new Scanner(System.in);
    System.out.print("Enter the text you want to find: ");
    String text = inputtext.nextLine();

    // Loop through file
    int i = 0;
    while (reader.hasNextLine())
      {
	String line = reader.nextLine();

	// test if current line has our text and count 
	if (line.startsWith(text))
	  {
	    i += 1;
	  }
      }
    reader.close();
    System.out.println(i);
  }
}
