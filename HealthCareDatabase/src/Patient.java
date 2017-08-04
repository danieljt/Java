/**
 * Class defines a patient with all necessary information.
 * @author Daniel James Tarplett
 *
 */
public class Patient {
	private int ID;
	private long birthNumber;
	private String firstName;
	private String lastName;
	private String address;
	private int postCode;
	private Stack<Prescription> prescriptions;
	
	public Patient(long birthNumber, String firstName, String lastName,
			String address, int postCode){
		this.birthNumber = birthNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.postCode = postCode;
		prescriptions = new Stack<Prescription>();		
	}
	
	/**
	 * Get ID of the patient 
	 * @return ID
	 */
	public int getID(){
		return ID;
	}
	
	/**
	 * Get birth number of patient
	 * @return birth number
	 */
	public long getBirthNumber(){
		return birthNumber;
	}
	/**
	 * Get full name of patient 
	 * @return full name
	 */
	public String getName(){
		return firstName + " " + lastName;
	}
	
	/**
	 * Get address of patient
	 * @return
	 */
	public String getAdress(){
		return address;
	}
	
	/**
	 * Get post code of patient
	 * @return post code
	 */
	public int getPostCode(){
		return postCode;
	}
	
	/**
	 * Get patients list of prescriptions
	 * @return prescription list
	 */
	public Stack<Prescription> getPrescriptions(){
		return prescriptions;
	}

}
