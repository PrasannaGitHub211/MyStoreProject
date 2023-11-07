/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author Shree Computers
 *
 */
public class MyAccountPage extends BaseClass {

	
	Action act = new Action();
	
	String myAcntPageTitleExpectedText = "My Account";
	
	@FindBy(css=".base")
	WebElement myAcntPageTitle;
	
	
	public MyAccountPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public void  validateMyAcntPageTitle()
	{
		String myAcntPageTitleText = myAcntPageTitle.getText();
		System.out.println(myAcntPageTitleText);
		 Assert.assertEquals(myAcntPageTitleText, myAcntPageTitleExpectedText);
	}
}
