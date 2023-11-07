/**
 * 
 */
package com.mystore.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.MyAccountPage;
import com.mystore.pageobjects.MyWishListPage;
import com.mystore.pageobjects.SignInPage;

/**
 * @author Shree Computers
 *
 */
public class HomePageTest extends BaseClass{
	IndexPage indexPage;
	SignInPage signInPage;
	HomePage homePage;
	MyAccountPage myAccountPage;
	MyWishListPage myWishListPage;
	
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
	public void getCurrentURLHomePage()
	{
			indexPage  = new IndexPage();
			signInPage = new SignInPage();
			homePage = new HomePage();
		
			signInPage = indexPage.clickOnSignIn();
			homePage = signInPage.signInMethod(prop.getProperty("username"), prop.getProperty("password"));
			
			// Add code to navigate back to the home page after login
			getDriver().get("https://magento.softwaretestingboard.com/");
		    
	   
		  String expectedHomeURL = "https://magento.softwaretestingboard.com/";
		  String actualHomePageURL =  homePage.getCurrentUrl();
		  System.out.println(actualHomePageURL);
		  Assert.assertEquals(actualHomePageURL, expectedHomeURL);
		
	}
	
	@SuppressWarnings("deprecation")
	@Test(groups="Smoke")
	public void clickAndVerifyDownArrowMyAccountWishListAndSignout()
	{
		indexPage  = new IndexPage();
		signInPage = new SignInPage();
		homePage = new HomePage();
		myAccountPage = new MyAccountPage();
		myWishListPage = new MyWishListPage();
		
		//sign-in 
		signInPage = indexPage.clickOnSignIn();
		signInPage.verifySignInPageTitle();
		homePage = signInPage.signInMethod(prop.getProperty("username"), prop.getProperty("password"));
		
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//clicking down-arrow icon
		homePage.clickArrowIcon();
		
		//clicking my account page and validate my page account
		myAccountPage = homePage.clickMyAccount();
		myAccountPage.validateMyAcntPageTitle();
		
		//navigate back to home page
		getDriver().navigate().back();
		
		//clicking down-arrow icon
		homePage.clickArrowIcon();
		
		//clicking  my wish list  and validate my wish list page
		myWishListPage = homePage.clickMyWishList();
		myWishListPage.validateWishListPageTitle();
		
		// navigate back
		getDriver().navigate().back();
		
		//clicking down-arrow icon
		homePage.clickArrowIcon();
		
		//clicking sign-out and validate index page beacause it will automatically redirect back to index page 
		//so no need to give navigate back method
		indexPage = homePage.clickSignOut();
		indexPage.validateIndexPageTitle();
		
		
		
		
		
	}
}
