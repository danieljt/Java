class MinOppgave5
{
  private double worked;
  private double pay;
  private double rate;  
  private double overtime;
  final double daylimit;
  final double normalweek;
  final double weeklimit;

  public MinOppgave5()
  {
    // Set the initial pay and worked hours to zero each month 
    worked = 0;
    pay = 0;

    // Pay rate and overtime multiplier
    rate = 200;
    overtime = 1.5;

    // Normal work hours and work hour limits    
    daylimit = 10;
    normalweek = 37.5;
    weeklimit = 50;
  }
  public void work(double hours)
  {
    // Check that the person is not working over legal hours
    // during a shift or during a week. Else, calculate
    // wages and any overtime.
    if (hours > daylimit || worked + hours > weeklimit)
      {
	System.out.println();
	System.out.println("-------------------------");
	System.out.println("Ikke gyldig arbeidstid. maksimal arbeidstid er "+ daylimit);
	System.out.println("timer pa en dag og "+weeklimit+" timer i lopet av en uke");
	System.out.println();
      }
    else if (worked > normalweek)
      {
	pay = pay + hours*overtime*rate;
	worked = worked + hours;
      }
    else if (worked + hours > normalweek)
      {
	double over = worked + hours - normalweek;
	double normal = hours - over;
	pay = pay + over*overtime*rate + normal*rate;
	worked = worked + hours;
      }
    else if (worked + hours < normalweek)
      {
	pay = pay + hours*rate;
	worked = worked + hours;
      }
  }
  public void printworked()
  {
    // Print work statistics to terminal
    System.out.println();
    System.out.println("-------------------------");
    System.out.println("TIMER OG LONN HITTIL");
    System.out.println("-------------------------");
    System.out.println("Timer hittil: "+worked);
    System.out.println("lonn hittil: "+pay);

    // Check for overtime, print to terminal if true
    if (worked > normalweek)
      {
	double over = worked - normalweek;
	double opay = over*overtime*rate;
	System.out.println("Overtidstimer hittil: "+ over);
	System.out.println("Overtidslonn hittil: "+ opay);
      }
  }
  
}
