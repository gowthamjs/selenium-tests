package com.build.qa.build.selenium.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.build.qa.build.selenium.framework.BaseFramework;
import com.build.qa.build.selenium.pageobjects.bathroomsinkcategory.BathroomSinkCategoryPage;
import com.build.qa.build.selenium.pageobjects.cartpage.CartPage;
import com.build.qa.build.selenium.pageobjects.homepage.HomePage;
import com.build.qa.build.selenium.pageobjects.productpage.ProductPage;

public class BuildTest extends BaseFramework {

	/**
	 * Extremely basic test that outlines some basic functionality and page
	 * objects as well as assertJ
	 */
	@Test
	public void navigateToHomePage() {
		driver.get(getConfiguration("HOMEPAGE"));
		HomePage homePage = new HomePage(driver, wait);

		softly.assertThat(homePage.onBuildTheme())
				.as("The website should load up with the Build.com desktop theme.")
				.isTrue();
	}

	/**
	 * Search for the Quoizel MY1613 from the search bar
	 * 
	 * @assert: That the product page we land on is what is expected by checking
	 *          the product title
	 * @difficulty Easy
	 */
	@Test
	public void searchForProductLandsOnCorrectProduct() {
		driver.get(getConfiguration("HOMEPAGE"));
		HomePage homePage = new HomePage(driver, wait);
		String productName = "Monterey Mosaic 3 Light 16\" Wide Flush Mount Ceiling Fixture with Pen Shell Mosaic Shade";
		ProductPage productPage = new ProductPage(driver, wait);
		homePage.searchBox().sendKeys("Quoizel MY1613");
		homePage.searchIcon().click();

		softly.assertThat(productPage.productTitle().getText())
			.as("%s is the product title", productPage.productTitle().getText())
			.isEqualTo(productName);
	}

	/**
	 * Go to the Bathroom Sinks category directly
	 * (https://www.build.com/bathroom-sinks/c108504) and add the second product
	 * on the search results (Category Drop) page to the cart.
	 * 
	 * @throws InterruptedException
	 * @assert: the product that is added to the cart is what is expected
	 * @difficulty Easy-Medium
	 */
	@Test
	public void addProductToCartFromCategoryDrop() throws InterruptedException {
		driver.get("https://www.build.com/bathroom-sinks/c108504");
		BathroomSinkCategoryPage bathroomSinkCategoryPage = new BathroomSinkCategoryPage(driver, wait);
		ProductPage productPage = new ProductPage(driver, wait);
		HomePage homePage = new HomePage(driver, wait);
		CartPage cartPage = new CartPage(driver, wait);
		bathroomSinkCategoryPage.secondItem().click();
		checkSignUpBanner();
		productPage.addToBag().click();
		Thread.sleep(3000);
		homePage.cartButton().click();	
	}

	/**
	 * Add a product to the cart and email the cart to yourself, also to my
	 * email address: jgilmore+SeleniumTest@build.com Include this message in
	 * the "message field" of the email form:
	 * "This is {yourName}, sending you a cart from my automation!"
	 * 
	 * @assert that the "Cart Sent" success message is displayed after emailing
	 *         the cart
	 * @difficulty Medium-Hard
	 */
	@Test
	public void addProductToCartAndEmailIt() {
		driver.get("https://www.build.com/bathroom-sinks/c108504");
		checkSignUpBanner();
		BathroomSinkCategoryPage bathroomSinkCategoryPage = new BathroomSinkCategoryPage(driver, wait);
		bathroomSinkCategoryPage.secondItem().click();
		ProductPage productPage = new ProductPage(driver, wait);
		HomePage homePage = new HomePage(driver, wait);
		productPage.addToBag().click();
		homePage.cartButton().click();
		sendEmail();
	}

	/**
	 * Go to a category drop page (such as Bathroom Faucets) and narrow by at
	 * least two filters (facets), e.g: Finish=Chromes and Theme=Modern
	 * 
	 * @assert that the correct filters are being narrowed, and the result count
	 *         is correct, such that each facet selection is narrowing the
	 *         product count.
	 * @difficulty Hard
	 */
	@Test
	public void facetNarrowBysResultInCorrectProductCounts() {
		// TODO: Implement this test
	}

	/*
	 * I have added this method here because the sing-up banner displays not
	 * just in home screen but while accessing this below link as well
	 * https://www.build.com/bathroom-sinks/c108504
	 */
	private void checkSignUpBanner() {
		// WebElement to check text "5% Off your first order"
		final WebElement signUpBanner = driver.findElement(By.xpath("//*[@id='newsletter-modal']/div[1]/h2"));
		final WebElement closeButton = driver
				.findElement(By.xpath("//*[@id='email-subscribe-splash']/div/div/div[1]/button"));
		if (signUpBanner.isDisplayed()) {
			System.out.println("SignUpBanner being closed");
			closeButton.click();
		} else {
			System.out.println("SignUp Banner not found");
		}
	}

	private void sendEmail() {
		CartPage cartPage = new CartPage(driver, wait);
		cartPage.emailButton().click();
		cartPage.nameField().sendKeys("Gowtham");
		cartPage.emailField().sendKeys("gowthamjs@yahoo.com");
		cartPage.receipientName().sendKeys("Meena");
		cartPage.receipientEmail().sendKeys("meenakmm@yahoo.co.in");
		cartPage.messageField().sendKeys("This is Gowtham, sending you a cart from my automation!");
		cartPage.sendEmailButton().click();
	}
}
