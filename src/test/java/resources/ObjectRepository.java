package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ObjectRepository {

	WebDriver driver;

	public By homepage_recommendedvideos_list = By.xpath(
			"//div[@class='content carousel__content showCarousel__content']/div[@class='carousel-tile-wrapper carousel__tileWrapper']");

	public By homepage_recommended_videoTitle = By.xpath(
			"//div[@class='content carousel__content showCarousel__content']//h3[@class='showTileSquare__title']/div");

	public By homepage_recommended_videoDescription = By.xpath(
			"//div[@class='content carousel__content showCarousel__content']//div[@class='showTileSquare__description']");

	public By homepage_recommended_video_AddToFavorites = By.xpath(
			"//div[@class='content carousel__content showCarousel__content']//div[@class='my-favorites-button-container']");

	public By Myvideos_FavoriteList = By.xpath(
			"//section[contains(@class, 'FavoriteShowsCarousel')]//div[@class='carousel-tile-wrapper carousel__tileWrapper']");

	public By Myvideos_FavoriteList_Title = By.xpath(
			"// section[contains(@class, 'FavoriteShowsCarousel')]//div//h3[@class='showTileSquare__title']/div");

	public By Myvideos_FavoriteList_Desc = By.xpath(
			"//section[contains(@class, 'FavoriteShowsCarousel')]//div//div[@class='showTileSquare__description']");

}