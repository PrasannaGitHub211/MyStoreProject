/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.SignInPage;

/**
 * @author Shree Computers
 *
 */
public class SearchResultPageTest extends BaseClass {
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	SignInPage signInPage;
	HomePage homePage;
	AddToCartPage addToCartPage;
	
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
	
	@Test(groups="Sanity")
	public void validateSearchProdcutResultWithoutLogin()
	{
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct("bag");
		boolean result = searchResultPage.isProductAvailble();
		Assert.assertTrue(result);
	}
	
	
	@Test(groups="Smoke")
	public void validateSearchProdcutResultWithLogin()
	{
		indexPage = new IndexPage();
		signInPage = new SignInPage();
		homePage = new HomePage();
		
		signInPage = indexPage.clickOnSignIn();
		homePage = signInPage.signInMethod(prop.getProperty("username"), prop.getProperty("password"));
		searchResultPage = homePage.searchProduct("bag");
		boolean result = searchResultPage.isProductAvailble();
		Assert.assertTrue(result);
		
	}
	
	
	@Test(groups="Sanity")
	public void clickOnSearchResultProduct()
	{

		indexPage = new IndexPage();
		signInPage = new SignInPage();
		homePage = new HomePage();
		
		signInPage = indexPage.clickOnSignIn();
		homePage = signInPage.signInMethod(prop.getProperty("username"), prop.getProperty("password"));
		searchResultPage = homePage.searchProduct("bag");
		boolean result = searchResultPage.isProductAvailble();
		Assert.assertTrue(result);
		addToCartPage = searchResultPage.clickOnProduct();
	}

}
