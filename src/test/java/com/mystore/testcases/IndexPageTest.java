/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SignInPage;

/**
 * @author Shree Computers
 *
 */
public class IndexPageTest extends BaseClass {

	IndexPage indexPage;
	SignInPage signInPage;
	
	@Parameters("browser")
	
	@BeforeMethod(groups={"Smoke","Sanity","Regression"}) 
	public void setup(String browser)
	{
		launchApp(browser);
	}
	
	
	@AfterMethod(groups={"Smoke","Sanity","Regression"}) 
	public void tearDown()
	{
		getDriver().quit();
	}
	
	
	@Test(groups="Smoke")
	public void verifyLogoTest()
	{
		indexPage = new IndexPage();
		boolean logoResult = indexPage.validateLogo();
		Assert.assertTrue(logoResult);
	}

	
	@Test(groups="Smoke")
	public void validateSignInPageTitleAfterClickOnSignIn()
	{
		indexPage = new IndexPage();
		signInPage = indexPage.clickOnSignIn();
		
		signInPage = new SignInPage();
		signInPage.verifySignInPageTitle();
		
		
		
	}
}
