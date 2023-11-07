/**
 * 
 */
package com.mystore.pageobjects;

import java.util.concurrent.TimeUnit;

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
public class SignInPage extends BaseClass {
	Action act = new Action();
	
	@FindBy(xpath = "//h1[@class='page-title']/span")
	WebElement SignInPageTitle;

//	@FindBy(xpath = "//input[@id='email']")
	@FindBy(xpath="(//div[@class='control']//input)[2]")
	WebElement emailTextBox;

//	@FindBy(xpath = "//input[@id='email'][1]")
	@FindBy(xpath="(//div[@class='control']//input)[3]")
	WebElement passwordTextBox;

	@FindBy(xpath = "//fieldset//div[4]//div[1]")
	WebElement loginBtn;

	@FindBy(xpath = "//fieldset//div[4]//div[2]")
	WebElement forgotPassword;

	@FindBy(xpath = "//a[@class='action create primary']")
	WebElement createAccountBtn;
	
	@FindBy(xpath="//input[@id='newsletter']")
	WebElement emailForSubscribe;
	
	@FindBy(xpath="//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	WebElement sigInErrorMsg;
	
	
	@FindBy(xpath="//div[@class='page messages']//div//div//div//div")
	WebElement forgotPasswordMsg;
	
	
	public SignInPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public void verifySignInPageTitle()
	{
		String text = SignInPageTitle.getText();
		System.out.println(text);
	    Assert.assertEquals(text, "Customer Login");
	}
	
	public HomePage signInMethod(String email,String password)
	{
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		act.type(emailTextBox, email);
		act.type(passwordTextBox, password);
		act.click(getDriver(), loginBtn);
		return new HomePage();
	}
	
	public CreateAccountPage clickCreateNewAccountMethod()
	{
		act.click(getDriver(), createAccountBtn);
		return new CreateAccountPage();
	}
	
	public void getSignInErrorText()
	{
		System.out.println(sigInErrorMsg.getText());
	}
	
	public ForgotPasswordPage clickForgotPassword()
	{
		act.click(getDriver(), forgotPassword);
		return new ForgotPasswordPage();
	}
	
	public void validationOfSuccessfulForgotEmailSentMsg() {
		String forgotPasswordMsgText = forgotPasswordMsg.getText();
		Assert.assertEquals(forgotPasswordMsgText, "If there is an account associated with qwertyuiop@gmail.com you will receive an email with a link to reset your password.");
		System.out.println(forgotPasswordMsg);
	}
}
