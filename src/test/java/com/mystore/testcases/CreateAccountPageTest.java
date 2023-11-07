/**
 * 
 */
package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.CreateAccountPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.MyAccountPage;
import com.mystore.pageobjects.MyWishListPage;
import com.mystore.pageobjects.SignInPage;

/**
 * @author Shree Computers
 *
 */
public class CreateAccountPageTest extends BaseClass {
	Action action = new Action();
	IndexPage indexPage;
	SignInPage signInPage;
	HomePage homePage;
	MyAccountPage myAccountPage;
	MyWishListPage myWishListPage;
	CreateAccountPage createAccountPage;
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
	public void validationOfCreateAccountPage()
	{
		indexPage = new IndexPage();
		createAccountPage = new CreateAccountPage();
		
		
		createAccountPage = indexPage.clickOnCreatAccount();
		createAccountPage.validateCreateAccountPage();
		
	}
	
	
//	@Test
//	public void createOfNewAccount()
//	{
//		indexPage = new IndexPage();
//		createAccountPage = new CreateAccountPage();
//		
//		
//		createAccountPage = indexPage.clickOnCreatAccount();
//		
//		//generation of random  firstName,lastName,email,password
//		String firstName = action.generateRandomFirstName();
//        String lastName = action.generateRandomLastName();
//        String email = action.generateRandomEmail();
//        String password = action.generateRandomPassword();
//		createAccountPage.createAccountMethod(firstName, lastName, email, password, password);
//		
//	}
	
	@Test(dataProvider="createAcntDetails",dataProviderClass=DataProviders.class, groups="Smoke")
	public void createOfNewAccount(String firstName,String lastName,String email,String password,String confirmPassword)
	{
		indexPage = new IndexPage();
		createAccountPage = new CreateAccountPage();
		
		
		createAccountPage = indexPage.clickOnCreatAccount();
		
			//generation of random  firstName,lastName,email,password
			//		String firstName = action.generateRandomFirstName();
			//        String lastName = action.generateRandomLastName();
			//        String email = action.generateRandomEmail();
			//        String password = action.generateRandomPassword();
		createAccountPage.createAccountMethod(firstName, lastName, email, password, confirmPassword);
		
	}
	
}
