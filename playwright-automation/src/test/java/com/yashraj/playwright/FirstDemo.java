package com.yashraj.playwright;

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
		page.setViewportSize(1920, 1080);
		page.navigate("https://www.saucedemo.com");
	}

	@Test
	public void f() {
		page.locator("#user-name").fill("standard_user");
	    page.locator("#password").fill("secret_sauce");
	    page.waitForTimeout(1000);
	    page.locator("#login-button").click();

	    String title = page.title();
	    System.out.println("Page Title: " + title);

	    Assert.assertTrue(page.url().contains("inventory"));
	}
	
	@AfterMethod
	public void afterMethod() {
		page.close();
		playwright.close();
	}
}
