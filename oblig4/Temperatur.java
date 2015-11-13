import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

public class Temperatur
{
  public static void main(String[] args) throws Exception
  {
    // Read file
    String filename = "temperatur.txt";
    File inputfile = new File(filename);
    Scanner reader = new Scanner(inputfile); 

    // Define array for temperatures
    int[] temperaturer = new int[12];
    int i = 0;

    // Add temperature values to array
    while (reader.hasNextInt())
      {
	int value = reader.nextInt();
	temperaturer[i] = value;
	i += 1;
      }
    reader.close();

    // Print array to validate
    System.out.println(Arrays.toString(temperaturer));

    // Compute the sum of the temperatures
    double sum = 0; 
    for(int j=0; j < temperaturer.length; j++)
      {
	sum += temperaturer[j];
      } 
    
    // Compute the average temperature
    double average = sum/temperaturer.length;
    System.out.println(average);
  }
}
