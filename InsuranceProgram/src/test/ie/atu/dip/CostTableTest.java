package test.ie.atu.dip;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.ie.atu.dip.CostTable;

class CostTableTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Should Print Before All Tests");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Instantiating Driver");
		@SuppressWarnings("unused")
		CostTable costTable = new CostTable();
	}

	@Test
	@DisplayName("Basic Insurance values is integer")
	final void testGetBasicInsurance() {
		assertTrue(Integer.class.isInstance(CostTable.getBasicInsurance()));
	}

	@Test
	@DisplayName("Basic Insurance values is correct")
	final void testGetBasicInsuranceValue() {
		final int BasicInsurance_ACTUAL = CostTable.getBasicInsurance();
		final int BasicInsurance_EXPECTED = 500;
		assertEquals(BasicInsurance_EXPECTED, BasicInsurance_ACTUAL);
	}

	@Test
	@DisplayName("Surcharge values is correct")
	final void testGetSurcharge() {
		final int Surcharge_ACTUAL = CostTable.getSurcharge();
		final int Surcharge_EXPECTED = 100;
		assertEquals(Surcharge_EXPECTED, Surcharge_ACTUAL);
	}

	@Test
	@DisplayName("Should contain the Additional Surcharge values")
	void testGetAdditionalSurchargeArray() {
		final int[] AccidentSurcharge_ACTUAL = CostTable.getAdditionalSurchargeArray();
		final int[] AccidentSurcharge_EXPECTED = new int[] { 50, 125, 225, 375, 575 };
		assertArrayEquals(AccidentSurcharge_EXPECTED, AccidentSurcharge_ACTUAL);

	}

	@AfterAll
	public static void cleanUp() {
		System.out.println("After All cleanUp() method called");
	}

	@AfterEach
	public void cleanUpEach() {
		System.out.println("After Each cleanUpEach() method called");
	}

}
