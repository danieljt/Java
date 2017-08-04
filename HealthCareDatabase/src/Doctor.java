
public class Doctor implements Comparable<Doctor>{
	private int ID;
	protected String firstName;
	protected String lastName;
	protected Queue<Prescription> prescriptionList;
	
	public Doctor(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
		prescriptionList = new Queue<Prescription>();
	}
	
	/**
	 * Method compares the name of this doctor with another, and returns
	 * an int determining if this doctor is alphabetically larger or
	 * smaller.
	 * 
	 * @param Doctor to be compared to.
	 * @return < 0 if smaller, 0 if equal, > 0 if larger
	 */
	public int compareTo(Doctor doctor){
		return getName().compareTo(doctor.getName());
	}
	
	/**
	 * Add prescription to the list
	 * @param prescription
	 */
	public void addPrescription(Prescription prescription){
		prescriptionList.add(prescription);
	}
	
	/**
	 * Get the doctors prescription list
	 * @return prescription list
	 */
	public Queue<Prescription> getPrescriptions(){
		return prescriptionList;
	}
	
	/**
	 * Returns the full name of the doctor
	 * @return first name and second name
	 */
	public String getName(){
		return firstName + " " + lastName;
	}
}
