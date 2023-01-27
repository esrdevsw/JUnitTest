package main.ie.atu.dip;

public class Driver {
	private int age;
	private int accidentsNumber;
	private boolean approve;
	private int insCost;

	/**
	 * create a Driver
	 */
	public Driver() {
		super();
	}

	/**
	 * Set a new Driver
	 * @param age
	 * @param accidentsNumber
	 */
	public Driver(int age, int accidentsNumber) {
		this.age = age;
		this.accidentsNumber = accidentsNumber;
	}
	
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		if (age < 25) {
			System.out.println("\nAdditional surcharge " + CostTable.getSurcharge());
		}
		this.age = age;
	}

	/**
	 * @return the accidentsNumber
	 */
	public int getAccidentsNumber() {
		return accidentsNumber;
	}

	/**
	 * @param accidentsNumber the accidentsNumber to set
	 */
	public void setAccidentsNumber(int accidentsNumber) {
		this.accidentsNumber = accidentsNumber;
	}

	/**
	 * @return the approve
	 */
	public boolean isApprove() {
		return approve;
	}

	/**
	 * @param aprove the aprove to set
	 */
	public void setApprove(boolean aprove) {
		this.approve = aprove;
	}

	/**
	 * @return the insCost
	 */
	public int getInsCost() {
		return insCost;
	}

	/**
	 * @param insCost the insCost to set
	 */
	public void setInsCost(int insCost) {
		
		this.insCost = insCost;
	}
	
}
