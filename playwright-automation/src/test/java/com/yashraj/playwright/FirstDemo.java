package com.yashraj.playwright;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class FirstDemo {

	Playwright playwright;
	Page page;

	@BeforeMethod
	public void beforeMethod() {
		playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)
				.setExecutablePath(Paths.get("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe")));
		BrowserContext context = browser.newContext();
		page = context.newPage();
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int) screenSize.getWidth();
		int screenHeight = (int) screenSize.getHeight();
		// Set the viewport size of the page to the screen size
		page.setViewportSize(screenWidth, screenHeight);
//		page.navigate("http://10.82.180.36/Common/Login.aspx");

		
//		page.setViewportSize(1920, 1080);
		page.navigate("https://www.saucedemo.com");
	}

	@Test
	public void run() {
		/*
		<input class="input_error form_input" 
		placeholder="Username" 
		type="text" data-test="username" 
		id="user-name" 
		name="user-name" 
		autocorrect="off" 
		autocapitalize="none" 
		value="" fdprocessedid="cxil0b">
		*/
//		page.locator("#user-name").fill("standard_user");		// By ID
		page.locator("input[name='user-name']").fill("standard_user");		// By CSS selector		
//		page.locator("//*[@id=\"user-name\"]").fill("standard_user");		// By XPath	--->  Use only when necessary

	    page.locator("#password").fill("secret_sauce");
	    page.waitForTimeout(1000);
//	    page.locator("#login-button").click();
	    page.getByText("Login").click();

	    String title = page.title();
	    System.out.println("Page Title: " + title);

	    Assert.assertTrue(page.url().contains("inventory"));
	    PlaywrightAssertions.assertThat(page).hasURL("https://www.saucedemo.com/inventory.html");
	}
	
	@AfterMethod
	public void afterMethod() {
		page.close();
		playwright.close();
	}
}
