package com.yashraj.tests;

import org.testng.annotations.Test;

import com.yashraj.base.BaseTest;
import com.yashraj.pages.InventoryPage;
import com.yashraj.pages.LoginPage;
import com.yashraj.utils.ConfigReader;

public class LoginTest extends BaseTest{
  @Test
  public void verifySuccessfulLogin() {
	  
	  LoginPage loginPage = new LoginPage(page);
	  
	  loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password")); 
	  
	  InventoryPage inventoryPage = new InventoryPage(page);
	  inventoryPage.verifyInventoryPage();
  }
}
