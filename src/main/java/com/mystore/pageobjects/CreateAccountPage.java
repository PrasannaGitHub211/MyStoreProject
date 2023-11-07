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
public class CreateAccountPage extends BaseClass {

	Action act = new Action();
	
	@FindBy(xpath="//main//div//h1//span")
	WebElement accountCreationPageHeading;
	
	@FindBy(id="firstname")
	WebElement firstNameTextBox;
	
	@FindBy(id="lastname")
	WebElement lastNameTextBox;
	
	@FindBy(xpath="//input[@id='is_subscribed']")
	WebElement checkBox;
	
//	@FindBy(id="email_address")
	@FindBy(xpath="(//div//div//input[@type='email'])[1]")
	WebElement emailTextBox;
	
//	@FindBy(id="password")
	@FindBy(xpath="(//div//div//input[@type='password'])[1]")
	WebElement passwordTextBox;
	
//	@FindBy(id="password-confirmation")
	@FindBy(xpath="(//div//div//input[@type='password'])[2]")
	WebElement confirmPasswordTextBox;
	
	@FindBy(xpath="//button[@title='Create an Account']")
	WebElement createAccountBtn;
	
	public CreateAccountPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public boolean validateCreateAccountPage()
	{
		return act.isDisplayed(getDriver(), accountCreationPageHeading);
	}
	
	public MyAccountPage createAccountMethod(String firstName,String lastName,String email,String pass,String confirmPass)
	{
		act.type(firstNameTextBox, firstName);
		act.type(lastNameTextBox, lastName);
//		act.click(driver, checkBox);
		act.type(emailTextBox, email);
		act.type(passwordTextBox, pass);
		act.type(confirmPasswordTextBox, confirmPass);
		act.click(getDriver(), createAccountBtn);
		
		return new MyAccountPage();
	}
	
	
	
}
