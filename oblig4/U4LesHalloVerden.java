import java.util.Scanner;
import java.io.File;

public class U4LesHalloVerden {   
  public static void main(String[] args) throws Exception {
    String beskjed;

    String filNavn = "hallo.txt";    
    File minFil = new File(filNavn);
    Scanner minScanner = new Scanner(minFil);

    beskjed = minScanner.nextLine();
    System.out.println( beskjed);
    } 
}