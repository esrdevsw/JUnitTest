package test.ie.atu.dip;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import main.ie.atu.dip.Driver;
import main.ie.atu.dip.InsuranceQuote;

class InsuranceQuoteTest {

	private static InsuranceQuote insuranceQuote;
	@SuppressWarnings("unused")
	private static Driver driver;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Should Print Before All Tests");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Instantiating Insurance Quote before the Test Execution");
		insuranceQuote = new InsuranceQuote();
		driver = new Driver();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("Should return false for nAccident >= 6  ")
	final void testGetQuote_noInsurance() throws Exception {
		int age = 24;
		int nAccident = 6;
		assertEquals(false, insuranceQuote.getQuote(age, nAccident));
	}

	@Test
	@DisplayName("Should return true for nAccident < 6  ")
	final void testGetQuote_ok() throws Exception {
		int age = 24;
		int nAccident = 5;
		assertEquals(true, insuranceQuote.getQuote(age, nAccident));
	}

	@Test
	@DisplayName("Should return Insurance cost = BASIC_INSURANCE (500) ")
	final void testGetQuote_basic() throws Exception {
		int age = 25;
		int nAccident = 0;
		final int BasicInsurance_EXPECTED = 500;
		insuranceQuote.getQuote(age, nAccident);
		assertEquals(BasicInsurance_EXPECTED, insuranceQuote.totalAmount);
	}

	@Test
	@DisplayName("Should Not get quote when age is zero (0)")
	public void shouldThrowRuntimeExceptionWhenAgeIsZero() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			int age = 0;
			int nAccident = 0;
			System.out.println(">>> " + insuranceQuote.getQuote(age, nAccident));
			insuranceQuote.getQuote(age, nAccident);

		});
	}

	@Test
	@DisplayName("Should Not get quote when nAccident is < 0")
	public void shouldThrowRuntimeExceptionWhennAccident() {
		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			int age = 25;
			int nAccident = -1;
			System.out.println(">>> " + insuranceQuote.getQuote(age, nAccident));
			insuranceQuote.getQuote(age, nAccident);

		});
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
