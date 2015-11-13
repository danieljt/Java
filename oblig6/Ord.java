public class Ord
{
  // Initialize the word and counter
  private String ord;
  private int antall;

  public Ord(String tekst)
  {
    // Add word, set counter to 1
    ord = tekst;
    antall = 1;
  }

  public String toString()
  {
    // Return the word
    return ord;
  }

  public int hentAntall()
  {
    // Return the counter
    return antall;
  }

  public void oekAntall()
  {
    // Increase counter by 1
    antall = antall + 1;
  }
}
