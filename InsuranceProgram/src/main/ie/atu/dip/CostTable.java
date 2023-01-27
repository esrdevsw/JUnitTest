package main.ie.atu.dip;

public class CostTable {
	private static final int BASIC_INSURANCE = 500;
	private static final int SURCHARGE = 100; // under 25 years
	private static final int[] ADDITIONAL_SURCHARGE_ARRAY = {50, 125, 225, 375, 575};
	/**
	 * @return the basicInsurance
	 */
	public static int getBasicInsurance() {
		return BASIC_INSURANCE;
	}
	/**
	 * @return the surcharge
	 */
	public static int getSurcharge() {
		return SURCHARGE;
	}
	/**
	 * @return the additionalSurchargeArray
	 */
	public static int[] getAdditionalSurchargeArray() {
		return ADDITIONAL_SURCHARGE_ARRAY;
	}

}
