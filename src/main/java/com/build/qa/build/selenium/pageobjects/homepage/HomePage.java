package com.build.qa.build.selenium.pageobjects.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import com.build.qa.build.selenium.pageobjects.BasePage;

public class HomePage extends BasePage {
	
	private By buildThemeBody;
	private By searchBox = By.id("search_txt");
	private By searchIcon = By.className("button-primary search-site-search");
	
	public HomePage(WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait);
		buildThemeBody = By.cssSelector("body.build-theme");
	}
	
	public boolean onBuildTheme() { 
		return wait.until(ExpectedConditions.presenceOfElementLocated(buildThemeBody)) != null;
	}
	
	public WebElement searchBox() {
		return driver.findElement(searchBox);
	}
	
	public WebElement searchIcon() {
		return driver.findElement(searchIcon);
	}
}
