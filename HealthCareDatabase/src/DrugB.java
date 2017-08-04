/**
 * The class defines a type B drug, also known as a strongly
 * addictive drug. The class inherits from the superclass
 * Drug.
 * 
 * @author Daniel James Tarplett
 *
 */
public class DrugB extends Drug {
	public int strength;
	
	public DrugB(String name, double price, 
			double activeSubstance, int strength){
		super(name, price, activeSubstance);
		this.strength = strength;
	}
	
	/**
	 * Method returns the addictive strength of the drug
	 * @return Addictive strength
	 */
	public int getAddictiveStrength(){
		return strength;
	}
}
