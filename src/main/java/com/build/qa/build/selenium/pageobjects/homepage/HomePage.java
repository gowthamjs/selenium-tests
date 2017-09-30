package com.build.qa.build.selenium.pageobjects.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import com.build.qa.build.selenium.pageobjects.BasePage;

public class HomePage extends BasePage {
	
	private By buildThemeBody;
	private By searchBox;
	private By searchIcon; 
	private By cartButton;
	private By signUpBanner;
	private By closeSignUpBanner;
	
	public HomePage(WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait);
		buildThemeBody = By.cssSelector("body.build-theme");
		searchBox = By.id("search_txt");
		searchIcon = By.xpath("//button[@class='button-primary search-site-search']");
		cartButton = By.xpath("//*[@class='header-bar']/div/div/div/a[2]/button");
		signUpBanner = By.xpath("//*[@id='newsletter-modal']/div[1]/h2");
		closeSignUpBanner = By.xpath("//*[@id='email-subscribe-splash']/div/div/div[1]/button");
	}
	
	public boolean onBuildTheme() { 
		return wait.until(ExpectedConditions.presenceOfElementLocated(buildThemeBody)) != null;
	}
	
	public WebElement searchBox() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
	}
	
	public WebElement searchIcon() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(searchIcon));
	}
	
	public WebElement cartButton() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(cartButton));
	}
	
	public WebElement signUpBanner() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(signUpBanner));
	}
	
	public WebElement closeSignUpBanner() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(closeSignUpBanner));
	}
	
}
