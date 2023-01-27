package main.ie.atu.dip;

import java.util.Scanner;

/*
 * 
 * Evaluate the insurance cost based on driver age and
 * accidents number
 *
 */
public class InsuranceQuote {

	private Driver driver = new Driver();
	private final Scanner s;
	public boolean insApproved;
	public int totalAmount = 0;

	public InsuranceQuote() {
		s = new Scanner(System.in); // Creates a new instance of a scanner, s.
	}

	// Input of the driver age
	public int setDriverAge() throws Exception{
		System.out.print("Enter your age: ");
		int age = -1;
		try {
			age = Integer.parseInt(s.next());
			driver.setAge(age);
		} catch (NumberFormatException nfe) {
			System.out.println("[ERROR] NumberFormat Exception: invalid age input");
			System.out.println(nfe.getMessage());
			return age;
		}
		return age;
	}

	// Input of the number of accidents
	public int setDriverAccidents() throws Exception{
		System.out.print("\nHow many accidents did you have? ");
		int nAccidents = -1;
		try {
			nAccidents = Integer.parseInt(s.next());
			driver.setAccidentsNumber(nAccidents);
		} catch (NumberFormatException nfe) {
			System.out.println("[ERROR] NumberFormat Exception: invalid set Accidents Number input");
			System.out.println(nfe.getMessage());
			return nAccidents;
		}
		return nAccidents;
	}

	//calls the methods for assessing the total amount of insurance
	public boolean getQuote(int age, int nAccidents) throws Exception{
		
		System.out.println(age+" | "+ nAccidents);
		ageGroup(age, nAccidents);
		insApproved = driver.isApprove();
		totalAmount = driver.getInsCost();
		return insApproved;
	}

	//Assess the value of insurance by age group
	private boolean ageGroup(int driverAge, int nAccident) throws Exception{
		if (driverAge <= 0) {
		    throw new IllegalArgumentException();
		}
		if (nAccident >= 6) {
			System.out.println(":No_insurance");
			driver.setApprove(false);

			return false;
		}
		driver.setApprove(true);
		totalAmount = surchargeForAccident(nAccident);
		totalAmount += CostTable.getBasicInsurance();
		if (driverAge < 25) {
			totalAmount += CostTable.getSurcharge();
		}
		System.out.println("\ntotal amount to pay: €" + totalAmount);
		
		driver.setInsCost(totalAmount); 
		return true;

	}

	//Assess the value of insurance by accident number
	private int surchargeForAccident(int nAccident) throws Exception{
		int insCost = 0;
		if (nAccident == 0) {
			System.out.println("No additional surcharge");
		} else {
			System.out.println(
					"Additional surcharge for accident: " + CostTable.getAdditionalSurchargeArray()[nAccident - 1]);
			insCost = CostTable.getAdditionalSurchargeArray()[nAccident - 1];
		}
		return insCost;
	}

}