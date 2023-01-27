package test.ie.atu.dip;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import main.ie.atu.dip.InsuranceProgram;

class InsuranceProgramTest {

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	private static InsuranceProgram insP = new InsuranceProgram();

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Instantiating InsuranceQuote before the Test Execution");
	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Should be executed at the end of the Test");
	}

	@BeforeEach
	public void setUp() throws Exception {
		System.out.println("Instantiating Insurance Quote");
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@BeforeEach
	public void tearDown() {
		System.setOut(standardOut);
	}

	@SuppressWarnings("static-access")
	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	@DisplayName("main with input age < 25 and read the total amount")
	public void givenSystemOutRedirection_whenInvokePrintln_thenOutputCaptorSuccess() throws Exception {
		// string data simulate scanner age = 22 and accidents = 0
		String data = "22\r\n 0\r\n";

		System.setIn(new ByteArrayInputStream(data.getBytes()));
		insP.main(null);
		String expect = "600";
		String output = outputStreamCaptor.toString().substring(outputStreamCaptor.toString().lastIndexOf("€") + 1)
				.replaceAll("\\s", "");

		assertEquals(expect, output);
	}

	@SuppressWarnings("static-access")
	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	@DisplayName("main with input age > 25 and read the total amount")
	public void givenSystemOutRedirection_whenInvokePrintln_thenOutputCaptorSuccess2() throws Exception {
		// string data simulate scanner age = 26 and accidents = 0
		String data = "26\r\n 0\r\n";

		System.setIn(new ByteArrayInputStream(data.getBytes()));
		insP.main(null);
		String expect = "500";
		String output = outputStreamCaptor.toString().substring(outputStreamCaptor.toString().lastIndexOf("€") + 1)
				.replaceAll("\\s", "");

		assertEquals(expect, output);
	}

	@SuppressWarnings("static-access")
	@ParameterizedTest
	@CsvSource({ "24,0,600", "24,1,650", "24,2,725", "24,3,825", "24,4,975", "24,5,1175", "25,0,500", "25,1,550",
			"25,2,625", "25,3,725", "25,4,875", "25,5,1075" })
	@DisplayName("Simulation of multiple insurance values with age and number of accidents")
	public void PatareizedTestTotalAmount(String age, String nAccident, String TotalOut) throws Exception {
		// string data simulate scanner age and accidents
		String data = age + "\r\n " + nAccident + "\r\n";

		System.setIn(new ByteArrayInputStream(data.getBytes()));
		insP.main(null);
		String expect = TotalOut;
		String output = outputStreamCaptor.toString().substring(outputStreamCaptor.toString().lastIndexOf("€") + 1)
				.replaceAll("\\s", "");

		assertEquals(expect, output);
	}

	@SuppressWarnings("static-access")
	@ParameterizedTest
	@CsvSource({ "24,6", "24,7", "25,6", "25,7" })
	@DisplayName("insurance is not approved when has 6 or more accidents")
	public void noApprovedInssurance(String age, String nAccident) throws Exception {
		// string data simulate scanner age and accidents
		String data = age + "\r\n " + nAccident + "\r\n";

		System.setIn(new ByteArrayInputStream(data.getBytes()));
		insP.main(null);
		String expect = "No_insurance";
		String output = outputStreamCaptor.toString().substring(outputStreamCaptor.toString().lastIndexOf(":") + 1)
				.replaceAll("\\s", "");

		assertEquals(expect, output);
	}

	@SuppressWarnings("static-access")
	@Test
	@DisplayName("should Throw IllegalArgumentException-Age")
	public void shouldThrowIllegalArgumentException_Age() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			String age = "Twenty";
			String nAccident = "0";
			String data = age + "\r\n " + nAccident + "\r\n";

			System.setIn(new ByteArrayInputStream(data.getBytes()));
			insP.main(null);
		});
	}

	@SuppressWarnings("static-access")
	@Test
	@DisplayName("should ThrowArray IndexOutOfBoundsException-nAccident")
	public void shouldThrowArrayIndexOutOfBoundsException_nAccident() {
		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			String age = "20";
			String nAccident = "zero";
			String data = age + "\r\n " + nAccident + "\r\n";

			System.setIn(new ByteArrayInputStream(data.getBytes()));
			insP.main(null);
		});
	}

	@AfterAll
	static void AfterClass() throws Exception {
		System.out.println("Should be executed at the end of the Test");
	}

	@AfterEach
	void AfterEachtearDown() throws Exception {
		System.out.println("Should Execute After Each Test");
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
