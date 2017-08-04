/**
 * The class defines a type A drug, or a drug with strong 
 * narcotic substances. The class inherits from the 
 * superclass drug.
 * @author Daniel James Tarplett
 *
 */
public class DrugA extends Drug {
	public int strength;
	
	public DrugA(String name, double price, 
			double activeSubstance, int strength){
		super(name, price, activeSubstance);
		this.strength = strength;		
	}
	
	/**
	 * Method returns the narcotic strength of the drug
	 * @return Narcotic strength
	 */
	public int getNarcoticStrength(){
		return strength;
	}
}
