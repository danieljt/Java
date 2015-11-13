import java.util.Arrays;
import java.util.Scanner;
/*
Program for doing some vecor arithmetics for arrays.
Computes the sum, the scalar product and the 
cross product of two arrays. Prints the result on the terminal
 */
class MinOppgave3
{
  public static void main(String[] args)
  { 
    // define 3D vectors
    int N = 3;
    double[] avector = new double[N];
    double[] bvector = new double[N];
    
    // Give arrays values
    for (int i=0; i < avector.length; i++)
      {
	avector[i] = 1 + i;
	bvector[i] = 3 - 3*i;
      }
    
    // Adding the arrays
    double[] sum = addarray(avector, bvector);

    // Scalar product
    double scalar = scalarproduct(avector, bvector);

    // Cross product
    double[] cross = crossproduct(avector, bvector);

    // Print results
    System.out.println(Arrays.toString(sum));
    System.out.println(scalar);
    System.out.println(Arrays.toString(cross));
  }
  /**
     Method for adding two arrays. returns the sum
     of each corresponding component in the arrays.
     @param vec1 First vector
     @param vec2 Second vector
     @return sum The sum of each corresponding component
   */
  static double[] addarray(double[] vec1, double[] vec2)
  {
    double[] add = new double[vec1.length];
    for (int i=0; i < vec1.length; i++)
      {
	add[i] = vec1[i] + vec2[i];
      } 
    return add;
  }

  /**
     Method for calculating the scalar product between 
     two arrays. Method returns a scalar
     @param vec1 The first array
     @param vec2 The second array
     @return sum The scalar product
   */
  static double scalarproduct(double[] vec1, double[] vec2)
  {
    double sum = 0;
    for (int i=0; i < vec1.length; i++)
      {
	sum += vec1[i]*vec2[i];
      }
    return sum;
  }

  /**
     Method for calculating the cross product 
     between two arrays. returns a 1x3 array
     @param vec1 First vector
     @param vec2 Second vector
     @return cross The cross product
   */
  static double[] crossproduct(double[] vec1, double[] vec2)
  {
    double[] cross = new double[vec1.length];
    cross[0] = vec1[1]*vec2[2]-vec2[1]*vec1[2];
    cross[1] = -vec1[0]*vec2[2]+vec2[0]*vec1[2];
    cross[2] = vec1[0]*vec2[1]-vec2[0]*vec1[1];
    return cross;
  }
}
