package com.yashraj.pages;

import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginPage {
	
	private final Page page;

	public LoginPage(Page page) {
		this.page = page;
	}
	
	// Locators
    private String username = "#user-name";
    private String password = "#password";
    private String loginButton = "#login-button";
    
 // Actions
    public void enterUsername(String user) {
        page.locator(username).fill(user);
    }
    
    public void enterPassword(String pass) {
        page.locator(password).fill(pass);
    }

    public void clickLogin() {
        page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Login"))
                .click();
    }
    
    public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }
 
}
