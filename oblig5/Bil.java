public class Bil
{
  // Anta at bensinforbruken, tankstorrelsen
  // og maksimal distanse er konstant
  final double bensinforbruk;
  final double tankstorrelse;
  final double maksdistanse;

  // Kilometerstanden til bilen og bensinen.
  private int kilometerstand;
  private double bensin;

  public Bil()
  {
    // Anta nybil
    kilometerstand = 0;
    bensinforbruk = 0.8;
    tankstorrelse = 45;

    // Start med full tank
    bensin = 45;
    
    // Regn ut maksimal kjorelengde med full tank
    maksdistanse = tankstorrelse/(bensinforbruk*0.1);
  }

  public void kjorTur(int km)
  {
    // Bensinforbruk pa naverende tur
    double usage = bensinforbruk*km*0.1;

    // Sjekk om bensinforbruken er storre enn tankstorrelsen
    // Gi beskjed hvis turen er for lang og si ifra. Ellers, 
    // ta turen, regn ut forbruket og legg til kilometerstanden.
    if (bensin - usage < 0)
      {
	System.out.println();
	System.out.println("Du har ikke nok bensin til denne turen.");
	System.out.println("Kjor en kortere tur, eller fyll mer bensin.");
	System.out.println("Maksimal kjorelengde med naverende bensin er: ");
	System.out.println(hentMaksDistanse() + " km.");
	System.out.println("Maksimal kjorelengde for denne bilen med full ");
	System.out.println("tank er :" + maksdistanse + "km.");
	System.out.println();
      }
    else
      {
	kilometerstand = kilometerstand + km;
	bensin = bensin - usage;
      }
  }

  public void fyllTank(double liter)
  {
    bensin = bensin + liter;
  }

  public double hentMaksDistanse()
  {
    return bensin/(bensinforbruk*0.1);
  }
  
  public int hentKilometerstand()
  {
    return kilometerstand;
  }
}
