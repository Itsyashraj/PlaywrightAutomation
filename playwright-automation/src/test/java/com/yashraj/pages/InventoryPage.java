package com.yashraj.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class InventoryPage {
	
	private final Page page;

	public InventoryPage(Page page) {
		super();
		this.page = page;
	}
	
	public void verifyInventoryPage() {

        PlaywrightAssertions.assertThat(page)
                .hasURL("https://www.saucedemo.com/inventory.html");

        PlaywrightAssertions.assertThat(page.locator(".title"))
                .hasText("Products");
    }

}
