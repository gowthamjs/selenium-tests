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

	
	public HomePage(WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait);
		buildThemeBody = By.cssSelector("body.build-theme");
		searchBox = By.id("search_txt");
		searchIcon = By.xpath("//button[@class='button-primary search-site-search']");
		cartButton = By.xpath("//*[@class='header-bar']/div/div/div/a[2]/button");
	}
	
	public boolean onBuildTheme() { 
		return wait.until(ExpectedConditions.presenceOfElementLocated(buildThemeBody)) != null;
	}
	
	public WebElement searchBox() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(searchBox));
	}
	
	public WebElement searchIcon() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(searchIcon));
	}
	
	public WebElement cartButton() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(cartButton));
	}
}
