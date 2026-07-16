package com.yashraj.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.yashraj.base.BasePage;

public class LoginPage extends BasePage {
	
	private final Locator txtUsername;
    private final Locator txtPassword;
    private final Locator btnLogin;

	public LoginPage(Page page) {
		super(page);
		txtUsername = page.getByPlaceholder("Username");
	    txtPassword = page.getByPlaceholder("Password");
	    btnLogin = page.getByRole(
	            AriaRole.BUTTON,
	            new Page.GetByRoleOptions().setName("Login"));
	}


	// Actions

	public void login(String user, String pass) {

		fill(txtUsername, user);

		fill(txtPassword, pass);

		click(btnLogin);
	}

}
