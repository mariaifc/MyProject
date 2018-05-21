package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.AddAComputerPage;
import pages.ComputersPage;

/**
 * This class performs test the Add a computer page. Here it was developed basic
 * validation, since all tests mentioned on report will be performed by
 * parametrized tests.
 * 
 * @author mariaisabel
 * @version 1.0
 */
public class TestAddAComputerPage_InvalidValues {

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

	@Test
	public void addAComputerWithoutAnyFilledFields() throws Exception {
		mComputersPage.nativateToAddAcomputerPage();
		mAddAcomputerPage.addAComputer("", "", "", "-- Choose a company --");

		String fieldWithError = mAddAcomputerPage.getErrorFieldValue();
		boolean error_message_exists = fieldWithError.contains("Required");
		Assert.assertTrue(error_message_exists);
	}

	@Test
	public void addAComputerWithoutAName() throws Exception {
		mComputersPage.nativateToAddAcomputerPage();
		mAddAcomputerPage.addAComputer("", "2010-01-01", "2013-01-01", "-- Choose a company --");

		String fieldWithError = mAddAcomputerPage.getErrorFieldValue();
		boolean error_message_exists = fieldWithError.contains("Required");
		Assert.assertTrue(error_message_exists);
	}

	@Test
	public void addComputerIntroducedWithInvalidIntroducedDateBoundaries() throws Exception {
		mComputersPage.nativateToAddAcomputerPage();
		mAddAcomputerPage.addAComputer("5_Computer", "2012-13-01", "2013-01-01", "IBM");

		String fieldWithError = mAddAcomputerPage.getErrorFieldValue();
		boolean containsError = fieldWithError.contains("Introduced date");
		Assert.assertTrue(containsError);

	}

	@Test
	public void addComputerDiscontinuedDateBoundaries() throws Exception {
		mComputersPage.nativateToAddAcomputerPage();
		mAddAcomputerPage.addAComputer("5_Computer", "2012-01-01", "2013-00-01", "-- Choose a company --");

		String fieldWithError = mAddAcomputerPage.getErrorFieldValue();
		boolean containsError = fieldWithError.contains("Discontinued date");
		Assert.assertTrue(containsError);

	}

	@Test
	public void addComputerThreeInvalidFieldsValues() throws Exception {
		mComputersPage.nativateToAddAcomputerPage();
		mAddAcomputerPage.addAComputer("", "20120101", "20130001", "RCA");

		int fieldWithError = mAddAcomputerPage.numberOfFieldsWithError();
		System.out.println(fieldWithError);
		Assert.assertEquals(fieldWithError, 3);

	}

	@Test
	public void addComputerInvalidIntroducedDate() throws Exception {
		mComputersPage.nativateToAddAcomputerPage();
		mAddAcomputerPage.addAComputer("£µ1Çömp", "20120132", "", "-- Choose a company --");

		int fieldWithError = mAddAcomputerPage.numberOfFieldsWithError();
		System.out.println(fieldWithError);
		Assert.assertEquals(fieldWithError, 1);

	}

	@After
	public void tearDown() {
		mDriver.close();
	}

}
