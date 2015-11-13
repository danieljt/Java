public class Kjorminoppgave
{
  public static void main(String[] args)
  {
    // Define new wage calculator
    MinOppgave5 lonn = new MinOppgave5();

    // Add working hours
    lonn.work(10);

    // Check that hours are correctly registered
    lonn.printworked();

    // Add work and check that overtime is registered
    lonn.work(10);
    lonn.work(10);
    lonn.work(5);
    lonn.work(5);
    lonn.printworked();

    // Add more overtime and check that it is registered
    lonn.work(4);
    lonn.printworked();

    // Add work that exceeds the day limit
    lonn.work(11);

    // Add work that exceeds the weeklimit
    lonn.work(8);
  }
}
