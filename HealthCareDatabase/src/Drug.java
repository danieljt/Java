/**
 * This class defines a general drug without further 
 * specifications
 * @author Daniel James Tarplett
 *
 */
public class Drug{
	public int ID;
	public String name;
	public double price;
	public double activeSubstance;
	
	public Drug(String name, double price, double activeSubstance){
		this.name = name;
		this.price = price;
		this.activeSubstance = activeSubstance;
	}
	
	/**
	 * Method returns the ID of the drug
	 * @return ID 
	 */
	public int getID(){
		return ID;
	}
	
	/**
	 * Method returns the name of the drug
	 * @return name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Method returns the price of the drug
	 * @return price
	 */
	public double getPrice(){
		return price;
	}
	
	/**
	 * Method returns the active substance in the drug
	 * @return activeSubstance
	 */
	public double getActiveSubstance(){
		return activeSubstance;
	}
}
