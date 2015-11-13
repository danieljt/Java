import java.util.Arrays;

class NegativeTall
{
  public static void main(String[] args)
  {
    int[] heltall = {1, 4, 5, -2, -4, 6, 10, 3, -2};

    // count number of negative numbers
    int i = 0;
    int counter = 0;
    while (i <= heltall.length-1)
      {
	// If number is negative, add 1 to counter
	// and change the number to the array position
	if (heltall[i] < 0)
	  {
	    counter += 1;
	    heltall[i] = i;
	  }

	i += 1;
      }
    // Print number of negatives to screen
    System.out.println(counter);

    // Print array elements in string representation
    System.out.println(Arrays.toString(heltall));
  }
}
