import java.util.Arrays;
import java.util.Scanner;
import java.io.File;

public class Valg
{
  public static void main(String[] args) throws Exception
  {
    // Read file
    String filename = "stemmer.txt";
    File inputfile = new File(filename);
    Scanner reader = new Scanner(inputfile);

    // Read file values to array
    String[] votes= new String[456];
    int i = 0;
    while (reader.hasNextLine())
      { 
	votes[i] = reader.nextLine();
	i += 1;
      }

    // Close file
    reader.close();
    
    // Number of votes for each party
    int[] choice = new int[4];
    
    // Loop through array. Count votes and add to values
    for (int j=0; j < votes.length; j++)
      {
	String line = votes[j];

	if (line.startsWith("Ap"))
	  {
	    choice[0] += 1;
	  }
	else if (line.startsWith("KrF"))
	  {
	    choice[1] += 1;
	  }
	else if (line.startsWith("Sp"))
	  {
	    choice[2] += 1;
	  }
	else if (line.startsWith("H"))
	  {
	    choice[3] += 1;
	  }
      }

    // calculate percentages and find winner
    double[] percent = new double[4];
    for(int k=0; k < percent.length; k++)
      {
	double val = choice[k];
	percent[k] = val/i*100.0; 
      }
    
    // Loop to find max value and index
    String[] party = {"Ap", "Krf", "Sp", "H"};
    double max = percent[0];
    int maxint = 0;
    for (int k=1; k < percent.length; k++)
      {
	if (percent[k] > max)
	  {
	    max = percent[k];
	    maxint = k;
	  } 
      }  

    // Print winner to terminal
    System.out.printf("Vinneren av valget er "+ party[maxint] +
		      " med %.2f prosent av stemmene \n", max);
  }
}
