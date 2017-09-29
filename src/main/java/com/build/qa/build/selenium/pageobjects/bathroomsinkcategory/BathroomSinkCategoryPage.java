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
	
	public BathroomSinkCategoryPage(WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait);
		secondItemIncategoryResults = By.xpath("//*[@class='js-product-grid-container']/ul/li[2]/div[2]"); 
	}
	
	public WebElement secondItem() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(secondItemIncategoryResults));
	}
	
}
