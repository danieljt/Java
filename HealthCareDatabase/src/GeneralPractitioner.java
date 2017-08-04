/**
 * Class defines a general practitioner. The class is a subclass of the 
 * superclass doctor, and implements the government contract interface.
 * 
 * @author Daniel James Tarplett
 *
 */
public class GeneralPractitioner extends Doctor implements GovernmentContract{
	private int contractNumber;
	public GeneralPractitioner(String firstName, String lastName, int contractNumber){
		super(firstName, lastName);
		this.contractNumber = contractNumber;
	}
	
	/**
	 * Gets the contract number for the general practitioner
	 * @return contract number
	 */
	public int getContractNumber(){
		return contractNumber;
	}
}
