package com.yashraj.base;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class BaseTest {

	protected Playwright playwright;
	protected Browser browser;
	protected BrowserContext browserContext;
	protected Page page;

	@BeforeMethod
	public void setUp() {
		// create playwright insctance
		playwright = Playwright.create();

		// Launch browser
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		// Create isolated browser session

		browserContext = browser.newContext();

		// Open new tab
		page = browserContext.newPage();

		// Navigate to application
		page.navigate("https://www.saucedemo.com");

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
