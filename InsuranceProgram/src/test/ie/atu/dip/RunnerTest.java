package test.ie.atu.dip;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SelectClasses;

// Combine test suite of classes, then run multiple test cases as a single unit
@Suite
@SelectClasses({ CostTableTest.class, DriverTest.class, InsuranceQuoteTest.class, InsuranceProgramTest.class })
class RunnerTest {

}
