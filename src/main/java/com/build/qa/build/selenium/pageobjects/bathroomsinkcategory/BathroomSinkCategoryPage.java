package com.build.qa.build.selenium.pageobjects.bathroomsinkcategory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import com.build.qa.build.selenium.pageobjects.BasePage;

public class BathroomSinkCategoryPage extends BasePage {
	
	/*
	 * To select any other item in the category page, update list tag to the corresponding number
	 */
	private By secondItemIncategoryResults; 
	private By filterByLength;
	private By totalNumberOfItems;
	private By filterByColor;
	
	public BathroomSinkCategoryPage(WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait);
		secondItemIncategoryResults = By.xpath("//*[@class='js-product-grid-container']/ul/li[2]/div[2]"); 
		filterByLength = By.xpath("//*[@id='facet-options']/li[4]/ul/li[1]/label");
		totalNumberOfItems = By.xpath("//*[@id='category-content']/div[2]/div/div[1]/span/span");
		filterByColor = By.xpath("//*[@id='facet-options']/li[5]/ul/li[1]/label");
	}
	
	public WebElement secondItem() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(secondItemIncategoryResults));
	}
	
	public WebElement filterByLength() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(filterByLength));
	}
	
	public WebElement filterByColor() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(filterByColor));
	}
	
	public WebElement totalNumberOfItems() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(totalNumberOfItems));
	}
}
