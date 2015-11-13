import java.util.Scanner;
/*
Simple program for calculating the parking fee for a parking lot 
with the following prices.
--------------
1 day: 100
3 day: 200
7 day: 400
--------------
If a customer has a firm deal with the company, the program asks
for this and gives a 50% discount.
 */

public class MinOppgave2
{
  public static void main(String[] args)
  {
    Scanner reader = new Scanner(System.in);
      
    // Enter the number of days to park, calculate and print price
    System.out.print("Please enter the number of days you want to park: ");
    int days = reader.nextInt();
    int parkprice = calculatefee(days);
    System.out.println("Your current price for parking is "+ parkprice);

    // Ask for discount and calculate if true
    System.out.println("Do you have a discount card? ");
    System.out.println("Press 1, then enter if yes. ");
    System.out.println("Type another number, then enter if no.");
    System.out.print("Enter your choice: ");
    int discount = reader.nextInt();
 
    // Calculate the discount if chosen, compute the total price
    if (discount == 1)
      {
	int discountprice = discountfee(parkprice);
	System.out.print("Your total price with discount is ");
	System.out.println(discountprice);
      }
    else
      {
	System.out.println("Your total price is " + parkprice);
      }    
  }
  /**
     Computes the parking price for a stay comprising of n days.
     @param days Number of days to park
     @return the price for parking
   */
  public static int calculatefee(int days)
  {
    int weekprice = days/7;
    int weekremainder = days % 7;
    int threedayprice = weekremainder/3;
    int dayprice = weekremainder % 3;
    int price = 400*weekprice + 200*threedayprice + 100*dayprice;
    return price;
  }
  /**
     Computes a 50% discount of the parking price if choosen.
     @param parkprice The current parking price.
     @return the discount price
   */
  public static int discountfee(int parkprice)
  {
    int price = parkprice/2;
    return price;
  }
}
