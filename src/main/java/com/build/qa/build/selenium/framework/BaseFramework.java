package com.build.qa.build.selenium.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public abstract class BaseFramework {
	protected WebDriver driver;
	protected Wait<WebDriver> wait;
	private static final Logger LOG = LoggerFactory.getLogger(BaseFramework.class);
	private static final String CONFIG_FILE = "./conf/automation.properties";
	private static final String DRIVER_FIREFOX = "firefox";
	private static final String DRIVER_CHROME = "chrome";
	private static final String DRIVER_SAFARI = "safari";
	private static final String DRIVER_CHROME_MOBILE = "mobile-chrome";

	private static Properties configuration;

	@Rule
	public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

	@BeforeClass
	public static void beforeClass() throws IOException {
		configuration = new Properties();
		FileInputStream input;

		LOG.info("Loading in configuration file.");
		input = new FileInputStream(new File(CONFIG_FILE));
		configuration.loadFromXML(input);
		input.close();
	}

	@Before
	public void setUpBefore() throws MalformedURLException {
		DesiredCapabilities capabilities = null;
		// Which driver to use? 
		if (DRIVER_CHROME.equalsIgnoreCase(configuration.getProperty("BROWSER"))) {
			
			/*
			 * uncomment and add the path of chrome driver in your machine to run on Chrome driver.
			 * Running the script on chrome browser displays captcha page.
			 */
		
			//System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
			capabilities = DesiredCapabilities.chrome();
			driver = new ChromeDriver(capabilities);
			
		} else if (DRIVER_FIREFOX.equalsIgnoreCase(configuration.getProperty("BROWSER"))) {
			capabilities = DesiredCapabilities.firefox();
			//uncomment and add the path of gecko driver in your machine to run on FireFox driver
			//System.setProperty("webdriver.gecko.driver", "C:/geckodriver/geckodriver.exe");
			driver = new FirefoxDriver(capabilities);
			
		} else if (DRIVER_SAFARI.equalsIgnoreCase(configuration.getProperty("BROWSER"))) {
			capabilities = DesiredCapabilities.safari();
			
			/*
			 * I am working on a windows machine and it appears Apple doesn't support running tests on windows mac.
			 * Here is the documentation link: https://github.com/SeleniumHQ/selenium/wiki/SafariDriver
			 */
			
			driver = new SafariDriver(capabilities);
			
		} else if (DRIVER_CHROME_MOBILE.equalsIgnoreCase(configuration.getProperty("BROWSER"))) {
			capabilities = new DesiredCapabilities();
			
			/*
			 * Update the device name in the below statement.
			 * In the mobile device chrome browser also, captcha screen displays
			 * Sorry, I couldn't check this in iOS, as I have windows machine
			 */
			
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "device");
			capabilities.setCapability(AndroidMobileCapabilityType.BROWSER_NAME, "Chrome");
			driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		}
		// Define fluent wait
		wait = new FluentWait<WebDriver>(driver).withTimeout(15, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);
	}

	protected WebDriver getDriver() {
		return driver;
	}
	
	protected String getConfiguration(String config) { 
		return configuration.getProperty(config);
	}

	@After
	public void tearDownAfter() {
		LOG.info("Quitting driver.");
		driver.quit();
		driver = null;
	}
}
