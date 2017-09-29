package com.build.qa.build.selenium.pageobjects.productpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

import com.build.qa.build.selenium.pageobjects.BasePage;

public class ProductPage extends BasePage {
	
	private By addToCart= By.xpath("//*[@class='purchase-box js-purchase-box']/div[2]/div[7]/div/div[2]/button");
	
	public ProductPage(WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait);
	}
	
	public WebElement addToBag() {
		return driver.findElement(addToCart);
	}
	
}
