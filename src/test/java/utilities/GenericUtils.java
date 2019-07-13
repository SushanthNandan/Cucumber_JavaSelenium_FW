package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class GenericUtils {

	WebDriver driver;
	public static WebDriverWait wait;
	public SoftAssert softAssert = new SoftAssert();

	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}

	public void clickonElement(By locator, String elementName) {

		try {
			driver.findElement(locator).click();
			Reporter.log(elementName + " is clicked successfully");
		} catch (Exception e) {
			Reporter.log(elementName + ": Clicking on element is unsuccesfull");
			softAssert.fail(elementName + " is not getting clicked");
			e.printStackTrace();
		}

	}

	public void waitforElement(By element, String elementName) {

		try {
			wait = new WebDriverWait(driver, 90);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			Reporter.log(elementName + "waitForVisibilty is Succesfull");
		} catch (Exception e) {
			Reporter.log("Unable to locate the element ");
			e.printStackTrace();
		}

	}

	public String fetchingTextvalueofElement(By locator, String ElementName)

	{
		String elementTextValue = null;

		try {
			waitforElement(locator, "element to fetch text");
			elementTextValue = driver.findElement(locator).getText();
			System.out.println(elementTextValue);
		}

		catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Unable to find text for the " + ElementName);
			softAssert.fail("Unable to find text for the " + ElementName);
		}
		return elementTextValue;
	}

	public void waitUntilPageLoads() {

		try {
			ExpectedCondition<Boolean> pageloadcondition = new ExpectedCondition<Boolean>() {

				public Boolean apply(WebDriver driver) {
					// TODO Auto-generated method stub
					return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
				}
			};
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(pageloadcondition);
		} catch (Exception E) {

			E.printStackTrace();
			Reporter.log("Unable to wait for the page to load", true);
		}
	}

	public List<WebElement> getListOfElements(By locator, String ElementName) throws InterruptedException {
		Thread.sleep(3000);
		// waitForVisibilty(xpath, 20);

		List<WebElement> li = new ArrayList<WebElement>();

		try {

			li = driver.findElements(locator);

		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Error Occured in function checkSizeOfElements " + e.getMessage());
			softAssert.fail("Error Occured in function checkSizeOfElements " + e.getMessage());
		}
		return li;
	}

	public void MoveToElement(By locator, String ElementName) {

		try {

			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(locator)).build().perform();

		} catch (Exception E) {
			E.printStackTrace();

		}

	}

	public By ReturnParametrizedLocator(By locator, String positionNumber) {

		try {
			return By.xpath("(" + locator.toString().replace("By.xpath: ", "") + ")[" + positionNumber + "]");
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("error occured while adding positional parameter value in the xpath");

			return null;
		}

	}

	public static Properties readPropertyFile(String filePath) {
		File file = new File(filePath);
		Properties prop = new Properties();
		try {
			FileInputStream fileInput = new FileInputStream(file);
			// load properties file
			prop.load(fileInput);
		} catch (Exception e) {
			System.out
					.println("Exception has Occurred in Method readPropertyFile" + e.getMessage() + e.getStackTrace());

		}
		return prop;
	}

}
