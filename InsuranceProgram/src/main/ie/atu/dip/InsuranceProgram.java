package main.ie.atu.dip;
/*
 * Programme Name: InsuranceProgram
 * Description:
 * The application is run using the “InsuranceProgram” class.
 * It accomplishes this by starting the "InsuranceQuote" Class,
 * a class that is used to call all the classes required to run and
 * to configure the insurance quote.
 *
 */
public class InsuranceProgram {

	public static void main(String[] args) throws Exception {
/*
 * This is the program's runner. 
 * This calls the class InsuranceQuote
 */
		InsuranceQuote insQuote = new InsuranceQuote();
		int age = insQuote.setDriverAge();
		int nAcc = insQuote.setDriverAccidents();
		insQuote.getQuote(age, nAcc);
	}
}
