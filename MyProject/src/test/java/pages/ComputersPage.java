package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class implements the "Computers" Page Object. This class was created in
 * order to implement all objects from the "Computers page" page.
 * 
 * @author mariaisabel
 * @version 1.0
 * @since 2018-05-20
 */

public class ComputersPage {

	WebDriver mDriver;
	AddAComputerPage addAcomputerPage;

	private static final String COMPUTERS_URL = "http://computer-database.herokuapp.com/computers";

	By addAcomputer = By.id("add");
	By searchName = By.id("searchbox");
	By alertMessage = By.xpath("//div");
	By findByNameBtn = By.id("searchsubmit");
	By tableResults = By.xpath("//section/table/tbody/tr/td");
	By pageTitle = By.xpath("//section/h1");

	/**
	 * Constructor of the ComputersPage class
	 * 
	 * @param mDriver-
	 *            The selenium webdriver
	 */
	public ComputersPage(WebDriver mDriver) {
		this.mDriver = mDriver;
	}

	/**
	 * Open the Computers page direct by the link
	 * 
	 * @return the Computers page
	 */
	public ComputersPage open() {
		mDriver.get(COMPUTERS_URL);
		return this;
	}

	/**
	 * Click on "Add a computer" button
	 */
	public void clickOnAddButton() {
		mDriver.findElement(addAcomputer).click();
	}

	/**
	 * Click on the Search field
	 */
	public void clickOnSearchBox() {
		mDriver.findElement(searchName).click();
	}

	/**
	 * Get the Alert message displayed after creating, deleting or updating a
	 * computer
	 * 
	 * @return the alert message text
	 */
	public String getAlertMessage() {
		return mDriver.findElement(alertMessage).getText();
	}

	/**
	 * Find a computer according to name informed on search box
	 * 
	 * @param name-
	 *            a computer name to search for it in BD
	 * @return true if the computer exists or false if there is not a computer with
	 *         this name
	 */
	public boolean findAComputerByName(String name) {
		mDriver.findElement(searchName).sendKeys(name);
		mDriver.findElement(findByNameBtn).click();
		boolean hasResult = !mDriver.findElements(tableResults).isEmpty(); 
		if (hasResult) {
			// returns true if the desired computer exists on the table content
			String tableContent = mDriver.findElement(tableResults).getText();
			return tableContent.contains(name);
		}
		return false;
	}

	/**
	 * Find and shows the computer information
	 * 
	 * @param name-
	 *            a computer name
	 */
	public void findAndReadComputer(String name) {
		mDriver.findElement(searchName).sendKeys(name);
		mDriver.findElement(findByNameBtn).click();
		// get all elements with the tag "td" - if there are more than one result,
		// list.size() > 1
		List<WebElement> cells = mDriver.findElements(By.tagName("td"));
		// click on the first result
		String firstLinkText = cells.get(0).getText();
		mDriver.findElement(By.linkText(firstLinkText)).click();
	}

	/**
	 * Get the page title
	 * 
	 * @return the text regarding the page title
	 */
	public String getPageTitle() {
		return mDriver.findElement(pageTitle).getText();

	}

	/**
	 * Go to the "Add a computer" page
	 * 
	 * @throws Exception
	 */
	public void nativateToAddAcomputerPage() throws Exception {
		open();
		Thread.sleep(1000);
		clickOnAddButton();
	}

}
