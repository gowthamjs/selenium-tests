package com.build.qa.build.selenium.pageobjects.cartpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import com.build.qa.build.selenium.pageobjects.BasePage;

public class CartPage extends BasePage {
	
	private By emailButton;
	private By nameField;
	private By emailField;
	private By messageField;
	private By receipientNameField;
	private By receipientEmailField;
	private By sendEmailButton;
	private By productTitleInCartPage;
	private By emailSentConfirmation;
	
	public CartPage(WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait);
		productTitleInCartPage = By.xpath("//table[@class='cart-items']/tbody/tr[1]/td[2]/a/span");
		emailButton = By.xpath("//*[@id='page-content']/div[1]/div[1]/div/section[2]/div/div[1]/table/tbody/tr[2]/td/button[1]");
		nameField = By.xpath("//input[@id='yourName']");
		emailField = By.xpath("//input[@id='yourEmail']");
		messageField = By.xpath("//textarea[@id='quoteMessage']");
		receipientNameField = By.xpath("//input[@id='recipientName']");
		receipientEmailField = By.xpath("//input[@id='recipientEmail']");
		sendEmailButton = By.xpath("//*[@id='cart-email']/div/div/div[2]/div[2]/form/div[4]/button");
		emailSentConfirmation = By.xpath("//header[@id='header']/div[4]/div/ul/li");
	}
	
	public WebElement emailButton() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(emailButton));
	}
	
	public WebElement nameField() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
	}
	
	public WebElement emailField() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
	}
	
	public WebElement messageField() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(messageField));
	}
	
	public WebElement receipientName() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(receipientNameField));
	}
	
	public WebElement receipientEmail() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(receipientEmailField));
	}
	
	public WebElement productTitle() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(productTitleInCartPage));
	}
	
	public WebElement sendEmailButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(sendEmailButton));
	}
	
	public WebElement emailSentConfirmation() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(emailSentConfirmation));
	}
	
}
