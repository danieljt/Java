public class Oblig6
{
  public static void main(String[] args) throws Exception
  {
    // Read book
    Ordliste bok = new Ordliste();
    bok.lesBok("scarlet.text");

    System.out.println("----------------------------------------");

    // Get number of words and print
    int antall = bok.antallOrd();
    System.out.println("Number of different words: " + antall);
    
    // Get the frequency of the word holmes
    int forekomst1 = bok.antallForekomster("Holmes");
    System.out.println("The frequency of holmes: " + forekomst1);

    // Get the frequency for the word elementary
    int forekomst2 = bok.antallForekomster("elementary");
    System.out.println("The frequency of elementary: " + forekomst2);
    
    // Get the most frequent word
    Ord flest = bok.vanligste();
    System.out.println("The most frequent word: " + flest.toString());
    System.out.println();
    
    // Get the 10 most frequent words and their frequencies
    Ord[] defleste = bok.alleVanligste(10);
    for(Ord ord : defleste) 
      {
    	System.out.printf("%-20s %4d \n",ord.toString(), ord.hentAntall());
      }
    
  }
}
