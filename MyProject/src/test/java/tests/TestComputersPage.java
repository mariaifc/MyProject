package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.AddAComputerPage;
import pages.ComputersPage;
import pages.EditComputerPage;

/**
 * This class performs test the Computers page.
 * 
 * This class has 3 test regarding this page:
 * 
 * - Try to find a computer with a valid name
 * 
 * - Try to find a computer with a invalid name. Make sure the site will show
 * the "No computers found". -
 * 
 * - Display a computer previously created on Computers page.
 * 
 * @author mariaisabel
 * @version 1.0
 */
public class TestComputersPage {
	WebDriver mDriver;

	ComputersPage mComputersPage;
	EditComputerPage mEditComputerPage;
	AddAComputerPage mAddComputerPage;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		mDriver = new ChromeDriver();
		mComputersPage = new ComputersPage(mDriver);
		mEditComputerPage = new EditComputerPage(mDriver);
		mAddComputerPage = new AddAComputerPage(mDriver);
		mDriver.manage().window().maximize();
	}

	@Test
	public void findComputerByAValidName() throws Exception {
		mComputersPage.nativateToAddAcomputerPage();
		mAddComputerPage.addAComputer("1_Computer", "", "", "RCA");
		boolean actualResult = mComputersPage.findAComputerByName("1_Computer");
		Assert.assertTrue("Testing if searching by a valid name, the site show a computer with the target name",
				actualResult);
	}

	@Test
	public void findComputerByAInvalidName() throws Exception {
		mComputersPage.open();
		boolean result = mComputersPage.findAComputerByName("!4#$ˆ5");
		String message = mComputersPage.getPageTitle();
		System.out.println(message);
		boolean actualResult = !result && message.equals("No computers found");
		Assert.assertTrue(
				"Testing if searching by a invalid name, the site does not find any computer and shows the right message",
				actualResult);
	}

	@Test
	public void readComputer() {
		mComputersPage.open();
		mComputersPage.findAndReadComputer("1_Computer");
		String expectedResult = "Edit computer";
		String actualResult = mEditComputerPage.getPageTitle();
		System.out.println(actualResult);
		Assert.assertEquals("Computer was successfuly found and readed", expectedResult, actualResult);
	}

	@After
	public void tearDown() {
		mDriver.close();
	}

}
