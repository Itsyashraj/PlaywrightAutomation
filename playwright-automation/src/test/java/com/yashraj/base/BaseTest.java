package com.yashraj.base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.yashraj.factory.BrowserFactory;
import com.yashraj.utils.ConfigReader;

import org.testng.annotations.BeforeMethod;

import java.util.Arrays;

import org.testng.annotations.AfterMethod;

public class BaseTest {

	protected static Playwright playwright;
	protected static Browser browser;
	protected static BrowserContext browserContext;
	protected static Page page;
	
	public static Page getPage() {
        return page;
    }

	@BeforeMethod
	public void setUp() {
		// create playwright insctance
		playwright = Playwright.create();

		browser = BrowserFactory.launchBrowser(playwright, ConfigReader.getProperty("browser"),
				Boolean.parseBoolean(ConfigReader.getProperty("headless")));

		// Create isolated browser session

		browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));

		// Open new tab
		page = browserContext.newPage();

		// Navigate to application
		page.navigate(ConfigReader.getProperty("url"));

	}

	@AfterMethod
	public void tearDown() {

		if (page != null)
			page.close();

		if (browserContext != null)
			browserContext.close();

		if (browser != null)
			browser.close();

		if (playwright != null)
			playwright.close();
	}

}
