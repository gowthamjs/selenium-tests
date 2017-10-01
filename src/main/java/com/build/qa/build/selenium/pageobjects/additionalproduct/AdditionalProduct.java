package com.build.qa.build.selenium.pageobjects.additionalproduct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import com.build.qa.build.selenium.pageobjects.BasePage;

public class AdditionalProduct extends BasePage {
	
	private By noThanksButton;
	
	public AdditionalProduct(WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait);
		noThanksButton = By.xpath("//button[@id='continue-without-items']");
	}
	
	public WebElement noThanksButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(noThanksButton));
	}
}
