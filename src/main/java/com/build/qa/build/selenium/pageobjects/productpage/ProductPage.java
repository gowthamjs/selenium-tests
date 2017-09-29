package com.build.qa.build.selenium.pageobjects.productpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import com.build.qa.build.selenium.pageobjects.BasePage;

public class ProductPage extends BasePage {
	
	private By addToBag;
	private By productTitle;
	
	public ProductPage(WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait);
		addToBag = By.xpath("//*[@class='purchase-box js-purchase-box']/div[2]/div[7]/div/div[2]/button");
		productTitle = By.xpath("//div[@id='product']/div[2]/div/h2");
	}
	
	public WebElement addToBag() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(addToBag));
	}
	
	public WebElement productTitle() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(productTitle));
	}
		
}
