package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This class implements the "Add a computer" Page Object.
 * 
 * @author mariaisabel
 * @version 1.0
 * @since 2018-05-20
 */
public class AddAComputerPage {

	WebDriver mDriver;
	private static final String ADD_A_COMPUTER_URL = "http://computer-database.herokuapp.com/computers/new";

	By computerName = By.id("name");
	By introducedDate = By.id("introduced");
	By discontinuedDate = By.id("discontinued");
	By company = By.id("company");
	By buttonSave = By.xpath("//input[@type='submit']");
	By pageTitle = By.xpath("//section/h1");
	By errorFieldValue = By.xpath("//fieldset/div[@class='clearfix error']");

	/**
	 * Returns the Computer name
	 * 
	 * @return the computer name inserted in this field
	 */
	public String getComputerName() {
		return mDriver.findElement(computerName).getText();
	}

	/**
	 * Open the "Add a computer" page directly by the link
	 * 
	 * @return "Add a computer" page
	 */
	public AddAComputerPage open() {
		mDriver.get(ADD_A_COMPUTER_URL);
		return this;
	}

	/**
	 * Set the computer name on the "Computer name" field
	 * 
	 * @param name-
	 *            a compute name
	 */
	public void setComputerName(String name) {
		mDriver.findElement(computerName).sendKeys(name);
	}

	/**
	 * Get the current introduced date on the "Introduced Date" field
	 * 
	 * @return the current introduced date
	 */
	public String getIntroducedDate() {
		return mDriver.findElement(introducedDate).getText();

	}

	/**
	 * Set the introduced date
	 * 
	 * @param date-
	 *            a date should on the "YYYY-MM-dd"
	 */
	public void setIntroducedDate(String date) {
		mDriver.findElement(introducedDate).sendKeys(date);
	}

	/**
	 * Returns the discontinued date
	 */
	public String getDiscontinuedDate() {
		return mDriver.findElement(discontinuedDate).getText();
	}

	/**
	 * Set the Discontinued date
	 * 
	 * @param date-
	 *            a date should be on the "YYYY-MM-dd"
	 */
	public void setDiscontinuedDate(String date) {
		mDriver.findElement(discontinuedDate).sendKeys(date);
	}

	/**
	 * Returns the computer company name
	 * 
	 * @return the current computer company
	 */
	public String getCompany() {
		return mDriver.findElement(company).getText();
	}

	/**
	 * Set a company
	 * 
	 * @param value-
	 *            a name regarding a company
	 */
	public void setCompany(String value) {
		String xpath = "//*[text()='" + value + "']";
		mDriver.findElement(By.id("company")).click();
		mDriver.findElement(By.xpath(xpath)).click();

	}

	/**
	 * Constructor for the AddAComputerPage object
	 * 
	 * @param mDriver-
	 *            the Selenium webdriver
	 */
	public AddAComputerPage(WebDriver mDriver) {
		this.mDriver = mDriver;
	}

	/**
	 * Set a name for a computer
	 * 
	 * @param name-
	 *            a text for a computer name
	 */
	public void setUpAComputerName(String name) {
		mDriver.findElement(computerName).sendKeys(name);
	}

	/**
	 * Click on the Create button
	 */
	public void clickOnSaveButton() {
		mDriver.findElement(buttonSave).click();
	}

	/**
	 * Create a computer
	 * 
	 * @param name-
	 *            a computer name
	 * @param introducedDate-
	 *            a date which should be on the "YYYY-MM-dd" format or it can be
	 *            empty also
	 * @param discontinuedDate-
	 *            a date which should be on the "YYYY-MM-dd" format or it can be
	 *            empty also
	 * @param company-
	 *            a company name
	 * @throws Exception
	 */
	public void addAComputer(String name, String introducedDate, String discontinuedDate, String company)
			throws Exception {
		setComputerName(name);
		Thread.sleep(1000);
		setIntroducedDate(introducedDate);
		setDiscontinuedDate(discontinuedDate);
		setCompany(company);
		Thread.sleep(1000);
		clickOnSaveButton();
		Thread.sleep(1000);
	}

	/**
	 * Returns which field has a validation data error
	 * 
	 * @return the text regargind the page title
	 */
	public String getErrorFieldValue() {
		return mDriver.findElement(errorFieldValue).getText();
	}

	/**
	 * Returns tue page title
	 * 
	 * @return the page title
	 */
	public String getPageTitle() {
		return mDriver.findElement(pageTitle).getText();

	}
	
	public int numberOfFieldsWithError() {
		return mDriver.findElements(errorFieldValue).size();
	}

}
