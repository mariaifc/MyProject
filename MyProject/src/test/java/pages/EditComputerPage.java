package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This class implements the "Edit computer" Page Object. This class was created
 * in order to implement all objects from the "Edit computer" page.
 * 
 * @author mariaisabel
 * @version 1.0
 * @since 2018-05-20
 */
public class EditComputerPage {

	WebDriver mDriver;

	By computerName = By.id("name");
	By introducedDate = By.id("introduced");
	By discontinuedDate = By.id("discontinued");
	By company = By.id("company");
	By buttonSave = By.cssSelector(".btn.primary");
	By pageTitle = By.xpath("//section/h1");
	By errorFieldValue = By.xpath("//fieldset/div[@class='clearfix error']");

	By deleteButon = By.cssSelector(".btn.danger");

	/**
	 * Returns the Computer name
	 * 
	 * @return the computer name inserted in this field
	 */
	public String getComputerName() {
		return mDriver.findElement(computerName).getText();
	}

	/**
	 * Set the computer name on the "Computer name" field
	 * 
	 * @param name-
	 *            a compute name
	 */
	public void setComputerName(String name) {
		mDriver.findElement(computerName).clear();
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
		mDriver.findElement(introducedDate).clear();
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
		mDriver.findElement(discontinuedDate).clear();
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
		System.out.println(xpath);
		mDriver.findElement(By.id("company")).click();
		mDriver.findElement(By.xpath(xpath)).click();

	}

	/**
	 * Constructor for the EditComputerPage object
	 * 
	 * @param mDriver-
	 *            the Selenium webdriver
	 */
	public EditComputerPage(WebDriver mDriver) {
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
	 * Click on the Save button to save the changes
	 */
	public void clickOnSaveButton() {
		mDriver.findElement(buttonSave).click();
	}

	/**
	 * Edit a computer
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

	public void editComputer(String name, String introducedDate, String discontinuedDate, String company)
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

	/**
	 * Click on the Delete button to remove the computer
	 */
	public void clickOnDeleteBtn() {
		mDriver.findElement(deleteButon).click();
	}

	/**
	 * Update a computer name
	 * 
	 * @param newName-
	 *            a new name to the computer
	 * @throws Exception
	 */
	public void editName(String newName) throws Exception {
		setComputerName(newName);
		Thread.sleep(1000);
		clickOnSaveButton();
		Thread.sleep(1000);
	}

	/**
	 * Update the computer introduced date
	 * 
	 * @param newDate-
	 *            a new introduced date on "YYYY-MM-dd" format
	 * @throws Exception
	 */
	public void editIntroducedDate(String newDate) throws Exception {
		setIntroducedDate(newDate);
		Thread.sleep(1000);
		clickOnSaveButton();
		Thread.sleep(1000);
	}

	/**
	 * Update the computer introduced date
	 * 
	 * @param newDate-
	 *            a new discontinued date on "YYYY-MM-dd" format
	 * @throws Exception
	 */
	public void editDiscontinuedDiDate(String newDate) throws Exception {
		setDiscontinuedDate(newDate);
		Thread.sleep(1000);
		clickOnSaveButton();
		Thread.sleep(1000);
	}

}
