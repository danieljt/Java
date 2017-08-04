/**
 * Class defines a prescription
 * @author Daniel James Tarplett
 *
 */
public class Prescription {
	public int ID;
	public Drug drug;
	public Doctor doctor;
	public Patient patient;
	public int uses;

	public Prescription(Drug drug, Doctor doctor, Patient patient, int uses){
		this.drug = drug;
		this.doctor = doctor;
		this.patient = patient;
		this.uses = uses;
	}
	
	/**
	 * Get the prescriptions ID
	 * @return ID
	 */
	public int getID(){
		return ID;
	}
	
	/**
	 * Get the drug 
	 * @return drug
	 */
	public Drug getDrug(){
		return drug;
	}
	
	/**
	 * returns the doctor 
	 * @return doctor
	 */
	public Doctor getDoctor(){
		return doctor;
	}
	
	/**
	 * Returns the patient
	 * @return paient
	 */
	public Patient getPatient(){
		return patient;
	}
	
	/**
	 * Returns the available uses of the prescription
	 * @return
	 */
	public int getUses(){
		return uses;
	}
	
	/**
	 * Uses the prescription once, then reduces the uses by one
	 * @return true if the prescription is used, false if not */
	public boolean use(){
		if(uses > 0){
			uses--;
			return true;
		}
		else{
			return false;
		}
	}
}
