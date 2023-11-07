/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.CreateAccountPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.MyAccountPage;
import com.mystore.pageobjects.SignInPage;
import com.mystore.utility.Log;

/**
 * @author Shree Computers
 *
 */
public class SignInPageTest extends BaseClass {
	Action action = new Action();
	IndexPage indexPage;
	SignInPage signInPage;
	HomePage homePage;
	CreateAccountPage creatAcntPage;
	MyAccountPage myAcntPage;
	
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
	
	
	
	@Test(dataProvider = "credentials",dataProviderClass=DataProviders.class, groups="Regression")
	public void signInTest(String uname,String password)
	{
		
		Log.startTestCase("signInTest");
		indexPage = new IndexPage();
		signInPage = new SignInPage();
		
		Log.info("User will click on SignIn button");
		signInPage = indexPage.clickOnSignIn();
		Log.info("User will enter user name and password");
		//homePage = signInPage.signInMethod(prop.getProperty("username"),prop.getProperty("password"));
		homePage = signInPage.signInMethod(uname, password);
		
		
		// Add code to navigate back to the home page after login
		//	    driver.get("https://magento.softwaretestingboard.com/");

	    
		String expectedHomeURL = "https://magento.softwaretestingboard.com/";
		String actualHomeURL = homePage.getCurrentUrl();
		
		Log.info("Verifying if user is able to login");
		System.out.println(actualHomeURL);
		Assert.assertEquals(actualHomeURL, expectedHomeURL);
		Log.info("Login success");
		Log.endTestCase("signInTest");
	}
	
	@Test(groups="Sanity")
	public void createNewAccountIfUnableToSignIn()
	{
		indexPage = new IndexPage();
		signInPage = new SignInPage();
		creatAcntPage = new CreateAccountPage();
		myAcntPage = new MyAccountPage();
		
		
		signInPage = indexPage.clickOnSignIn();
		homePage = signInPage.signInMethod(prop.getProperty("InValidUserName"),prop.getProperty("InValidPassword"));
		
		signInPage.getSignInErrorText();
		signInPage.clickCreateNewAccountMethod();
		
		//generation of random  firstName,lastName,email,password
		String firstName = action.generateRandomFirstName();
        String lastName = action.generateRandomLastName();
        String email = action.generateRandomEmail();
        String password = action.generateRandomPassword();
		
		creatAcntPage.createAccountMethod(firstName, lastName, email, password, password);
		
		myAcntPage.validateMyAcntPageTitle();
		
		
	}
}
