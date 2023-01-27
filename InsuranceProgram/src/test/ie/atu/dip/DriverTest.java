/**
 * 
 */
package test.ie.atu.dip;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.ie.atu.dip.CostTable;
import main.ie.atu.dip.Driver;

/**
 * @author edivagner
 *
 */
class DriverTest {

	private Driver driver;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Should Print Before All Tests");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("Should be executed at the end of the Test");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Instantiating Driver");
		driver = new Driver();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Should Execute After Each Test");
	}

	/**
	 * test that a constructor does its job Age = 22 accident = 0
	 */
	@Test
	@DisplayName("should create correct driver two param")
	final void testConstructorDriverTwoParam() {
		driver = new Driver(22, 0);
		assertEquals(22, driver.getAge());
		assertEquals(0, driver.getAccidentsNumber());
	}

	/**
	 * test that a constructor does its job Age = 21 accident = 5
	 */
	@Test
	@DisplayName("should create correct driver")
	final void testConstructorDriver() {
		driver.setAge(21);
		driver.setAccidentsNumber(5);
		assertEquals(21, driver.getAge());
		assertEquals(5, driver.getAccidentsNumber());
	}

	@Test
	@DisplayName("should create correct driver")
	final void testConstructorDriverOlder() {
		driver.setAge(25);
		driver.setAccidentsNumber(5);
		assertEquals(25, driver.getAge());
		assertEquals(5, driver.getAccidentsNumber());
	}

	@Test
	@DisplayName("should output 0")
	final void testGetInsCost() {
		final int InsCost_ACTUAL = 0;
		final int InsCost_EXPECTED = driver.getInsCost();
		assertEquals(InsCost_EXPECTED, InsCost_ACTUAL);
	}

	@Test
	@DisplayName("should output the Basic Insurance = 500")
	final void testSetInsCost_table() {
		driver.setInsCost(CostTable.getBasicInsurance());
		final int InsCost_ACTUAL_Table = driver.getInsCost();
		final int EXPECTED_table = 500;
		assertEquals(EXPECTED_table, InsCost_ACTUAL_Table);
	}

	@Test
	@DisplayName("should set approve ins")
	final void testSetApprove() {
		driver.setApprove(false);
		assertEquals(false, driver.isApprove());
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
