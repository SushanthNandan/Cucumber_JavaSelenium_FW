package stepdefs;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.ObjectRepository;
import utilities.GenericUtils;

public class MyVideospage {


	public GenericUtils utils;
	WebDriver driver;
	public ObjectRepository objRepo = new ObjectRepository();
	public static SoftAssert softassert = new SoftAssert();
	
	


	@And("^navigate to myvideos page \"([^\"]*)\"$")
	public void navigate_to_myvideos_page(String url) throws Throwable {

		try {
			this.driver = Homepage.driver;
			utils = new GenericUtils(driver);
			driver.navigate().to(Hooks.propsObject.getProperty(url));
			utils.waitUntilPageLoads();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	
	
}
