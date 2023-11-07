/**
 * 
 */
package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.MyAccountPage;
import com.mystore.pageobjects.SignInPage;

/**
 * @author Shree Computers
 *
 */
public class MyAccountPageTest extends BaseClass {
	
	IndexPage ip ;
	SignInPage sp;
	HomePage hp;
	MyAccountPage mp;
	
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
	public void validationOfMyAcntPage()
	{
		ip = new IndexPage();
		sp = new SignInPage();
		hp = new HomePage();
		mp = new MyAccountPage();
		
		
		sp = ip.clickOnSignIn();
		hp = sp.signInMethod(prop.getProperty("username"),prop.getProperty("password"));
		hp.clickArrowIcon();
		mp = hp.clickMyAccount();
		mp.validateMyAcntPageTitle();
	}
	
	
	
}
