package com.build.qa.build.selenium.pageobjects.cartpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

import com.build.qa.build.selenium.pageobjects.BasePage;

public class CartPage extends BasePage {
	
	private By emailButton = By.xpath("//*[@id='page-content']/div[1]/div[1]/div/section[2]/div/div[1]/table/tbody/tr[2]/td/button[1]");
	private By nameField = By.xpath("//input[@id='yourName']");
	private By emailField = By.xpath("//input[@id='yourEmail']");
	private By messageField = By.xpath("//textarea[@id='quoteMessage']");
	private By receipientNameField = By.xpath("//input[@id='recipientName']");
	private By receipientEmailField = By.xpath("//input[@id='recipientEmail']");
	private By sendEmailButton = By.xpath("//*[@id='cart-email']/div/div/div[2]/div[2]/form/div[4]/button");
	
	public CartPage(WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait);
	}
	
	public WebElement emailButton() {
		return driver.findElement(emailButton);
	}
	
	public WebElement nameField() {
		return driver.findElement(nameField);
	}
	
	public WebElement emailField() {
		return driver.findElement(emailField);
	}
	
	public WebElement messageField() {
		return driver.findElement(messageField);
	}
	
	public WebElement receipientName() {
		return driver.findElement(receipientNameField);
	}
	
	public WebElement receipientEmail() {
		return driver.findElement(receipientEmailField);
	}
	
	public WebElement sendEmailButton() {
		return driver.findElement(sendEmailButton);
	}
	
}
