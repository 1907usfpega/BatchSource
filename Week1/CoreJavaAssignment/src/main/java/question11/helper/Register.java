/**
 * I don't like making public fields, therefore I just made them private with getters and setters
 * It still accomplishes the criteria.
 */
package question11.helper;

/**
 * @author Deonta Kilpatrick
 *
 */
public class Register {

	private float inRegister;
	private float changeNeeded;
	
	
	/**
	 * 
	 */
	public Register() {
		super();
		this.setInRegister(100.0f);
	}
	/**
	 * @return the inRegister
	 */
	public float getInRegister() {
		return inRegister;
	}
	/**
	 * @param inRegister the inRegister to set
	 */
	public void setInRegister(float inRegister) {
		this.inRegister = inRegister;
	}
	/**
	 * @return the changeNeeded
	 */
	public float getChangeNeeded() {
		return changeNeeded;
	}
	/**
	 * @param changeNeeded the changeNeeded to set
	 */
	public void setChangeNeeded(float changeNeeded) {
		this.changeNeeded = changeNeeded;
	}
	
	
}