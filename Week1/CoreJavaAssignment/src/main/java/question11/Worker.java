/**
 * A worker can take money from the register to give change to a customer
 */
package question11;

import question11.helper.Register;

/**
 * @author Deonta Kilpatrick
 *
 */
public class Worker {

private Register access = new Register();
	
	public void takeFromRegister(float amount) {
		//the new amount in register is the previous amount-the amount taken out
		System.out.println("Your change is " + amount);
		access.setChangeNeeded(amount);
		access.setInRegister(access.getInRegister() - access.getChangeNeeded());
	}
}
