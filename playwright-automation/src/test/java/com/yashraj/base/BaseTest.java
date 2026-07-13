package com.yashraj.base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.yashraj.utils.ConfigReader;

import org.testng.annotations.BeforeMethod;

import java.util.Arrays;

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

		String browserName = ConfigReader.getProperty("browser");

		// Launch browser
		switch (browserName.toLowerCase()) {

		case "chromium":
			browser = playwright.chromium()
					.launch(new BrowserType.LaunchOptions()
							.setHeadless(Boolean.parseBoolean(ConfigReader.getProperty("headless")))
							.setArgs(Arrays.asList("--start-maximized")));
			break;

		case "firefox":
			browser = playwright.firefox()
					.launch(new BrowserType.LaunchOptions()
							.setHeadless(Boolean.parseBoolean(ConfigReader.getProperty("headless")))
							.setArgs(Arrays.asList("--start-maximized")));
			break;

		case "webkit":
			browser = playwright.webkit()
					.launch(new BrowserType.LaunchOptions()
							.setHeadless(Boolean.parseBoolean(ConfigReader.getProperty("headless")))
							.setArgs(Arrays.asList("--start-maximized")));
			break;

		default:
			throw new IllegalArgumentException("Unsupported browser: " + browserName);

		}

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
