/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author Shree Computers
 *
 */
public class ForgotPasswordPage  extends BaseClass{

	Action act = new Action();
	
	@FindBy(xpath="//div//h1//span[@class='base']")
	WebElement forgotPageHeading;
	
	@FindBy(id="email_address")
	WebElement emailTextBox;
	
	@FindBy(xpath="//button[@class='action submit primary']")
	WebElement resetMyPasswordBtn;
	
	public ForgotPasswordPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public  boolean validateForgotPassTitle()
	{
		return act.isDisplayed(getDriver(), forgotPageHeading);
	}
	
	public SignInPage clickResetPassBtnByEnteringEmail(String emailForForgotPass)
	{
		act.type(emailTextBox, emailForForgotPass);
		act.click(getDriver(), resetMyPasswordBtn);
		return new SignInPage();
	}
}
