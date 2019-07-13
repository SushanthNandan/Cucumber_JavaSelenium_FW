package stepdefs;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import resources.ObjectRepository;
import utilities.GenericUtils;

public class Homepage {

	WebDriver driver;
	public static SoftAssert softassert = new SoftAssert();
	public GenericUtils utils;
	public static HashMap<String, HashMap<String, String>> videosList = new HashMap<String, HashMap<String, String>>();
	public ObjectRepository objRepo = new ObjectRepository();

	@Given("^user is in discovery homepage \"([^\"]*)\"$")
	public void user_is_in_discovery_homepage(String url) throws Throwable {
		WebDriverManager.chromedriver().version("74.0.3729.6").setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Hooks.propsObject.getProperty(url));
		driver.manage().window().maximize();

	}

	@When("^user select any two recommended videos at position \"([^\"]*)\" and add to favorite list$")
	public void user_select_any_two_recommended_videos_at_position_and(String positionValues) throws Throwable {
		try {

			utils = new GenericUtils(driver);
			utils.waitUntilPageLoads();
			List<WebElement> li = utils.getListOfElements(objRepo.homepage_recommendedvideos_list,
					"homepage recommended videos");
			if (li.size() > 0)
				for (String val : positionValues.split(",")) {

					HashMap<String, String> titleAndText = new HashMap<String, String>();

					utils.waitforElement(utils.ReturnParametrizedLocator(objRepo.homepage_recommendedvideos_list, val),
							"Recommended Video");
					utils.MoveToElement(utils.ReturnParametrizedLocator(objRepo.homepage_recommendedvideos_list, val),
							"Recommended Video");
					String video_title = utils.fetchingTextvalueofElement(
							utils.ReturnParametrizedLocator(objRepo.homepage_recommended_videoTitle, val),
							"Video Title");
					String video_description = utils.fetchingTextvalueofElement(
							utils.ReturnParametrizedLocator(objRepo.homepage_recommended_videoDescription, val),
							"Video Description");
					titleAndText.put("description", video_description);
					videosList.put(video_title, titleAndText);
					utils.clickonElement(
							utils.ReturnParametrizedLocator(objRepo.homepage_recommended_video_AddToFavorites, val),
							"Add to favorites");
					utils.waitUntilPageLoads();

				}
			else
				System.out.println("Recommended videos is not displayed");

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@And("^navigate to myvideos page \"([^\"]*)\"$")
	public void navigate_to_myvideos_page(String url) throws Throwable {

		try {
			utils = new GenericUtils(driver);
			driver.navigate().to(Hooks.propsObject.getProperty(url));
			utils.waitUntilPageLoads();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Then("^validate the video title and description in favorite list$")
	public void validate_the_video_title_and_description() throws Throwable {

		try {

			List<WebElement> li = utils.getListOfElements(objRepo.Myvideos_FavoriteList, "Myvideos_FavoriteList");
			if (li.size() > 0) {
				int position = 1;
				for (WebElement shows : li) {

					utils.waitforElement(
							utils.ReturnParametrizedLocator(objRepo.Myvideos_FavoriteList, Integer.toString(position)),
							"Myvideos_FavoriteList");
					utils.MoveToElement(
							utils.ReturnParametrizedLocator(objRepo.Myvideos_FavoriteList, Integer.toString(position)),
							"Myvideos_FavoriteList");
					String titleVal = utils.fetchingTextvalueofElement(utils.ReturnParametrizedLocator(
							objRepo.Myvideos_FavoriteList_Title, Integer.toString(position)), "Favorite List title");
					String descriptionValue = utils.fetchingTextvalueofElement(utils
							.ReturnParametrizedLocator(objRepo.Myvideos_FavoriteList_Desc, Integer.toString(position)),
							"Favorite List Description");
					softassert.assertTrue(
							descriptionValue.contains(videosList.get(titleVal).get("description").replace("…", "")));

					position++;
				}

			} else
				System.out.println("No video is been added to favorite list");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	@And("^closing browser$")
	public void ClosingBrowser() throws Throwable {
		try {
			softassert.assertAll();
			driver.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
