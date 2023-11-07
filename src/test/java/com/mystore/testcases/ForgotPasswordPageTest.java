/**
 * 
 */
package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.ForgotPasswordPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SignInPage;

/**
 * @author Shree Computers
 *
 */
public class ForgotPasswordPageTest extends BaseClass	 {

	IndexPage ip ;
	SignInPage sp ;
	ForgotPasswordPage fpp;
	
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
	public void validationOfForgotPasswordPage()
	{
		ip =  new IndexPage();
		sp =  new SignInPage();
		fpp = new ForgotPasswordPage();
		
		sp = ip.clickOnSignIn();
		sp.verifySignInPageTitle();
		
	}
	
	@Test(groups="Smoke")
	public void resetPasswordAndValidateIt()
	{
		ip =  new IndexPage();
		sp =  new SignInPage();
		fpp = new ForgotPasswordPage();
		
		sp = ip.clickOnSignIn();
		sp.verifySignInPageTitle();
		fpp = sp.clickForgotPassword();
		sp = fpp.clickResetPassBtnByEnteringEmail(prop.getProperty("email"));
		sp.validationOfSuccessfulForgotEmailSentMsg();
	}
}
