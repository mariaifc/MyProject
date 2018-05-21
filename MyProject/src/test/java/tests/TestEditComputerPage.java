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
 * This class perform test cases for the "Edit Page"
 * @author mariaisabel
 *
 */
public class TestEditComputerPage {

	WebDriver mDriver;

	ComputersPage mComputersPage;
	EditComputerPage mEditComputerPage;
	AddAComputerPage mAddComputerPage;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");

		mDriver = new ChromeDriver();
		mEditComputerPage = new EditComputerPage(mDriver);
		mComputersPage = new ComputersPage(mDriver);
		mAddComputerPage = new AddAComputerPage(mDriver);
		mDriver.manage().window().maximize();
	}

	@Test
	public void deleteComputer() throws Exception {
		mComputersPage.open();
		mComputersPage.clickOnAddButton();
		mAddComputerPage.addAComputer("Computer_To_Be_Deleted", "2015-01-01", "2015-01-01", "RCA");
		String beforeDelete = mComputersPage.getPageTitle();
		System.out.println("Before Deleting: " + beforeDelete);
		mComputersPage.findAndReadComputer("Computer_To_Be_Deleted");
		mEditComputerPage.clickOnDeleteBtn();
		String afterDelete = mComputersPage.getPageTitle();
		System.out.println("After Deleting: " + afterDelete);

		String actualResult = mComputersPage.getAlertMessage();
		System.out.println(actualResult);
		String expectedResult = "Done! Computer has been deleted";
		Assert.assertEquals("The computer was sussessfully deleted", expectedResult, actualResult);

	}

	@Test
	public void editComputerName() throws Exception {
		mComputersPage.open();
		mComputersPage.clickOnAddButton();
		mAddComputerPage.addAComputer("Computer_To_Be_Edited", "2015-01-01", "2015-01-01", "RCA");
		mComputersPage.findAndReadComputer("Computer_To_Be_Edited");
		mEditComputerPage.editName("Computer_To_Be_Edited_2");

		String actualResult = mComputersPage.getAlertMessage();
		System.out.println(actualResult);
		String expectedResult = "Done! Computer Computer_To_Be_Edited_2 has been updated";
		Assert.assertEquals("The computer was sussessfully deleted", expectedResult, actualResult);

	}

	@Test
	public void editComputerIntroducedDate() throws Exception {
		mComputersPage.open();
		mComputersPage.clickOnAddButton();
		mAddComputerPage.addAComputer("Computer_To_Be_Edited", "2015-01-01", "2015-01-01", "RCA");
		mComputersPage.findAndReadComputer("Computer_To_Be_Edited");
		mEditComputerPage.editIntroducedDate("2018-05-05");

		String actualResult = mComputersPage.getAlertMessage();
		System.out.println(actualResult);
		String expectedResult = "Done! Computer Computer_To_Be_Edited has been updated";
		Assert.assertEquals("The computer was sussessfully deleted", expectedResult, actualResult);

	}

	@Test
	public void editComputerDiscontinuedDate() throws Exception {
		mComputersPage.open();
		mComputersPage.findAndReadComputer("Computer_To_Be_Edited");
		mEditComputerPage.editDiscontinuedDiDate("2018-05-05");

		String actualResult = mComputersPage.getAlertMessage();
		System.out.println(actualResult);
		String expectedResult = "Done! Computer Computer_To_Be_Edited has been updated";
		Assert.assertEquals("The computer was sussessfully deleted", expectedResult, actualResult);
	}

	@Test
	public void editComputer() throws Exception {
		mComputersPage.open();
		mComputersPage.findAndReadComputer("Computer_To_Be_Edited");
		mEditComputerPage.editComputer("Computer_Edited", "", "2018-01-01", "RCA");

		String actualResult = mComputersPage.getAlertMessage();
		System.out.println(actualResult);
		String expectedResult = "Done! Computer Computer_Edited has been updated";
		Assert.assertEquals("The computer was sussessfully deleted", expectedResult, actualResult);
	}

	@After
	public void tearDown() {
		mDriver.close();
	}

}
