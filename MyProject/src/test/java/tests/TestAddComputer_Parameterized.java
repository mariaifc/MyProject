package tests;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.AddAComputerPage;
import pages.ComputersPage;

/**
 * This Parameterized class implements parameterized tests. It was used in order
 * to test the creating operation by using the Allpairs method. This techine was used in order to increase the test coverage.
 * 
 * @author mariaisabel
 * @version 1.0
 * @
 */

@RunWith(Parameterized.class)
public class TestAddComputer_Parameterized {

	String name;
	String intDate;
	String disDate;
	String company;

	WebDriver mDriver;

	AddAComputerPage mAddAcomputerPage;
	ComputersPage mComputersPage;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");

		mDriver = new ChromeDriver();
		mAddAcomputerPage = new AddAComputerPage(mDriver);
		mComputersPage = new ComputersPage(mDriver);
		mDriver.manage().window().maximize();
	}

	public TestAddComputer_Parameterized(String name, String intDate, String disDate, String company) {
		this.name = name;
		this.intDate = intDate;
		this.disDate = disDate;
		this.company = company;
	}

	@Parameters(name = "{0}")
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { 
			{ "1_Çöómp_Pâ@r$m£µ", "2018-01-10", "", "RCA" }, 
			{ "2_Comp_Param", "", "2018-01-10", "Apple Inc." },
			{ "3_Çöómp_Pâ@r$m£µ", "", "2018-01-10", "-- Choose a company --" },
			{ "4_Comp_Param", "", "2018-01-10", "Thinking Machines" },
			{ "5_Çöómp Pâ@r$m£µ", "", "2018-01-10", "-- Choose a company --" },
			{ "1_Computer", "2012-12-01", "2013-01-01", "Apple Inc." },
			};
		return Arrays.asList(data);
	}

	@Test
	public void addAllPairsComputersValidFields() throws Exception {
		mComputersPage.nativateToAddAcomputerPage();
		mAddAcomputerPage.addAComputer(name, intDate, disDate, company);

		String actualResult = mComputersPage.getAlertMessage();
		String expectedResult = "Done! Computer " + name + " has been created";
		Assert.assertEquals("The computer was sussessfully created", expectedResult, actualResult);
	}

	@After
	public void tearDown() {
		mDriver.close();
	}

}
