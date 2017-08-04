import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class DVDAdministrasjon{
	public static void main(String[] args) throws Exception {
		HashMap<String, Person> nameList = new HashMap<>();
		readArchive(nameList);
		menu(nameList);
		writeArchive(nameList);
	}

	/**
     Method for displaying the interactive menu session. The method gives 
     a number of choices to the user and applies the information
     to the archive
	*/
	static void menu(HashMap<String, Person> nameList){
		Scanner input = new Scanner(System.in);
		
		// Define the choice variable
		int choice;

		// Make the choice, update the classes.
		do{
			// Display menu
			System.out.println("------------------------------");
			System.out.println("MENU FOR DVD ADMINISTRATION");
			System.out.println("------------------------------");
			System.out.println();
			System.out.println("PLEASE CHOOSE AN ACTION:");
			System.out.println();
			System.out.println("1: Register a new Person");
			System.out.println("2: Buy film");
			System.out.println("3: Borrow film");
			System.out.println("4: show");
			System.out.println("5: Overview");
			System.out.println("6: Return film");
			System.out.println("7: End program");
			System.out.println("------------------------------");
			System.out.println();

			// Test that the input is integer
			while(true){
				System.out.print("Make your choice: ");
				try{		
					choice = Integer.parseInt(input.nextLine());
					break;
				}
				catch(NumberFormatException ignore){
					System.out.println("Illegal input!");
					System.out.println("Input must be an integer");
				}
			}
	
			// Add person
			if(choice == 1){
				// Give the name of the person
				System.out.print("Name of the person: ");
				String name = input.nextLine();
				Person registered = nameList.get(name);

				// Check if person is registered, add if not
				if(registered == null){
					nameList.put(name, new Person(name));
				}	
	    
				else{
					System.out.println(registered.name() + " is already registered");
				}
				System.out.println();
			}

			// Register a purchase
			else if(choice == 2){
				// Read the name and check if person is registered
				System.out.print("Name of the buyer: ");
				String name = input.nextLine();
				Person buyer = nameList.get(name);
				if(buyer == null){
					System.out.println(name + " is not registered!");
				}
	    
				else{
					// Buy the DVD if the person doesn't have it
					System.out.print("Input title of DVD: ");
					String tittel = input.nextLine();
					DVD bought = new DVD(tittel, buyer);
					buyer.buy(bought);
				}
				System.out.println();
			}

			else if(choice == 3){
				// Read the name of the borrower
				System.out.print("Name of the person borrowing the DVD: ");
				String name1 = input.nextLine();
				 Person borrower = nameList.get(name1);

				 // Check if lender exists
				 if(borrower == null){
					 System.out.println(name1 + " is not registered!");
				 }
				 else{
					 // Read the name of the person lending
					 System.out.print("Name of the person lending out the DVD: ");
					 String name2 = input.nextLine();
					 Person lender = nameList.get(name2);

					 // Check if the person lending exists
					 if(lender == null){
						 System.out.println(name2 + " is not registered!");
					 }
	    	
					 else if(lender == borrower){
						 System.out.println(name1 + " cannot lend the dvd to him/herself!");
					 }
	    	
					 else{
						 // Attempt to finish the loan
						 System.out.print("Title of the DVD: ");
						 String title = input.nextLine();
						 lender.lend(title, borrower);
				 	}
				 }
				 System.out.println();
			}

			else if(choice == 4){
				// read the name
				System.out.print("Name of the person(* for all): ");
				String showPerson = input.nextLine();
	    
				// Print all persons overviews
				if(showPerson.equals("*")){
					for(String s : nameList.keySet()){
						Person currentPerson = nameList.get(s);
						currentPerson.overview();
					}
				}
	    
				else{
					// Check if person exists
					Person currentPerson = nameList.get(showPerson);
    				if(currentPerson == null){
    				System.out.println(showPerson + " is not registered!");
    				}
    				else{
    					// print persons overview
    					currentPerson.overview();
    				}
				}
				System.out.println();
			}
	
			// Print all persons statistics
			else if(choice == 5){
				for(String s : nameList.keySet()){
					Person currentPerson = nameList.get(s);
					currentPerson.statistics();
					System.out.println();
				}
				System.out.println();
			}

			else if(choice == 6){
				System.out.println("Name the person returning the DVD: ");
				String name1 = input.nextLine();
				Person borrower = nameList.get(name1);
				if(borrower == null){
					System.out.println(name1 + " is not registered!");
				}
				else{
					System.out.println("Title of the DVD: ");
					String tittel = input.nextLine();
					borrower.giveBack(tittel);
				}
				System.out.println();
			}
	
			else if(choice == 7){
				System.out.println("ENDING PROGRAM");
			}
	
    	}while(choice != 7);
		
		input.close();
  	}

  	/**
     Method for reading the archive file, the method stores the names
     in the HashMap navneliste and ads data about each persons loaned
     DVD-s. 
  	*/
  	static void readArchive(HashMap<String, Person> nameList) throws Exception{
  		String filename = "dvdarchive.txt";
  		File file = new File(filename);
  		if(file.exists() == false){
  			return;
  		}
  		Scanner reader = new Scanner(file);
    
  		// Read the file line by line and add names
  		// to the archive. Stop when '-' is reached
  		while(reader.hasNextLine()){
  			String name = reader.nextLine();
  			if(name.startsWith("-")){
  				break;
  			}
  			else{
  				nameList.put(name, new Person(name));
  			}	
  		}
    
  		// Add DVDs to persons
  		String init = reader.nextLine();
  		Person current = nameList.get(init);

  		while(reader.hasNextLine()){
  			String line = reader.nextLine();

  			// If line is "-", update the current person
  			if(line.equals("-")){
  				current = nameList.get(reader.nextLine());
  			}

  			// If line starts with "*", update loan and borrowing lists
  			else if(line.startsWith("*")){
  				// get title and create new DVD
  				String title = line.substring(1, line.length());
  				DVD newDVD = new DVD(title, current);
  				current.buy(newDVD);

  				// Get the lender and register the loan	    
  				Person borrower = nameList.get(reader.nextLine());
  				current.lend(title, borrower);
  			}

  			// Add DVD to current person
  			else{
  				DVD denne = new DVD(line, current);
  				current.buy(denne);
  			}
  		}
  		reader.close();
  }

  	/**
     	Method for writing changes done in the archive to the archive file
  	*/
  	static void writeArchive(HashMap<String, Person> nameList) throws Exception{
  		PrintWriter out = new PrintWriter("dvdarchive.txt");

  		// Write all names to file
  		for(String s : nameList.keySet()){
  			Person currentPerson = nameList.get(s);
  			out.println(currentPerson.name());
  		}

  		// Write owned DVD-s to file
  		for(String s : nameList.keySet()){
  			Person person = nameList.get(s);
  			out.println("-");
  			out.println(s);

  			// Write owned DVD-s to file
  			HashMap<String, DVD> archive = person.archive();
  			for(String owned : archive.keySet()){
  				DVD dvd = archive.get(owned);
  				Person lender = dvd.owner();
  				if(lender == null){
  					out.println(dvd.title());
  				}
  			} 

  			// Write dvds that are lended out with name of lender
  			HashMap<String, DVD> lended = person.lended();
  			for(String title : lended.keySet()){
  				DVD dvd = lended.get(title);
  				Person lender = dvd.owner();
  				if(lender != null){
  					out.println("*" + dvd.title());
  					out.println(lender.name());
  				}
  			}
  		}
    out.close();
  	}
}
